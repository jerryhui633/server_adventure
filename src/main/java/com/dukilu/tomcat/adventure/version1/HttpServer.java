package com.dukilu.tomcat.adventure.version1;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpServer {

	private static final String SHUTDOWN_COMMAD = "/shutdown";

	private boolean shutdown = false;

	public void await() {
		int port = 8080;
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(port, 1, InetAddress.getByName("127.0.0.1"));
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(-1);
		}
		while (!shutdown) {
			Socket socket = null;
			InputStream is = null;
			OutputStream os = null;
			try {
				socket = serverSocket.accept();
				is = socket.getInputStream();
				os = socket.getOutputStream();

				Request request = new Request(is);
				request.parse();

				Response response = new Response(os);
				response.setRequest(request);

				if (request.getUri().startsWith("/servlet/")) {
					ServletProcessor processor = new ServletProcessor();
					processor.process(request, response);
				} else {
					StaticSourceProcessor processor = new StaticSourceProcessor();
					processor.process(request, response);
				}
				socket.close();
				shutdown = request.getUri().equals(SHUTDOWN_COMMAD);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

	}

	public static void main(String[] args) {
		HttpServer server = new HttpServer();
		server.await();
	}

}
