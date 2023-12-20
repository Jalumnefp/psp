package es.jfp.MaquinaRefrescsTCP;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		final Scanner sc = new Scanner(System.in);
		List<Thread> clients = new LinkedList<>();
		System.out.print("Número de clients: ");
		int num = sc.nextInt();
		
		Thread servidor = new Thread(new Servidor(10000), "[Servidor]");
		
		for (int i = 1; i <= num; i++) {
			clients.add(new Thread(new Client(10000), "[Client" + i + ']'));
		}
		
		servidor.start();
		
		try {
			for (Thread cli: clients) {
				cli.start();
				cli.join();
				if (!servidor.isAlive()) {
					break;
				}
			}
			servidor.interrupt();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		System.out.printf("[%s] Finalització del programa", Thread.currentThread().getName());
		
	}
}
