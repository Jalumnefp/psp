package example;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Pont {
	private boolean cotxeCreuant = false;
	private Lock cadenat;
	private Condition disponible;
	
	public Pont() {
		cadenat = new ReentrantLock();
		disponible = cadenat.newCondition();
	}
	
	public void entrar() throws InterruptedException {
		
		cadenat.lock();
		
		if (this.isCotxeCreuant()) {
			System.out.printf("[%s] entraPont() -> El pont NO està disponible, espera zZzZz...\n", Thread.currentThread().getName());
			disponible.await();
		}
		
		cadenat.unlock();
		
		
		System.out.printf("[%s] ** Entrant al pont **\n", Thread.currentThread().getName());
		cotxeCreuant = true;
		
	}
	
	public void creuar(String marxa) throws InterruptedException {
		System.out.printf("[%s] ** Travesant el pont per anar cap a l'%s **\n", Thread.currentThread().getName(), marxa);
		Thread.sleep(1000);

	}
	
	public void eixir() throws InterruptedException {
		System.out.printf("[%s] ** Eixint del pont... **\n", Thread.currentThread().getName());
		Thread.sleep(500);
		cotxeCreuant = false;
		
		cadenat.lock();
		
		disponible.signal();
			
		cadenat.unlock();
		
	}

	public boolean isCotxeCreuant() {
		return cotxeCreuant;
	}

	public void setCotxeCreuant(boolean cotxeCreuant) {
		this.cotxeCreuant = cotxeCreuant;
	}
	
	
}
