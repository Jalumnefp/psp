package example;

import java.util.Stack;

public class Monitor {
	
	private int tamanyVector;
		
	
	private Stack<Integer> productes = new Stack<Integer>();;
	
	public Monitor(int tempsEsperaAccio, int tamanyVector) {
		this.tamanyVector = tamanyVector;
		System.out.printf("[%s] Creació d'un monitor amb buffer de %s\n", Thread.currentThread().getName(), tamanyVector);
	}
	

	
	public synchronized int consumir() {
		int valor = -1;
		try {
			
			while(productes.isEmpty()) {
				System.err.printf("[%s] <Dada BUIDA: Espera per AGAFAR element>\n", Thread.currentThread().getName());
				wait();
			}
			
			valor = productes.pop();
			
			for (int x = 0; x < 10000000; x++) {
				
			}
			
			//System.err.printf("[%s] <Dada BUIDA: Despertar PRODUCTOR per produir element>\n", Thread.currentThread().getName());
			notifyAll();
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return(valor);
	}
	
	public synchronized void produir(int num) {
		try {
			
			while(productes.size() == this.tamanyVector) {
				System.err.printf("[%s] <Dada PLENA: Espera per DEIXAR element>\n", Thread.currentThread().getName());
				wait();
			}
			
			productes.push(num);
			
			//Thread.sleep((int)(Math.random()*tempsEsperaAccio));
			
			//System.err.printf("[%s] <Dada PLENA: Despertar CONSUMIDOR per consumir element>\n", Thread.currentThread().getName());
			notifyAll();
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
