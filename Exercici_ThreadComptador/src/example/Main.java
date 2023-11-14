package example;

public class Main {
	public static void main(String[] args) {
		
		for (int i = 0; i < 3; i++) {
				Thread fil = new FilComptador("Fil" + i);
				System.err.println("[Fil ppal] Creació fil: " + fil.getName());
				System.err.print(fil.getName().equals("Fil2") ? "[Fil ppal] Fi de la creació del 3 fils\n" : "");
				System.err.println("[Fil ppal] Execució fil: " + fil.getName());
				fil.start();
				try {
					fil.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
	}
	
	
}

class FilComptador extends Thread {
	FilComptador(String nom){
		this.setName(nom);
	}
	
	public void run() {
		for (int i = 0; i < 5; i ++) {
			System.out.println("[" + this.getName() + "] Comptador: " +i);
		}
	}
}
