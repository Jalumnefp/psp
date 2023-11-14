package example;

public class Main {
	public static void main(String[] args) throws InterruptedException {
		ServeiTecnic serveiTecnic = new ServeiTecnic();
		
		System.out.println("[Fil ppal] Inici amb "+serveiTecnic.getNumIncidencia()+" resoltes.");
		
		Runnable run1 = new Tecnic(serveiTecnic, "Tecnic 1");
		Runnable run2 = new Tecnic(serveiTecnic, "Tecnic 2");
		Thread tecnic1 = new Thread(run1);
		Thread tecnic2 = new Thread(run2);
		
		tecnic1.start();
		Thread.sleep(500);
		tecnic2.start();
		tecnic2.join();
		
		System.out.println("[Fil ppal] Final amb "+serveiTecnic.getNumIncidencia()+" resoltes.");

		
	}
	
}
