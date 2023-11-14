package example;

public class Pont {
	private boolean cotxeCreuantDreta = false;
	private boolean cotxeCreuantEsquerra = false;
	private final SemaforComptador semafor;
	
	public Pont() {
		this.semafor = new SemaforComptador(2);
	}
	
	public void entrar(String nomMarxa) throws InterruptedException {
		
		if (nomMarxa.equals("est")) {
			
			while (this.isCotxeCreuantDreta()) {
				System.out.printf("[%s] entraPont() -> El pont NO està disponible pel carril %s, espera zZzZz...\n", Thread.currentThread().getName(), nomMarxa);
				semafor.metodeWait();
			}
			
			cotxeCreuantDreta = true;
			System.out.printf("[%s] ** Entrant al pont pel carril %s **\n", Thread.currentThread().getName(), nomMarxa);
			
		} else if (nomMarxa.equals("oest")) {
			
			while (this.isCotxeCreuantEsquerra()) {
				System.out.printf("[%s] entraPont() -> El pont NO està disponible pel carril %s, espera zZzZz...\n", Thread.currentThread().getName(), nomMarxa);
				semafor.metodeWait();
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
			semafor.metodeWakeup();
		} else if (marxa.equals("oest")) {
			cotxeCreuantEsquerra = false;
			semafor.metodeWakeup();
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
