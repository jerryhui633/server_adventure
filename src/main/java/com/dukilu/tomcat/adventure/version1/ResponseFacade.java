package com.dukilu.tomcat.adventure.version1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;

import javax.servlet.ServletOutputStream;
import javax.servlet.ServletResponse;

public class ResponseFacade implements ServletResponse {

	private Response response;

	public ResponseFacade(Response response) {
		this.response = response;
	}

	public void flushBuffer() throws IOException {
		response.flushBuffer();

	}

	public int getBufferSize() {
		return response.getBufferSize();
	}

	public String getCharacterEncoding() {
		return response.getCharacterEncoding();
	}

	public String getContentType() {
		return response.getContentType();
	}

	public Locale getLocale() {
		return response.getLocale();
	}

	public ServletOutputStream getOutputStream() throws IOException {
		return response.getOutputStream();
	}

	public PrintWriter getWriter() throws IOException {
		return response.getWriter();
	}

	public boolean isCommitted() {
		return response.isCommitted();
	}

	public void reset() {
		response.reset();
	}

	public void resetBuffer() {
		response.resetBuffer();
	}

	public void setBufferSize(int arg0) {
		response.setBufferSize(arg0);
	}

	public void setCharacterEncoding(String arg0) {
		response.setCharacterEncoding(arg0);
	}

	public void setContentLength(int arg0) {
		response.setContentLength(arg0);
	}

	public void setContentType(String arg0) {
		response.setContentType(arg0);
	}

	public void setLocale(Locale arg0) {
		response.setLocale(arg0);
	}

}
