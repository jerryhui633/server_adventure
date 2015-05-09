package com.dukilu.hadoop.examples;

import org.apache.hadoop.io.Writable;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.Partitioner;

public class EdgePartitioner implements Partitioner<Edge, Writable> {

	public void configure(JobConf conf) {

	}

	public int getPartition(Edge edge, Writable value, int numPartitions) {
		return new Long(edge.getDepartureNode()).hashCode() % numPartitions;
	}

}
