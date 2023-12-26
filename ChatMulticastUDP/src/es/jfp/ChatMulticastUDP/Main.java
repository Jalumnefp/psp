package es.jfp.ChatMulticastUDP;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Main {
	
	public static int portMulticast;
	
	public static void main(String[] args) {
		List<Thread> clients = new LinkedList<>();
		portMulticast = Integer.valueOf(JOptionPane.showInputDialog("Puerto multicast"));
		int num = Integer.valueOf(JOptionPane.showInputDialog("Cuantos clientes quieres crear?"));
				
		for (int i = 1; i <= num; i++) {
			String nick = JOptionPane.showInputDialog("Introduce el nick del cliente " + i);
			clients.add(new Thread(new Client(nick, portMulticast), "[Client" + i + ']'));
		}
				
		for (Thread cli: clients) {
			cli.start();
			try {
				cli.join(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		for (Thread cli: clients) {
			try {
				cli.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
				
		System.out.printf("[%s] Finalització del programa", Thread.currentThread().getName());
		
	}

}
