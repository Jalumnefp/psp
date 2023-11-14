package example;

import java.util.concurrent.Semaphore;

public class Pont {
	private boolean cotxeCreuantDreta = false;
	private boolean cotxeCreuantEsquerra = false;
	private final Semaphore semafor;
	
	public Pont() {
		this.semafor = new Semaphore(2);
	}
	
	public void entrar(String nomMarxa) throws InterruptedException {
		
		if (nomMarxa.equals("est")) {
			
			while (this.isCotxeCreuantDreta()) {
				System.out.printf("[%s] entraPont() -> El pont NO està disponible pel carril %s, espera zZzZz...\n", Thread.currentThread().getName(), nomMarxa);
				semafor.acquire();
			}
			
			cotxeCreuantDreta = true;
			System.out.printf("[%s] ** Entrant al pont pel carril %s **\n", Thread.currentThread().getName(), nomMarxa);
			
		} else if (nomMarxa.equals("oest")) {
			
			while (this.isCotxeCreuantEsquerra()) {
				System.out.printf("[%s] entraPont() -> El pont NO està disponible pel carril %s, espera zZzZz...\n", Thread.currentThread().getName(), nomMarxa);
				semafor.acquire();
			}
			
			cotxeCreuantEsquerra = true;
			System.out.printf("[%s] ** Entrant al pont pel carril %s **\n", Thread.currentThread().getName(), nomMarxa);
			
		}
	
	}
	
	public void creuar(String marxa) throws InterruptedException {
		System.out.printf("[%s] ** Travesant el pont pel carril %s **\n", Thread.currentThread().getName(), marxa);
		Thread.sleep(1000);

	}
	
	public void eixir(String marxa) throws InterruptedException {
		System.out.printf("[%s] ** Eixint del pont pel carril %s ... **\n", Thread.currentThread().getName(), marxa);
		Thread.sleep(500);
		if (marxa.equals("est")) {
			cotxeCreuantDreta = false;
			semafor.release();
		} else if (marxa.equals("oest")) {
			cotxeCreuantEsquerra = false;
			semafor.release();
		}
		
	}

	public boolean isCotxeCreuantDreta() {
		return cotxeCreuantDreta;
	}

	public boolean isCotxeCreuantEsquerra() {
		return cotxeCreuantEsquerra;
	}

	public void setCotxeCreuantEsquerra(boolean cotxeCreuantEsquerra) {
		this.cotxeCreuantEsquerra = cotxeCreuantEsquerra;
	}

	public void setCotxeCreuantDreta(boolean cotxeCreuantDreta) {
		this.cotxeCreuantDreta = cotxeCreuantDreta;
	}
	
	
	
	
}
