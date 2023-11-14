package example;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

class Main {
	public static void main(String[] args) {
		Sistema.getInstance().play();
		
	}
}

final class Sistema {
	
	private static Sistema instance;
	private final File finput = new File("entrada.txt");
	private final File foutput = new File("eixida.txt");


	private Sistema() {}


	public static Sistema getInstance() {
		if (instance == null) instance = new Sistema();
		return instance;
	}
	
	public void play() {
		try {
			
			fileInputExists();
			fileOutputExists();
			
			String text_entrada = readFile(Path.of(finput.getAbsolutePath()));
			
			System.out.println(text_entrada);
			
			int words = countTextWords(text_entrada);
			
			System.out.println(words);

			writeResult(Path.of(foutput.getAbsolutePath()), words);
			
			System.out.println(readFile(Path.of(foutput.getAbsolutePath())));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private String readFile(Path path) {
		StringBuilder str = new StringBuilder();
		
		try (InputStream is = Files.newInputStream(path)) {
			int temp = 0;
			while(temp!=-1) {
				temp = is.read();
				if(temp!= -1) {
					str.append((char)(temp));
				}
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return str.toString();
	}
	
	private int countTextWords(String text) {
		int wrds = 0;
		
		for(int x = 0; x < text.length(); x++) {
			if (text.charAt(x) == ' ') wrds++;
		}
		
		return wrds + 1;
	}
	
	private void writeResult(Path path, int words) {
		
		try (BufferedWriter bw = Files.newBufferedWriter(path)) {
			bw.write(String.valueOf(words));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private void fileInputExists() throws IOException {
		if (!finput.exists()) {
			finput.createNewFile();
		}
	}
	
	private void fileOutputExists() throws IOException {
		if (!foutput.exists()) {
			foutput.createNewFile();
		}
	}
}
