package Task2_03_Supermercat_1caixa_waitNotify;

public class Caixa {
	
	private String nom;
	private boolean ocupat = false;
	
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
			synchronized (this) {
				wait();
			}
		}
		
		ocupat = true;
		
		System.out.printf("[%s] Import de la compra de %s és de %.2f€\n", nom, Thread.currentThread().getName(), preu);
		
		Thread.sleep(500);
		
	}
	
	public void ticketCompra() throws InterruptedException {
		
		System.out.printf("[%s] Donant ticket compra a %s\n", nom, Thread.currentThread().getName());
		Thread.sleep(500);
		ocupat = false;
		synchronized (this) {
			notify();
		}
			
		System.out.printf("[%s] La Caixa ja està disponible, desperta fils...\n", nom, Thread.currentThread().getName());
		Thread.sleep(500);
		
	}
	
	public String getNom() {
		return this.nom;
	}

}
