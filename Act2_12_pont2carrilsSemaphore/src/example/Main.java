package example;

import java.util.LinkedList;
import java.util.List;

public class Main {
	public static void main(String[] args) throws InterruptedException {
		Pont pont = new Pont();
		List<Thread> cotxes = new LinkedList<>();
		boolean orientacio;
		
		System.out.printf("[%s] Creant cotxes amb semàfor...\n", Thread.currentThread().getName());
		
		for (int x = 0; x < 5; x++) {
			orientacio = false;
			if (x % 2 != 0) {
				orientacio = true;
			}
			cotxes.add(new Thread(new Cotxe(pont, orientacio), "Cotxe "+(x+1)));
		}
		
		for (Thread cotxe: cotxes) {
			cotxe.start();
			
		}
				
		Thread.currentThread();
		while(Thread.activeCount() != 1) {}
		
		System.out.println("[ppal] Finalització.");
		
		
		
		
	}

}
