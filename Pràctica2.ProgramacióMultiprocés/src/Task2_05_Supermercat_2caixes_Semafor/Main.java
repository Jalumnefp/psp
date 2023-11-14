package Task2_05_Supermercat_2caixes_Semafor;

import java.util.LinkedList;
import java.util.List;

public class Main {
	
	public static void main(String[] args) throws InterruptedException {
		
		final Caixa caixa1 = new Caixa("Caixa1");
		final Caixa caixa2 = new Caixa("Caixa2");
		List<Thread> clients = new LinkedList<>();
		
		for (int x = 1; x <= 4; x++) {
			Caixa caixa = x % 2 != 0 ? caixa1 : caixa2;
			clients.add(new Thread(new Client(caixa), "Client" + x));
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
