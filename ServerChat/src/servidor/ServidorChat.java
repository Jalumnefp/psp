package servidor;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;

import es.jfp.elements.ChatPanel;

public class ServidorChat implements Runnable {
	
	private byte[] buffer = new byte[1024];
	private int serverPort = 10000;
	
	public ServidorChat() {
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		System.out.printf("%s %s escoltant el port %d\n", Thread.currentThread().getName(), "127.0.0.1", serverPort);
		
		while (true) {
			String missatge = null;
			
			try (DatagramSocket datagramSocket = new DatagramSocket(serverPort)) {
				DatagramPacket datagramPacket = new DatagramPacket(buffer, buffer.length);
				datagramSocket.receive(datagramPacket);
				missatge = new String(datagramPacket.getData(), 0, datagramPacket.getLength(), StandardCharsets.UTF_8);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			ChatPanel.chatTextArea.append(missatge + '\n');
		}
		
			
		
	}

}
