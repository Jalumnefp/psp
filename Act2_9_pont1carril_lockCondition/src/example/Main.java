package example;

public class Main {
	public static void main(String[] args) {
		Pont pont = new Pont();

		Thread cotxe1 = new Thread(new Cotxe(pont, true), "Cotxe 1");
		Thread cotxe2 = new Thread(new Cotxe(pont, false), "Cotxe 2");
		Thread cotxe3 = new Thread(new Cotxe(pont, false), "Cotxe 3");
		Thread cotxe4 = new Thread(new Cotxe(pont, true), "Cotxe 4");
		
		System.out.println("Lock");
		cotxe1.start();
		cotxe2.start();
		cotxe3.start();
		cotxe4.start();
	}

}
