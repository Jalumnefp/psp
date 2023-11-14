package example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) {
		
		ProcessBuilder pb = new ProcessBuilder(new String[] {"ls", "-a"}).inheritIO();

		try {
			Process p = pb.start();
			
			try (BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()))) {
				
				System.out.println(br.read() != -1 ? br.read() : "");
				
			} catch (IOException e) {
				System.err.println("Error en el buffer!\n");
				e.printStackTrace();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.println("Error en el proceso!\n");
			e.printStackTrace();
		}
	}
}
