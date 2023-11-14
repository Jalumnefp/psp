package example;

import java.io.File;
import java.util.Scanner;


class Main {
	
	public static void main(String[] args) {
		
		final Screen screen = Screen.getInstance();
		screen.play();
		
	}

}

final class Screen {
	
	private static Screen instance;
	
	private final Scanner sc = new Scanner(System.in);
	
	private final FileManager fm = FileManager.getInstance();
	
	
	private Screen() {}
	
	
	public static Screen getInstance() {
		if(instance == null) instance = new Screen();
		return instance;
	}
	
	public void play() {

		final String menu = """
			1. Mostrar fitxers del directori actual
			2. Modificar el directori actual
			3. Tornar enrere
			4. Eixir del programa""";
		
		while(true) {
			System.out.println("Directorio acutal: " + fm.getFilePath() + '\n' + menu);
			int answ = sc.nextInt();
			
			if (answ == 4) break;
			
			else if (answ == 1) System.out.println(fm.unix_ls());
				
			else if (answ == 2) {
				System.out.print("Nombre: ");
				fm.unix_mkdir(sc.next());
			}
				
			else if (answ == 3) fm.unix_cd_back();
			
		}
		
	}
	
}

final class FileManager {
	
	private static FileManager instance;
		
	private File file = new File("src");
		
	
	private FileManager() {}
	
	
	public static FileManager getInstance() {
		if (instance == null) instance = new FileManager();
		return instance;
	}
	
	public String unix_ls() {
		StringBuilder str = new StringBuilder();
		
		for(File f: file.listFiles()) {
			char letter = f.isFile() ? 'f' : 'd';
			str.append(f.getName()).append(' ').append(letter).append('\n');
		}
		
		if(str.isEmpty()) {
			str.append("Vacío");
		}
		
		return str.toString();

	}
	
	public void unix_mkdir(String name) {
		
		this.setFile(file.getAbsolutePath() + "/" + name);
		
		file.mkdir();
				
	}
	
	public void unix_cd_back(){
		
		this.setFile(file.getParent());
		
	}
	
	public String getFilePath() {
		return file.getAbsolutePath();
	}
	
	private void setFile(String path) {
		this.file = new File(path);
	}
	
}

