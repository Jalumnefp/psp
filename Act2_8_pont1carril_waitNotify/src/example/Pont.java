package example;

public class Pont {
	private boolean cotxeCreuant = false;
	
	public Pont() {
		
	}
	
	public void entrar() throws InterruptedException {
		
		synchronized (this) {
			if (this.isCotxeCreuant()) {
				System.out.printf("[%s] entraPont() -> El pont NO està disponible, espera zZzZz...\n", Thread.currentThread().getName());
				wait();
			}
		}
		
		
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
		synchronized (this) {
			notify();
		}
		
	}

	public boolean isCotxeCreuant() {
		return cotxeCreuant;
	}

	public void setCotxeCreuant(boolean cotxeCreuant) {
		this.cotxeCreuant = cotxeCreuant;
	}
	
	
}
