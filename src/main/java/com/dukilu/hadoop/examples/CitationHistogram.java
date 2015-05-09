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

public class CitationHistogram extends Configured implements Tool {

	public static class MapClass extends
			Mapper<Text, Text, IntWritable, IntWritable> {
		private static IntWritable citationCount = new IntWritable();
		private static IntWritable count = new IntWritable(1);

		@Override
		protected void map(Text key, Text value, Context context)
				throws IOException, InterruptedException {
			citationCount.set(Integer.parseInt(value.toString()));
			context.write(citationCount, count);
		}
	}

	public static class ReduceClass extends
			Reducer<IntWritable, IntWritable, IntWritable, IntWritable> {
		@Override
		protected void reduce(IntWritable key, Iterable<IntWritable> values,
				Context context) throws IOException, InterruptedException {
			int count = 0;
			for (IntWritable value : values) {
				count++;
			}
			context.write(key, new IntWritable(count));
		}
	}

	public int run(String[] args) throws Exception {
		Configuration conf = getConf();

		Job job = new Job(conf, "CitationHistogram");

		job.setJarByClass(CitationHistogram.class);
		job.setMapperClass(MapClass.class);
		job.setReducerClass(ReduceClass.class);

		job.setOutputKeyClass(IntWritable.class);
		job.setOutputValueClass(IntWritable.class);

		job.setInputFormatClass(KeyValueTextInputFormat.class);
		job.setOutputFormatClass(TextOutputFormat.class);

		Path in = new Path(args[0]);
		Path out = new Path(args[1]);
		FileInputFormat.setInputPaths(job, in);
		FileOutputFormat.setOutputPath(job, out);

		return job.waitForCompletion(true) ? 0 : 1;
	}

	public static void main(String[] args) throws Exception {
		int res = ToolRunner.run(new Configuration(), new CitationHistogram(),
				args);
		System.exit(res);
	}

}
