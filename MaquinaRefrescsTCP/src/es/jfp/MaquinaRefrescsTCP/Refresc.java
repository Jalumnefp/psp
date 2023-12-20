package es.jfp.MaquinaRefrescsTCP;

public class Refresc {
	
	private String name;
	private int cantitat;
	
	public Refresc(String name) {
		this.name = name;
	}
	
	public void addStock(int cantitat) {
		this.cantitat += cantitat;
	}
	
	public void removeStock(int cantitat) {
		this.cantitat -= cantitat;
	}

	@Override
	public String toString() {
		return "Refresc [name=" + name + ", cantitat=" + cantitat + "]";
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getStock() {
		return this.cantitat;
	}
	
	

}
