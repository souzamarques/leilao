package dominio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Avaliador {
	
	private double maiorLance = Double.NEGATIVE_INFINITY;
	private double menorLance = Double.POSITIVE_INFINITY;
	private List<Lance> maiores;

	// Avalia lances feitos pelo jogadores, armazena os tres maiores valores e não aceita um leilao sem lances
	public void avalia(Leilao leilao) {
		
		if(leilao.getLances().size() == 0) {
			throw new RuntimeException("Não é possível avaliar um leilão sem lances");
		}
		
		for(Lance lance : leilao.getLances()) {
			if(lance.getValor() > maiorLance)
				maiorLance = lance.getValor();
			else if(lance.getValor() < menorLance)
				menorLance = lance.getValor();
		}
		
		maiores = new ArrayList<Lance>(leilao.getLances());
		Collections.sort(maiores, new Comparator<Lance>() {
			
			public int compare(Lance o1, Lance o2) {
				if(o1.getValor() < o2.getValor())
					return 1;
				if(o1.getValor() > o2.getValor())
					return -1;
				return 0;
			}
			
		});
		maiores = maiores.subList(0, maiores.size() > 3 ? 3 : maiores.size());
		
	}
	
	public double getMaiorLance() {
		return maiorLance;
	}
	
	public double getMenorLance() {
		return menorLance;
	}
	
	public List<Lance> getTresMaiores() {
		return maiores;
	}

}
