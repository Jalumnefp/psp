package Task2_02_CitaPrevia_2Infermeres;

import java.util.LinkedList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		final QuadreCites quadreCites = new QuadreCites();
		final Infermera infermera1 = new Infermera(quadreCites, "Infermera 1");
		final Infermera infermera2 = new Infermera(quadreCites, "Infermera 2");
		final List<Thread> pacients = new LinkedList<>();
		
		for (int x = 1; x <= 10; x++) {
			String nomPacient = "Pacient " + (x < 10 ? "0" + x : x);
			Infermera inf = x % 2 == 0 ? infermera2 : infermera1;
			pacients.add(new Thread(new Pacient(inf), nomPacient));
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
		
		infermera1.resultatQuadre();
		
	}
}
