package com.dukilu.hadoop.examples;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.WritableComparable;

public class Edge implements WritableComparable<Edge> {

	private String departureNode;
	private String arrivalNode;

	public void write(DataOutput out) throws IOException {
		out.writeUTF(departureNode);
		out.writeUTF(arrivalNode);
	}

	public void readFields(DataInput in) throws IOException {
		this.departureNode = in.readUTF();
		this.arrivalNode = in.readUTF();
	}

	public int compareTo(Edge o) {
		return (departureNode.compareTo(o.getDepartureNode()) == 0) ? arrivalNode
				.compareTo(o.getArrivalNode()) : departureNode.compareTo(o
				.getDepartureNode());
	}

	public String getArrivalNode() {
		return arrivalNode;
	}

	public String getDepartureNode() {
		return departureNode;
	}

	public void setArrivalNode(String arrivalNode) {
		this.arrivalNode = arrivalNode;
	}

	public void setDepartureNode(String departureNode) {
		this.departureNode = departureNode;
	}

}
