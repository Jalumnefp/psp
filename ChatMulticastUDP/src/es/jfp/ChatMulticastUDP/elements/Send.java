package es.jfp.ChatMulticastUDP.elements;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;

import es.jfp.ChatMulticastUDP.Main;

public class Send implements Runnable {
	
	private InetAddress ip;
	private int port;
	private String msg;
	
	public Send(String msg) {
		this.msg = msg;
		this.port = Main.portMulticast;
		try {
			this.ip = InetAddress.getByName("230.0.0.1");
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
				
		send();
		
	}
	
	private synchronized void send() {
		try (MulticastSocket multicastSocket = new MulticastSocket(port)) {
			
			multicastSocket.joinGroup(ip);
	
			System.out.printf("%s Enviant missatge: %s%n", Thread.currentThread().getName(), msg);
			
			byte[] msgb = msg.getBytes(StandardCharsets.UTF_8);
			
			DatagramPacket datagramPacket = new DatagramPacket(msgb, msgb.length, ip, port);
			
			multicastSocket.send(datagramPacket);
			
			multicastSocket.leaveGroup(ip);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
