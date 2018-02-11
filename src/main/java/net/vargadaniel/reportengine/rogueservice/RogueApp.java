package net.vargadaniel.reportengine.rogueservice;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class RogueApp {

    public static void main(String[] args) throws Exception {
    		ServerSocket server = new ServerSocket(8000); 
    		try {
    			System.out.println("Listening for connection on port 8000 ...."); 
	    		while (true) {
	    			Socket clientSocket = server.accept(); 
	    			try {
			    		InputStreamReader isr = new InputStreamReader(clientSocket.getInputStream()); 
			    		BufferedReader reader = new BufferedReader(isr); 
			    		String line = reader.readLine(); 
			    		while (!line.isEmpty()) { 
			    			System.out.println(line); 
			    			line = reader.readLine(); 
			    		} 
			    		String httpResponse = "HTTP/1.1 200 OK"; 
			    		clientSocket.getOutputStream().write(httpResponse.getBytes("UTF-8"));
			    		clientSocket.getOutputStream().flush();
			    		clientSocket.getOutputStream().close();
	    			} finally {
	    				clientSocket.close();
	        		}   		
	    		}
    		} finally {
    			server.close();
    		}
    }


}