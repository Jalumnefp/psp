package example;

public class ServeiTecnic {
	
	private int idNovaIncidencia = 0;
	private int numIncidencia = 0;
	private int maxIncidencies = 5;
	
	public ServeiTecnic() {
		
	}
	
	public void resoldreIncidencia() {
		if (numIncidencia < 5) {
			numIncidencia++;
		} else if (numIncidencia == 5) {
			System.out.println("Última incidencia resolta!");
		} else {
			System.err.println("Error. No es poden resoldre més incidències");
		}
	}
	

	public int getIdNovaIncidencia() {
		return idNovaIncidencia;
	}

	public void setIdNovaIncidencia() {
		this.idNovaIncidencia++;
	}

	public int getNumIncidencia() {
		return numIncidencia;
	}

	public void setNumIncidencia(int numIncidencia) {
		this.numIncidencia = numIncidencia;
	}

	public int getMaxIncidencies() {
		return maxIncidencies;
	}

	public void setMaxIncidencies(int maxIncidencies) {
		this.maxIncidencies = maxIncidencies;
	}
	
	

}
