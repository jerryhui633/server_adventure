package com.dukilu.tomcat.adventure.version1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletRequest;

public class Request implements ServletRequest {

	private InputStream is;
	private String uri;

	public Request(InputStream is) {
		this.is = is;
	}

	public void parse() {
		StringBuffer request = new StringBuffer(2048);
		int i;
		byte[] buffer = new byte[2048];
		try {
			/*while ((i = is.read(buffer)) != -1) {
				for (int j = 0; j < i; j++) {
					request.append((char) buffer[j]);
				}
			}*/
			// just read one time from buffer
			i = is.read(buffer);
			for (int j = 0; j < buffer.length; j++) {
				request.append((char) buffer[j]);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("request string:" + request.toString());
		uri = parseUri(request.toString());
	}

	public String parseUri(String requestString) {
		int index1, index2;
		index1 = requestString.indexOf(" ");
		if (index1 != -1) {
			index2 = requestString.indexOf(" ", index1 + 1);
			if (index2 > index1) {
				return requestString.substring(index1 + 1, index2);
			}
		}
		return null;
	}

	public String getUri() {
		return uri;
	}

	public Object getAttribute(String arg0) {

		return null;
	}

	public Enumeration getAttributeNames() {

		return null;
	}

	public String getCharacterEncoding() {

		return null;
	}

	public int getContentLength() {

		return 0;
	}

	public String getContentType() {

		return null;
	}

	public ServletInputStream getInputStream() throws IOException {

		return null;
	}

	public String getLocalAddr() {

		return null;
	}

	public String getLocalName() {

		return null;
	}

	public int getLocalPort() {

		return 0;
	}

	public Locale getLocale() {

		return null;
	}

	public Enumeration getLocales() {

		return null;
	}

	public String getParameter(String arg0) {

		return null;
	}

	public Map getParameterMap() {

		return null;
	}

	public Enumeration getParameterNames() {

		return null;
	}

	public String[] getParameterValues(String arg0) {

		return null;
	}

	public String getProtocol() {

		return null;
	}

	public BufferedReader getReader() throws IOException {

		return null;
	}

	public String getRealPath(String arg0) {

		return null;
	}

	public String getRemoteAddr() {

		return null;
	}

	public String getRemoteHost() {

		return null;
	}

	public int getRemotePort() {

		return 0;
	}

	public RequestDispatcher getRequestDispatcher(String arg0) {

		return null;
	}

	public String getScheme() {

		return null;
	}

	public String getServerName() {

		return null;
	}

	public int getServerPort() {

		return 0;
	}

	public boolean isSecure() {

		return false;
	}

	public void removeAttribute(String arg0) {

	}

	public void setAttribute(String arg0, Object arg1) {

	}

	public void setCharacterEncoding(String arg0) throws UnsupportedEncodingException {

	}

}
