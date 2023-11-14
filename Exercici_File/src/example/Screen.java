package example;

import java.util.Scanner;

public final class Screen {
	
	private static Screen instance;
	
	private final Scanner sc = new Scanner(System.in);
	
	private final FileManager fm = FileManager.getInstance();
	
	
	private Screen() {}
	
	
	public static Screen getInstance() {
		if(instance == null) instance = new Screen();
		return instance;
	}
	
	public void play() {
		
		boolean stop = false;

		final String menu = """
			1. Llistar directori
			2. Mostrar dades del fitxer
			0. Eixir del programa
			---------------------------
			Respuesta: 
			""";
		
		do {
			System.out.print(menu);
			int answ = sc.nextInt();
			System.out.print("Directori: ");
			String path = sc.next();
			
			switch (answ) {
			
				case 0 -> stop = true;
				case 1 -> System.out.println(fm.unix_ls(path));
				case 2 -> System.out.println(fm.getFileData(path));
			
			}
			
		} while(!stop);
		
	}
	
}
