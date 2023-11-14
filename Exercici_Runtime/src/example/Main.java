package example;

import java.io.IOException;

public class Main {
	
	public static void main(String[] args) {
		Runtime rt = Runtime.getRuntime();
		try {
			System.out.println(rt.exec(new String[] {"ls", "-l", "/home/alumne"}));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
