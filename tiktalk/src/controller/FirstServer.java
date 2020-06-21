package controller;
import java.io.*;
import java.net.*;
import java.sql.SQLException;
import java.sql.*;
public class FirstServer
{
	private String ip = "localhost";
	private ServerSocket ss;
	
	
	public void connect(String ip) {
		try {
			//the server socket is defined only by a port (its IP is localhost)

			ss = new ServerSocket (1000);
			
			
			System.out.println("Server waiting for connection...");
			while (true) {

				Socket socket = ss.accept();//establishes connection
				
				System.out.println("Connected as " + ip);
				// create a new thread to handle client socket
				new InitialServer(socket).start();
				
			}
			
		} catch (IOException ioe) {
			ioe.printStackTrace();
			//if IOException close the server socket
			if (ss != null && !ss.isClosed()) {
				try {
					ss.close();
				} catch (IOException e) {
					e.printStackTrace(System.err);
				}
			}
		}
	}
	public void newServerThread(int port) throws IOException {

	}

	
	public static void main(String[] args) throws SQLException {
		FirstServer fs = new FirstServer();
		fs.connect("localhost");
	}
}
