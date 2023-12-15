package es.jfp;

import es.jfp.elements.AppFrame;
import servidor.ServidorChat;

public class Main {
	
	public static void main(String[] args) {
		Thread serverThread = new Thread(new ServidorChat(), "[Servidor]");
		serverThread.start();
		AppFrame appFrame = new AppFrame();
		appFrame.setVisible(true);
	}

}
