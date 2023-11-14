package example;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

class Main {
	
	public static final Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		ArrayList<Integer> llista = new ArrayList<>();
		int num;
		do {
			System.err.print("-> ");
			num = sc.nextInt();
			if(num != -99) {
				llista.add(num);
			}
		} while (num != -99);
		System.out.println("S'han llegit " + llista.size() + " valors.");
		System.out.println("Llista: [ " + llegirLLista(llista) + "]");
		System.out.println("Suma: " + sumarLLista(llista));
		System.out.println("Mitjana: " + sumarLLista(llista) / llista.size());
		System.out.println("Numeros majors a la mitjana: " + majorsMitjana(llista));
		
	}
	
	public static int sumarLLista(ArrayList<Integer> llista) {
		int res = 0;
		Iterator<Integer> it = llista.iterator();
		while(it.hasNext()) {
			res+= it.next();
		}
		return res;
	}
	
	public static String llegirLLista(ArrayList<Integer> llista) {
		StringBuilder str = new StringBuilder();
		Iterator<Integer> it = llista.iterator();
		while(it.hasNext()) {
			str.append(it.next()).append(" ");
		}
		return str.toString();
	}
	
	public static ArrayList<Integer> majorsMitjana(ArrayList<Integer> llista) {
		ArrayList<Integer> newllista = new ArrayList<>();
		int mitjana = sumarLLista(llista) / llista.size();
		for(int x: llista) {
			if(x > mitjana) {
				newllista.add(x);
			}
		}
		return newllista;
	}

}
