package example;

import java.util.LinkedList;
import java.util.List;

public class Main {
	public static void main(String[] args) throws InterruptedException {
		Pont pont = new Pont();
		List<Thread> cotxes = new LinkedList<>();
		
		
		for (int x = 0; x < 8; x++) {
			boolean orientacio = false;
			if (x % 2 != 0) {
				orientacio = true;
			}
			cotxes.add(new Thread(new Cotxe(pont, orientacio), "Cotxe "+(x+1)));
		}
		
		for (Thread cotxe: cotxes) {
			cotxe.start();
		}
		
	}

}
