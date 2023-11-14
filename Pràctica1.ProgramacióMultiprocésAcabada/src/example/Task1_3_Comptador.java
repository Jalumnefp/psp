package example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Task1_3_Comptador {
	public static void main(String[] args) {
		final Scanner sc = new Scanner(System.in);
		
		String answ = "null";
		
		while (!answ.equals("")) {
			
			System.out.print("comptadortxt> ");
			answ = sc.nextLine();
			
			try {
				
				Process p_char = new ProcessBuilder(new String[] {"wc", "-m"}).start();
				Process p_letter = new ProcessBuilder(new String[] {"wc", "-w"}).start();
				
				String p_char_result = null;
				String p_letter_result = null;
				
				try {
					
					BufferedWriter bwa = new BufferedWriter(new OutputStreamWriter(p_char.getOutputStream()));
						
					bwa.write(answ);
					bwa.close();
					
					BufferedReader bra = new BufferedReader(new InputStreamReader(p_char.getInputStream()));
						
					p_char_result = bra.readLine();
					bra.close();
						
				} catch (IOException e) {
					BufferedReader brea = new BufferedReader(new InputStreamReader(p_char.getErrorStream()));
					System.err.println(brea.readLine());
					brea.close();
				}
				
				try {
					
					BufferedWriter bwb = new BufferedWriter(new OutputStreamWriter(p_letter.getOutputStream()));
						
					bwb.write(answ);
					bwb.flush();
					bwb.close();
					
					BufferedReader brb = new BufferedReader(new InputStreamReader(p_letter.getInputStream()));
					
					p_letter_result = brb.readLine();
					brb.close();
						
				} catch (IOException e) {
					BufferedReader breb = new BufferedReader(new InputStreamReader(p_letter.getErrorStream()));
					System.err.println(breb.readLine());
					breb.close();
				}
				
				p_char.waitFor();
				p_letter.waitFor();
				
				System.out.printf("Caracteres: %s\nPalabras %s\n", p_char_result, p_letter_result);
				
				
			} catch (IOException | InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		
	}
}
