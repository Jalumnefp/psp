package main;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client implements Runnable {
	
	private final Scanner sc = new Scanner(System.in);
	private byte[] buffer;
	private final int portServidor;
	private InetAddress ipv4Servidor;
	
	public Client(int portServidor, String ipv4Servidor) {
		System.out.println("Creat el Client");
		
		this.portServidor = portServidor;
		
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
		String missatge = formatOperation();
		this.buffer = missatge.getBytes();
		
		try (DatagramSocket datagramSocket = new DatagramSocket()) {
			DatagramPacket datagramPacket = new DatagramPacket(buffer, buffer.length, ipv4Servidor, portServidor);
			datagramSocket.send(datagramPacket);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private String formatOperation() {
		StringBuilder operation = new StringBuilder();
		int[] values = askOperation();
		operation.append(values[0]).append(',');
		operation.append(getOperation(values[1])).append(',');
		operation.append(values[2]);
		System.out.printf("%sEnviar operació [ %s %s %s ]\n", Thread.currentThread().getName(), values[0], getOperation(values[1]), values[2]);
		return operation.toString();
	}
	
	private int[] askOperation() {
		System.out.print("Operació: \n  1. Sumar\n  2.Restar\n  3.Multiplicar\n  4.Dividir\nResposta: ");
		int op = sc.nextInt();
		
		System.out.print("Número 1: ");
		int n1 = sc.nextInt();
		
		System.out.print("Número 2: ");
		int n2 = sc.nextInt();
				
		return new int[] {n1, op, n2};
	}
	
	private char getOperation(int idOp) {
		char resOp = 'E';
		switch(idOp) {
			case 1 -> resOp = '+';
			case 2 -> resOp = '-';
			case 3 -> resOp = '*';
			case 4 -> resOp = '/';
			default -> resOp = 'N';
		}
		return resOp;
	}
	
	

}
