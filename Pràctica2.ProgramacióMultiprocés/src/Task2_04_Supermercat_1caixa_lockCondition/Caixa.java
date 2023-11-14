package Task2_04_Supermercat_1caixa_lockCondition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Caixa {
	
	private String nom;
	private boolean ocupat = false;
	private Lock chain = new ReentrantLock();
	private Condition condition = chain.newCondition();
	
	public Caixa(String nom) {
		this.nom = nom;
	}
	
	public void agafaCompra() throws InterruptedException {
		System.out.printf("[%s] Llegint la compra de %s\n", nom, Thread.currentThread().getName());
		
		Thread.sleep(500);
	}
	
	public void cobramentCompra(float preu) throws InterruptedException {
		
		while (ocupat) {
			System.out.printf("[%s] La Caixa NO està disponible, dorm zZzZzZ...\n", Thread.currentThread().getName());
			
			chain.lock();
			condition.await();
			chain.unlock();
			
		}
		
		ocupat = true;
		
		System.out.printf("[%s] Import de la compra de %s és de %.2f€\n", nom, Thread.currentThread().getName(), preu);
		
		Thread.sleep(500);
		
	}
	
	public void ticketCompra() throws InterruptedException {
		
		System.out.printf("[%s] Donant ticket compra a %s\n", nom, Thread.currentThread().getName());
		Thread.sleep(500);
		ocupat = false;
		
		chain.lock();
		condition.signal();
		chain.unlock();
		

		System.out.printf("[%s] La Caixa ja està disponible, desperta fils...\n", nom, Thread.currentThread().getName());		
		Thread.sleep(500);
		
	}
	
	public String getNom() {
		return this.nom;
	}

}
