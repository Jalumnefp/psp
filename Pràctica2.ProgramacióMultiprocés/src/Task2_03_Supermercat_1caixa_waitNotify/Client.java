package Task2_03_Supermercat_1caixa_waitNotify;

public class Client implements Runnable{
	
	private float preu;
	private final Caixa caixa;
	
	public Client(Caixa caixa) {
		this.caixa = caixa;
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		this.preu = getPrice();
		
		try {
			
			System.out.printf("[%s] Client va a la caixa %s\n", Thread.currentThread().getName(), caixa.getNom());
			caixa.agafaCompra();
			Thread.sleep(500);
			
			
			caixa.cobramentCompra(preu);
			System.out.printf("[%s] Pagant la compra de %.2f€ a %s\n", Thread.currentThread().getName(), preu, caixa.getNom());
			Thread.sleep(500);
			
			caixa.ticketCompra();
			System.out.printf("[%s] Eixint del supermercat...\n", Thread.currentThread().getName());			
			
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private float getPrice() {
		System.out.printf("[%s] El client ha fet la recollida de productes.\n", Thread.currentThread().getName());
		return (float) (Math.random()*5)+5;
	}

}
