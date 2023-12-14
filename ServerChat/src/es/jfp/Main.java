package es.jfp;

import servidor.ServidorChat;

public class Main {
	
	public static void main(String[] args) {
		Thread serverThread = new Thread(new ServidorChat(), "[Servidor]");
		serverThread.start();
	}

}
