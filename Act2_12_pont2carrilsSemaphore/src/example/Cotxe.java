package example;

public class Cotxe implements Runnable {
	
	private String name;
	private final boolean marxa;
	private final Pont pont;
	
	public Cotxe(Pont pont, boolean marxa) {
		this.pont = pont;
		this.marxa = marxa;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		setName(Thread.currentThread().getName());
		String nomMarxa = marxa ? "est" : "oest";
		
		System.out.printf("[%s] Vehicle vol travessar el pont per anar cap a l'%s\n", this.name, nomMarxa);
		
		
		try {
			pont.entrar(nomMarxa);
			pont.creuar(nomMarxa);
			pont.eixir(nomMarxa);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isMarxa() {
		return marxa;
	}

	public Pont getPont() {
		return pont;
	}
	
	

}
