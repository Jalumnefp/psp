package example;

public class Main {
	public static void main(String[] args) {
		
		Runnable runFilTic = new FilRellotge("TIC");
		Runnable runFilTac = new FilRellotge("TAC");
		
		Thread filTic = new Thread(runFilTic);
		Thread filTac = new Thread(runFilTac);
		
		System.out.println("Iniciant rellotge...");
		try {
			filTic.start();
			Thread.sleep(500);
			filTac.start();
			filTic.join();
			filTac.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("\nFinalitzat rellotge");
		
	}
}

class FilRellotge implements Runnable{
	private String msg;
	
	public FilRellotge(String msg) {
		// TODO Auto-generated constructor stub
		this.msg = msg;
	}
	
	public void run() {
		try {
			for (int i = 0; i < 5; i++) {
				Thread.sleep(1000);
				System.out.print(" " + this.msg + "  ");
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
