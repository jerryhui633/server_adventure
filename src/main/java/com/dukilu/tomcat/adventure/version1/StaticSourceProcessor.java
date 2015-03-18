package com.dukilu.tomcat.adventure.version1;

import java.io.IOException;

public class StaticSourceProcessor {

	public void process(Request request, Response response) {
		try {
			response.sendStaticResource();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
