package com.dukilu.hadoop.examples;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

public class PutMerge {

	public static void main(String[] args) throws IOException {
		Configuration conf = new Configuration();

		FileSystem hdfs = FileSystem.get(conf);
		FileSystem local = FileSystem.getLocal(conf);

		Path inputDir = new Path(args[0]);
		Path hdfsFile = new Path(args[1]);

		FileStatus[] inputFiles = local.listStatus(inputDir);
		FSDataOutputStream out = hdfs.create(hdfsFile);

		for (FileStatus file : inputFiles) {
			System.out.println(file.getPath().getName());
			FSDataInputStream in = local.open(file.getPath());

			byte[] buffer = new byte[512];
			int readByte = 0;
			while ((readByte = in.read(buffer)) > 0) {
				out.write(buffer, 0, readByte);
			}
			in.close();
		}
		out.close();
	}
}
