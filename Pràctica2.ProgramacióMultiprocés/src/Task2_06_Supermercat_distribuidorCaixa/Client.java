package Task2_06_Supermercat_distribuidorCaixa;

public class Client implements Runnable{
	
	private float[] productes;
	private Caixa caixa = null;
	private Distribuidor distr = null;
	
	public Client(Distribuidor distr) {
		this.distr = distr;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		this.productes = comprarProductes(5);
		System.out.printf("[%s] El client ha fet la recollida de productes.\n", Thread.currentThread().getName());
		
		try {
			
			System.out.printf("[%s] Client va a la cua DISTRIBUIDOR\n", Thread.currentThread().getName());
			this.caixa = this.distr.solicitarCaixa();
			Thread.sleep(500);
			
			this.caixa.cobramentCompra(productes);
			
			this.distr.finalitzarCaixa();
			
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private float[] comprarProductes(int cantitat) {
		float[] productes = new float[5];
		for (int x = 0; x < 5; x++) {
			productes[x] = getPrice();
		}
		return productes;
	}
	
	private float getPrice() {
		return (float) (Math.random()*30)+15;
	}

}
