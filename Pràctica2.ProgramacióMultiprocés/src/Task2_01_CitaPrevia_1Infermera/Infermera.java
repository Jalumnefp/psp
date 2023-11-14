package Task2_01_CitaPrevia_1Infermera;

public class Infermera {
	
	private final QuadreCites quadreCites;
	
	public Infermera() {
		System.out.printf("[%s] Infermera agafa el quadre de Cita Prèvia\n", Thread.currentThread().getName());
		this.quadreCites = new QuadreCites();
	}

	public synchronized void solicitarCita(String pacientNom) throws InterruptedException{
		System.out.printf("[%s] Sol.licitar Cira Prèvia a infermera...\n", Thread.currentThread().getName());
		System.out.printf("[%s] Infermera busca un espai al quadre de Cita Previa per a %s\n", pacientNom, pacientNom);
		
		if (Thread.activeCount() == 1) {
			System.out.println();
		}
		
		int posicioTorn = quadreCites.cercaCitaLliure();
		
		if (posicioTorn != -1) {
			
			quadreCites.assignaCitaAQuadre(pacientNom, posicioTorn);
			
			String hora = quadreCites.retornaCita(posicioTorn);
			
			System.out.printf("[%s] Infermera assigna la Cita Prèvia per a %s a les %sh\n", pacientNom, pacientNom, hora);
			
		} else {
			
			System.out.printf("[%s] Infermera indica que no queden torns, Cita Prèvia impossible\n", pacientNom);
			
		}
		
	}
	
	public void resultatQuadre() {
		quadreCites.imprimeixQuadre();
	}

}
