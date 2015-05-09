package com.dukilu.hadoop.examples;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.KeyValueTextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

public class MyJob_Counter extends Configured implements Tool {

	public static class MapClass extends Mapper<Text, Text, Text, Text> {
		@Override
		protected void map(Text key, Text value, Context context)
				throws IOException, InterruptedException {
			context.write(value, key);
		}
	}

	public static class ReduceClass extends
			Reducer<Text, Text, Text, IntWritable> {
		@Override
		protected void reduce(Text key, Iterable<Text> values, Context context)
				throws IOException, InterruptedException {
			int count = 0;
			for (Text value : values) {
				count++;
			}
			context.write(key, new IntWritable(count));
		}
	}

	public int run(String[] args) throws Exception {
		Configuration conf = getConf();
		conf.set(
				"mapreduce.input.keyvaluelinerecordreader.key.value.separator",
				",");
		conf.set("mapred.reduce.tasks", "8");
		Job job = new Job(conf, "MyJob_Counter");

		job.setJarByClass(MyJob_Counter.class);
		job.setMapperClass(MapClass.class);
		job.setReducerClass(ReduceClass.class);

		job.setOutputKeyClass(Text.class); // set map phase output key
		job.setOutputValueClass(Text.class);// set map phase output value

		Path in = new Path(args[0]);
		Path out = new Path(args[1]);

		FileInputFormat.setInputPaths(job, in);
		FileOutputFormat.setOutputPath(job, out);

		job.setInputFormatClass(KeyValueTextInputFormat.class);
		job.setOutputFormatClass(TextOutputFormat.class);

		return job.waitForCompletion(true) ? 0 : 1;
	}

	public static void main(String[] args) throws Exception {
		int res = ToolRunner
				.run(new Configuration(), new MyJob_Counter(), args);
		System.exit(res);
	}
}
