package exemple;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedList;
import java.util.List;

class Main {
	public static void main(String[] args) {
		List<String[]> data = new LinkedList<>();
		List<String[]> newData = null;
		
		
		final ManageFile mf = new ManageFile();
		
		data = mf.getFileData();
		
		newData = mf.getNewData(data);
		
		mf.setFileData(newData);
		
		System.out.println("ENTRADA: ");
		for(String[] y: data) {
			for(String x: y) {
				System.out.print(x + ' ');
			}
			System.out.println();
		}
		
		System.out.println("EIXIDA: ");
		for(String[] y: newData) {
			for(String x: y) {
				System.out.print(x + ' ');
			}
			System.out.println();
		}
		
	}
	
}

class ManageFile {
	
	public ManageFile() {}
	
	public List<String[]> getFileData() {
		List<String[]> totalData = new LinkedList<>();
		List<String> data = new LinkedList<>();
		
		try (BufferedReader br = Files.newBufferedReader(Path.of("estudiants.csv"))) {
			
			String temp = "";
			while (temp != null) {
				temp = br.readLine();
				if(temp != null) {
					data.add(temp);
				}
			}
						
			for(String s: data) {
				totalData.add(s.split(";"));
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return totalData;
		
	}
	
	public List<String[]> getNewData(List<String[]> data) {
		List<String[]> newData = new LinkedList<>();
		
		for(String[] a: data) {
			String nom = null;
			int n1 = 0;
			int n2 = 0;
			for(String s: a) {
				if(s.length() < 2) {
					n1 += Integer.parseInt(s);
					n2++;
				} else {
					nom = s;
				}
			}
		
			newData.add(new String[] {nom, String.valueOf(media(n1, n2))});
		}
		
		return newData;
	}
	
	public void setFileData(List<String[]> data) {
		
		StringBuilder str = new StringBuilder();
		
		for(String[] f: data) {
			for(String c: f) {
				str.append(c).append(";");
			}
			str.append('\n');
		}
				
		try (BufferedWriter bw = Files.newBufferedWriter(Path.of("mitjanes.csv"))) {
			
			bw.write(str.toString());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	private int media(int n1, int n2) {
		return n1 / n2;
	}
	
	
}
