package example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.ProcessBuilder.Redirect;
import java.util.Scanner;

public class Task1_4_HashMd5redirect {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		String answ = "null";
		
		while (!answ.equals("")) {
			System.out.print("md5txt> ");
			answ = sc.nextLine();
			
			if (!answ.equals("")) {
				try {
					ProcessBuilder pb = new ProcessBuilder(new String[] {"md5sum", "-t"});
					pb.redirectOutput(Redirect.INHERIT);
					pb.redirectError(Redirect.INHERIT);
					
					Process p = pb.start();
					
					OutputStreamWriter osw = null;
					BufferedWriter bw = null;
					
					try {
						
						osw = new OutputStreamWriter(p.getOutputStream());
						bw = new BufferedWriter(osw);
						
						osw.write(answ);
						
					} catch (IOException e) {
						e.printStackTrace();
					} finally {
						bw.close();
						osw.close();
					}
					
					p.waitFor();
					
					
				} catch (IOException | InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		
	}
}
