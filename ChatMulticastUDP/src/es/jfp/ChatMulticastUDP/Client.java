package es.jfp.ChatMulticastUDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;
import java.net.NetworkInterface;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import es.jfp.ChatMulticastUDP.elements.ClientFrame;
import es.jfp.ChatMulticastUDP.elements.Send;

public class Client implements Runnable {
	
	private boolean listening = true;
	
	private ClientFrame ui;
	private String nick;
	private InetAddress ipMulticast;
	private int portClient;
	private byte[] buffer = new byte[1024];
	
	public Client(String nick, int portClient) {
		this.ui = new ClientFrame(this);
		this.nick = nick;
		this.portClient = portClient;
		try {
			this.ipMulticast = InetAddress.getByName("230.0.0.1");
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
			
		ui.setTitle("VENTANA DE CHAT UDP - Nick: " + nick);
		ui.setVisible(true);
		ui.setUserNick(nick);
		new Thread(new Send(String.format("*** %s s'ha unit al xat ***", nick)), "[SendJoin-Thread]").start();
		
		while (listening) {
			listen();
		}
	
	}

	private void listen() {
		
		String msg = null;
		
		try (MulticastSocket multicastSocket = new MulticastSocket(portClient)) {
			
			multicastSocket.joinGroup(ipMulticast);
			
			DatagramPacket datagramPacket = new DatagramPacket(buffer, buffer.length);
			
			multicastSocket.receive(datagramPacket);
			
			msg = new String(datagramPacket.getData(), 0, datagramPacket.getLength(), StandardCharsets.UTF_8);
			
			System.out.printf("%s Rebent missatge: %s%n", Thread.currentThread().getName(), msg);
			
			ui.appendChatTextArea(msg);
			
			multicastSocket.leaveGroup(ipMulticast);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getNickName() {
		return this.nick;
	}
	
	public void stopListening() {
		ui.dispose();
		new Thread(new Send(String.format("*** %s ha abandonat el xat ***", nick)), "[SendExit-Thread]").start();
		this.listening = false;
		JOptionPane.showMessageDialog(null, "FINALITZACIÓ!");

	}

}
