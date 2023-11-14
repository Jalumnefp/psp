package example;

import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		
		ProcessBuilder pb = new ProcessBuilder(new String[] {"find", "lo"});
		
		try {
			Process p = pb.start();
			
			while(p.isAlive()) {
				System.out.println("El proceso " + p.pid() + " está vivo");
				Thread.sleep(3000);
			}
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
