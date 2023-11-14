package Task2_01_CitaPrevia_1Infermera;

import java.util.concurrent.Semaphore;

public class Pacient implements Runnable {
	
	private final Infermera infermera;
	
	public Pacient(Infermera infermera) {
		this.infermera = infermera;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		try {
			
			System.out.printf("[%s] Entrant a l'ambulatori...\n", Thread.currentThread().getName());
			Thread.sleep(1000);
			
			infermera.solicitarCita(Thread.currentThread().getName());
			Thread.sleep(1000);
			
			System.out.printf("[%s] Eixint de l'Ambulatori...\n", Thread.currentThread().getName());
			Thread.sleep(1000);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
