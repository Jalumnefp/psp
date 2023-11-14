package Task2_06_Supermercat_distribuidorCaixa;

import java.util.LinkedList;
import java.util.List;

public class Distribuidor {
	
	private List<Caixa> caixes;
	private boolean caixesOcupades = false;
	
	public Distribuidor(List caixes) {
		this.caixes = caixes;
		
	}
	
	public synchronized Caixa solicitarCaixa() throws InterruptedException {
		Caixa caixaDisponible = this.getCaixaDisponible();
	
		
		while (caixaDisponible == null) {
			caixesOcupades = true;
			
			while (caixesOcupades) {
				
				System.out.printf("<DISTRIBUIDOR> Cap caixa està disponible, dorm [%s]\n", Thread.currentThread().getName());
				wait();
			}
			
			caixaDisponible = getCaixaDisponible();
			
		}
		
		caixaDisponible.setDisponible(false);
		
		System.out.printf("<DISTRIBUIDOR> Assigna [%s] a <%s>\n", Thread.currentThread().getName(), caixaDisponible.getNom());
		
		return caixaDisponible;
		
	}
	
	public synchronized void finalitzarCaixa() {
		caixesOcupades = false;
		notifyAll();
	}
	
	private Caixa getCaixaDisponible() {
		Caixa caixaDisp = null;
		for (Caixa caixa: caixes) {
			if (caixa.isDisponible()) {
				caixaDisp = caixa;
				break;
			}
		}
		return(caixaDisp);
	}

}
