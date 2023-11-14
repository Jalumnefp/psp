package Task2_01_CitaPrevia_1Infermera;

import java.util.LinkedList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		final Infermera infermera = new Infermera();
		final List<Thread> pacients = new LinkedList<>();
		
		for (int x = 1; x <= 10; x++) {
			String nomPacient = "Pacient " + (x < 10 ? "0" + x : x);
			pacients.add(new Thread(new Pacient(infermera), nomPacient));
		}
				
		for (Thread pacient: pacients) {
			pacient.start();
		}
		
		try {
			
			for (Thread pacient: pacients) {
				pacient.join();
			}

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		infermera.resultatQuadre();
		
	}
}
