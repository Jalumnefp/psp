package es.jfp.controllers;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

import es.jfp.elements.ChatPanel;

public class Send implements Runnable {
	
	private byte[] buffer = new byte[1024];
	private int serverPort = 10000;
	private InetAddress loopback;
	
	public Send() {
		
		try {
			this.loopback = InetAddress.getByName("127.0.0.1");
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		String missatge = formatMessage();
		buffer = missatge.getBytes();
		
		try (DatagramSocket datagramSocket = new DatagramSocket()) {
			DatagramPacket datagramPacket = new DatagramPacket(buffer, buffer.length, loopback, serverPort);
			datagramSocket.send(datagramPacket);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Sending");
		
	}
	
	private String formatMessage() {
		StringBuilder message = new StringBuilder();
		message.append('[');
		message.append(ChatPanel.userTextField.getText());
		message.append("] ");
		message.append(ChatPanel.messageTextField.getText());
		return message.toString();
	}
	
	

}
