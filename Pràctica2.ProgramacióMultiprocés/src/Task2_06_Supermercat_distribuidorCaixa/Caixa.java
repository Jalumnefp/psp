package Task2_06_Supermercat_distribuidorCaixa;

import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Caixa {
	
	private String nom;
	private boolean disponible = true;
	
	public Caixa(String nom) {
		this.nom = nom;
		System.out.println("Oberta la caixa " + nom);
	}
	
	public void agafaCompra() throws InterruptedException {
		System.out.printf("<%s> Llegint la compra de %s\n", nom, Thread.currentThread().getName());
		
	}
	
	public void cobramentCompra(float[] productes) throws InterruptedException {
		
		System.out.printf("<%s> Atenent a [%s]\n", this.getNom(), Thread.currentThread().getName());
		
		float preu = calculatImport(productes);
		Thread.sleep(500);
		
		System.out.printf("[%s] Ha fet la compra de productes per un import de %.2f €\n", Thread.currentThread().getName(), preu);
		System.out.printf("[%s] Pagant la compra...\n", Thread.currentThread().getName());
		Thread.sleep(500);
		
		System.out.printf("<%s> Finalització de l'atenció a [%s]\n", this.getNom(), Thread.currentThread().getName());
		this.disponible = true;


	}
	
	public void ticketCompra()  {
		
				
		
	}
	
	private float calculatImport(float[] productes) {
		float preu = 0F;
		for (float prod: productes) {
			preu += prod;
		}
		return(preu);
	}
	
	public String getNom() {
		return this.nom;
	}
	
	public boolean isDisponible() {
		return this.disponible;
	}
	
	public void setDisponible(boolean disp) {
		this.disponible = disp;
	}
	

}
