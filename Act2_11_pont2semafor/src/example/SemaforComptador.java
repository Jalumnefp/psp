package example;

public class SemaforComptador {
	private int recursos;
	
	public SemaforComptador(int recursos) {
		this.recursos = recursos;
	}
	
	public synchronized void metodeWait() {
		while (recursos == 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		recursos--;
	}
	
	public synchronized void metodeWakeup() {
		recursos++;
		notify();
	}
}


