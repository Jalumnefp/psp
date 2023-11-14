package example;

public class Tecnic implements Runnable{
	private ServeiTecnic serveiTecnic;
	private String nameThread;
	
	public Tecnic(ServeiTecnic serveiTecnic, String nameThread) {
		this.serveiTecnic = serveiTecnic;
		this.nameThread = nameThread;
	}

	@Override
	public void run(){
		// TODO Auto-generated method stub
		
		for (int i = 0; i < 3; i++) {
			if (serveiTecnic.getMaxIncidencies() == serveiTecnic.getNumIncidencia()) {
				break;
			}
			
			serveiTecnic.setIdNovaIncidencia();
			
			
			try {
				System.out.println("["+nameThread+"] Atenent incidència" + serveiTecnic.getIdNovaIncidencia());
				//Thread.sleep(500);
				System.out.println("["+nameThread+"] Solucionant incidència" + serveiTecnic.getIdNovaIncidencia());
				//Thread.sleep(500);
				System.out.println("["+nameThread+"] Incrementar incidencies resoltes Actual: " + serveiTecnic.getNumIncidencia());
				serveiTecnic.resoldreIncidencia();
				//Thread.sleep(500);
				System.out.println("Incidencies resoltes: " + serveiTecnic.getNumIncidencia());
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
	}

}
