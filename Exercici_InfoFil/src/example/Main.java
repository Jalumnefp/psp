package example;

public class Main {
	public static void main(String[] args) {
		Fil fil1 = new Fil("FIL N1", false);
		Fil fil2 = new Fil("FIL N2", true);
		fil1.run();
		fil1.interrupt();
		fil2.run();
		fil1.run();
		
	}
}

class Fil extends Thread {
	
	public Fil(String name, boolean isDaemon) {
		this.setName(name);
		this.setDaemon(isDaemon);
	}
	
	public void run() {
		System.out.println(this.toString());
	}
	
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("FIL {");
		str.append("\n\tID: ").append(this.getId());
		str.append("\n\tNom: ").append(this.getName());
		str.append("\n\tPrioritat: ").append(this.getPriority());
		str.append("\n\tEs un dimoni: ").append(this.isDaemon());
		str.append("\n\tEstá viu: ").append(this.isAlive());
		str.append("\n\tHa sigut interromput: ").append(this.isInterrupted());
		str.append("\n}");
		return str.toString();
	}
	
	
}
