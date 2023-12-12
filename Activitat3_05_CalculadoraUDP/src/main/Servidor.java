package main;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class Servidor implements Runnable {
	
	private byte[] buffer = new byte[1024];
	private final int portServidor;
	private final int portClient;
	private InetAddress ipv4Servidor;

	
	public Servidor(int portClient, int portServidor, String ipv4Servidor) {
		System.out.println("Creat el Servidor");
		
		this.portServidor = portServidor;
		this.portClient = portClient;
		
		try {
			this.ipv4Servidor = Inet4Address.getByName(ipv4Servidor);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		String missatge = null;
		
		try {
			DatagramSocket datagramSocket = new DatagramSocket(portServidor);
			DatagramPacket datagramPacket = new DatagramPacket(buffer, buffer.length);
			datagramSocket.receive(datagramPacket);
			missatge = new String(datagramPacket.getData(), "UTF-8");
			if (!datagramSocket.isClosed())
				datagramSocket.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String[] values = readOperation(missatge);
		System.out.printf("%sOperació a calcular { %s %s %s = %s }\n", 
				Thread.currentThread().getName(), 
				values[0], values[1], values[2], calcular(values))
		;
		
		
	}
	
	private float calcular(String[] values) {
		float result = 0;
		int n1 = Integer.valueOf(values[0]);
		String op = values[1];
		int n2 = Integer.valueOf(values[2]);
		switch (op) {
			case "+" -> result = Math.addExact(n1, n2);
			case "-" -> result = Math.subtractExact(n1, n2);
			case "*" -> result = Math.multiplyExact(n1, n2);
			case "/" -> result = Math.floorDiv(n1, n2);
 		}
		return result;
	}
	
	private String[] readOperation(String operation) {
		return operation.split(",");
	}

}
