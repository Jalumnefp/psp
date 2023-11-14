package Task2_02_CitaPrevia_2Infermeres;

public class Infermera {
	
	private QuadreCites quadreCites;
	private String nom;
	
	public Infermera(QuadreCites quadreCites, String nom) {
		System.out.printf("[%s] Infermera agafa el quadre de Cita Prèvia\n", Thread.currentThread().getName());
		this.quadreCites = new QuadreCites();
		this.nom = nom;
		this.quadreCites = quadreCites;
	}

	public void solicitarCita(String pacientNom) throws InterruptedException{
		
		
		int posicioTorn;
		synchronized (this) {
			System.out.printf("[%s] Sol.licitar Cira Prèvia a infermera...\n", pacientNom);
			System.out.printf("[%s] %s busca un espai al quadre de Cita Previa per a %s\n", pacientNom, nom, pacientNom);
			posicioTorn = quadreCites.cercaCitaLliure();
		}
		
		if (posicioTorn != -1) {
			
			synchronized (this) {
				quadreCites.assignaCitaAQuadre(pacientNom, posicioTorn);
				String hora = quadreCites.retornaCita(posicioTorn);
				System.out.printf("[%s] %s assigna la Cita Prèvia per a %s a les %sh\n", pacientNom, nom, pacientNom, hora);
			}
			
		} else {
			
			System.out.printf("[%s] %s indica que no queden torns, Cita Prèvia impossible\n", pacientNom, nom);
			
		}
		
	}
	
	public void resultatQuadre() {
		quadreCites.imprimeixQuadre();
	}

}
