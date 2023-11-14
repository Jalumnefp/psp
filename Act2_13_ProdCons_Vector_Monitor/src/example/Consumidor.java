package example;

public class Consumidor implements Runnable {
	
	private Monitor monitor;
	private int numProd;
	private int tempsEsperaAccio;
	
	public Consumidor(Monitor monitor, int numProd, int t) {
		this.monitor = monitor;
		this.numProd = numProd;
		this.tempsEsperaAccio = t;
		System.out.printf("[%s] Construcció de Consumidor que consumirà %s productes\n", Thread.currentThread().getName(), numProd);
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int x = 0; x < 13; x++) {
			try {
				Thread.sleep((int)(Math.random()*tempsEsperaAccio));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int num = monitor.consumir();
			System.out.printf("[%s] Consumit producte %s\n", Thread.currentThread().getName(), num);
		}
	}

}
