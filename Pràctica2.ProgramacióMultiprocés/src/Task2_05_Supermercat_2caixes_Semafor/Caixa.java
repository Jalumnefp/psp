package Task2_05_Supermercat_2caixes_Semafor;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Caixa {
	
	private String nom;
	private boolean ocupat1 = false;
	private boolean ocupat2 = false;
	private Semaphore semafor = new Semaphore(2);
	
	public Caixa(String nom) {
		this.nom = nom;
		System.out.println("Oberta la caixa " + nom);
	}
	
	public void agafaCompra() throws InterruptedException {
		System.out.printf("<%s> Llegint la compra de %s\n", nom, Thread.currentThread().getName());
		
	}
	
	public void cobramentCompra(float preu) throws InterruptedException {		

		Thread.sleep(500);
		if (nom.equals("Caixa1")) {
			while (ocupat1) {
				System.out.printf("[%s] La %s NO està disponible, dorm zZzZzZ...\n", Thread.currentThread().getName(), nom);
				
				semafor.acquire();
				
			}
			ocupat1 = true;
			
		} else if (nom.equals("Caixa2")) {
			while (ocupat2) {
				System.out.printf("[%s] La %s NO està disponible, dorm zZzZzZ...\n", Thread.currentThread().getName(), nom);
				
				semafor.acquire();
				
			}
			ocupat2 = true;
			
		}
		
		
		System.out.printf("<%s> Import de la compra de %s és de %.2f€\n", nom, Thread.currentThread().getName(), preu);
		
		
	}
	
	public void ticketCompra() throws InterruptedException {
		
		System.out.printf("<%s> Donant ticket compra a %s\n", nom, Thread.currentThread().getName());

		if (nom.equals("Caixa1")) {
			ocupat1 = false;
			semafor.release();
		}
		else {
			ocupat2 = false;
			semafor.release();
		}

		System.out.printf("<%s> La Caixa ja està disponible, desperta fils...\n", nom, Thread.currentThread().getName());		
		
	}
	
	public String getNom() {
		return this.nom;
	}
	

}
