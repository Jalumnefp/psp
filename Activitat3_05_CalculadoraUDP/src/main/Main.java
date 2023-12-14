package main;

import java.util.LinkedList;
import java.util.List;

public class Main {
	
	public static void main(String[] args) {
		
		final List<Thread> threads = new LinkedList<>();
		
		threads.add(new Thread(new Servidor(10000), "[Servidor] "));
		threads.add(new Thread(new Client(10000, "127.0.0.1"), "[Client1] "));
		
		for(Thread thread: threads) {
			thread.start();
		}
		
		for(Thread thread: threads) {
			try {
				thread.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println("Programa Finalitzat");
		
	}

}
