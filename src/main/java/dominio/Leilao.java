package dominio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Leilao {

	private String descricao;
	private List<Lance> lances;
	
	public Leilao(String descricao) {
		this.descricao = descricao;
		this.lances = new ArrayList<Lance>();
	}
	
	// Adicionando lance e caso não haja leilão, não serão aceitos lances
	public void propoe(Lance lance) {
		
		if(lances.isEmpty() || !ultimoLanceDado().getUsuario().equals(lance.getUsuario())) {
			lances.add(lance);
		}
		
	}
	
	private Lance ultimoLanceDado() {
		return lances.get(lances.size()-1);
	}

	public String getDescricao() {
		return descricao;
	}

	public List<Lance> getLances() {
		return Collections.unmodifiableList(lances);
	}
	
}
