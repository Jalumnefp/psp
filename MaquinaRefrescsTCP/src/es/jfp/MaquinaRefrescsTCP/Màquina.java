package es.jfp.MaquinaRefrescsTCP;

public class Màquina {
	
	private Refresc[] refrescs;
	
	public Màquina() {
		this.refrescs = crearRefrescs();
		carregarRefrescs(100);
		System.out.println("La màquina té " + 100 + " refrescs.");
	}
	
	public void consumirRefresc(String name) {
		for (Refresc refresc: refrescs) {
			if (refresc.getName().equals(name) && refresc.getStock()!=0) {
				refresc.removeStock(1);
				break;
			}
		}
	}
	
	public String consumirRefrescos(int cantitat) {
		StringBuilder refrescsConsumits = new StringBuilder();
		for (int i = 0; i < cantitat; i++) {
			int rang = (int)(Math.random()*7);
			this.refrescs[rang].removeStock(1);
			refrescsConsumits.append("Ha llegado un refresco de -> " + refrescs[rang].getName() + '\n');
		}
		return refrescsConsumits.toString();
	}
	
	private void carregarRefrescs(int cantitat) {
		for (int i = 0; i < cantitat; i++) {
			int rang = (int)(Math.random()*7);
			this.refrescs[rang].addStock(1);
		}
	}
	
	private Refresc[] crearRefrescs() {
		String[] nomsRefrescs = new String[] {
				"FantaTaronja", "FantaLlima", "Nestea", "Aquarius", "CocaCola", "Sprite", "Aigua"
		};
		Refresc[] refrescs = new Refresc[7];
		for (int i = 0; i < refrescs.length; i++) {
			refrescs[i] = new Refresc(nomsRefrescs[i]);
		}
		return refrescs;
 	}
	
	public int getRefrescsLen() {
		int len = 0;
		for (Refresc refresc: refrescs) {
			len += refresc.getStock();
		}
		return len;
	}
	
	

}
