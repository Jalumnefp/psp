package Task2_04_Supermercat_1caixa_lockCondition;

import java.util.LinkedList;
import java.util.List;

public class Main {
	
	public static void main(String[] args) throws InterruptedException {
		
		final Caixa caixa = new Caixa("CAIXA");
		List<Thread> clients = new LinkedList<>();
		
		for (int x = 1; x <= 4; x++) {
			clients.add(new Thread(new Client(caixa), "Client " + x));
		}
		
		for (Thread client: clients) {
			client.start();
		}
		
		for (Thread client: clients) {
			client.join();
		}	 
		
		System.out.printf("[%s] Finalització fil ppal", Thread.currentThread().getName());
		
	}

}
