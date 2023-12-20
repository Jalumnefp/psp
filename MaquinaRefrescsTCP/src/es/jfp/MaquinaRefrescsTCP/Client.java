package es.jfp.MaquinaRefrescsTCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client implements Runnable {
	
	private final Scanner sc = new Scanner(System.in);
	private InetAddress ipDesti;
	private int portServidor;
	
	public Client(int portServidor) {
		this.portServidor = portServidor;
		try {
			this.ipDesti = InetAddress.getByName("localhost");
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.printf("%s Cantitat de refrescos: ", Thread.currentThread().getName());
		int cantitat = sc.nextInt();
		
		try (
				Socket socketClient = new Socket(ipDesti, portServidor);
				DataOutputStream dos = new DataOutputStream(socketClient.getOutputStream());
				DataInputStream dis = new DataInputStream(socketClient.getInputStream())
		) {
			
			dos.write(cantitat);
			
			System.out.println(dis.readUTF());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
