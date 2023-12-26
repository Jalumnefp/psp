package es.jfp.MaquinaRefrescsTCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

public class Servidor implements Runnable {
	
	private Màquina màquina;
	private int portServidor;
	private int nclients;
	
	public Servidor(int portServidor, int clients) {		this.nclients = clients; System.out.println(clients);
		this.màquina = new Màquina();
		this.portServidor = portServidor; 
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		for (int i = 0; i < nclients; i++) {
			
			if (this.màquina.getRefrescsLen() == 0) { break; }
			
			String resposta = null;
			
			try (
					ServerSocket serverSocket = new ServerSocket(portServidor);
					Socket socketClient = serverSocket.accept();
					DataInputStream dataInputStream = new DataInputStream(socketClient.getInputStream());
					DataOutputStream dataOutputStream = new DataOutputStream(socketClient.getOutputStream())
					
			) {
					
				int cant = dataInputStream.read();
				
				if (this.màquina.getRefrescsLen()==0) {
					resposta = "[Servidor] No quedan refrescos!";
				} else if (this.màquina.getRefrescsLen()<cant) {
					resposta = "[Servidor] No quedan suficientes refrescos!";
				} else {
					resposta = màquina.consumirRefrescos(cant);
					System.out.printf("%s Petición del cliente -> %s --- %s%n", Thread.currentThread().getName(), socketClient.getInetAddress(), socketClient.getPort());
					System.out.printf("%s A la màquina le quedan: %s refrescos%n", Thread.currentThread().getName(), this.màquina.getRefrescsLen());
				}
				
				dataOutputStream.writeUTF(resposta);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		if (this.màquina.getRefrescsLen()==0) {
			System.out.println("[Servidor] No quedan refrescos!");
		}
				
	}

}
