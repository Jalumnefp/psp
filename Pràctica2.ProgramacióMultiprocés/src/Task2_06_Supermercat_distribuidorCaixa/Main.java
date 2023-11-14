package Task2_06_Supermercat_distribuidorCaixa;

import java.util.LinkedList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		List<Thread> clients = new LinkedList<>();
		List<Caixa> caixes = new LinkedList<>(); 
		
		for (int i = 1; i <= 3; i++) {
			caixes.add(new Caixa("Caixa"+i));
		}
		
		Distribuidor distr = new Distribuidor(caixes);
		
		for (int i = 1; i <= 8; i++) {
			clients.add(new Thread(new Client(distr), "Client"+i));
		}
		
		clients.forEach(client -> client.start());
		
		for (Thread client: clients) {
			try {
				client.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
