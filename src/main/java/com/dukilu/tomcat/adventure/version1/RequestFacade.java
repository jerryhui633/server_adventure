package com.dukilu.tomcat.adventure.version1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletRequest;

public class RequestFacade implements ServletRequest {
	private Request request;

	public RequestFacade(Request request) {
		this.request = request;
	}

	public Object getAttribute(String arg0) {
		return request.getAttribute(arg0);
	}

	public Enumeration getAttributeNames() {
		return request.getAttributeNames();
	}

	public String getCharacterEncoding() {
		return request.getCharacterEncoding();
	}

	public int getContentLength() {
		return request.getContentLength();
	}

	public String getContentType() {

		return request.getContentType();
	}

	public ServletInputStream getInputStream() throws IOException {

		return request.getInputStream();
	}

	public String getLocalAddr() {

		return request.getLocalAddr();
	}

	public String getLocalName() {

		return request.getLocalName();
	}

	public int getLocalPort() {

		return request.getLocalPort();
	}

	public Locale getLocale() {

		return request.getLocale();
	}

	public Enumeration getLocales() {

		return request.getLocales();
	}

	public String getParameter(String arg0) {

		return request.getParameter(arg0);
	}

	public Map getParameterMap() {

		return request.getParameterMap();
	}

	public Enumeration getParameterNames() {

		return request.getParameterNames();
	}

	public String[] getParameterValues(String arg0) {

		return request.getParameterValues(arg0);
	}

	public String getProtocol() {

		return request.getProtocol();
	}

	public BufferedReader getReader() throws IOException {

		return request.getReader();
	}

	public String getRealPath(String arg0) {

		return request.getRealPath(arg0);
	}

	public String getRemoteAddr() {

		return request.getRemoteAddr();
	}

	public String getRemoteHost() {

		return request.getRemoteHost();
	}

	public int getRemotePort() {

		return request.getRemotePort();
	}

	public RequestDispatcher getRequestDispatcher(String arg0) {

		return request.getRequestDispatcher(arg0);
	}

	public String getScheme() {

		return request.getScheme();
	}

	public String getServerName() {

		return request.getServerName();
	}

	public int getServerPort() {

		return request.getServerPort();
	}

	public boolean isSecure() {

		return request.isSecure();
	}

	public void removeAttribute(String arg0) {
		request.removeAttribute(arg0);
	}

	public void setAttribute(String arg0, Object arg1) {
		request.setAttribute(arg0, arg1);
	}

	public void setCharacterEncoding(String arg0) throws UnsupportedEncodingException {
		request.setCharacterEncoding(arg0);
	}

}
