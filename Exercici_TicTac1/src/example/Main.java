package example;

public class Main {
	public static void main(String[] args) {
		
		FilRellotge filTic = new FilRellotge("TIC");
		FilRellotge filTac = new FilRellotge("TAC");
		
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

class FilRellotge extends Thread{
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
