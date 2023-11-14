package example;

import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;
import java.util.Scanner;

public class Task1_6_MiniShell {
	
	public static void main(String[] args) {
		final Scanner sc = new Scanner(System.in);
		
		String[] comandosValids = new String[] {"ls", "grep", "cat"};
		
		String answ;
		
		do {
			
			boolean comandoValidat = false;
			
			System.out.print("minishell> ");
			answ = sc.nextLine();
			
			String[] comando = answ.split(" ");
			for (String s: comandosValids) {
				if (comando[0].equals(s)) {
					comandoValidat = true;
					break;
				}
			}
			
			if (comandoValidat) {
				
				ProcessBuilder pb = new ProcessBuilder(comando)
						.redirectOutput(Redirect.INHERIT)
						.redirectError(Redirect.INHERIT);
				
				try {
					Process p = pb.start();
					p.waitFor();
				} catch (IOException | InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				System.out.println("\nExecució correcta!\n");
				
			} else if (!answ.isEmpty()) {
				System.out.printf("\n Comandament desconegut: %s\n\n", comando[0]);
			}
					
		} while(!answ.isEmpty());
		
		System.out.println("\nFinalització del programa!");
		
		sc.close();
		
	}

}
