package example;

public class Main {
	
	public static void main(String[] args) throws InterruptedException {
		Monitor monitor = new Monitor(1500, 5);
		
		Thread consumidor = new Thread(new Consumidor(monitor, 13, 3000), "Consumidor");
		Thread productor = new Thread(new Productor(monitor, 13, 3000), "Productor");
		
		consumidor.start();
		productor.start();
		
		productor.join();
		consumidor.join();
		
		System.out.printf("[%s] Finalització del programa", Thread.currentThread().getName());
		
	}
}
