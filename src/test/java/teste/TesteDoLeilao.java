package teste;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import dominio.Leilao;
import dominio.Lance;
import dominio.Usuario;

public class TesteDoLeilao {
	
	@Test
	public void receberUmLance() {
		
		Leilao leilao = new Leilao("Macbook Pro 16");
		assertEquals(0, leilao.getLances().size());
		
		leilao.propoe(new Lance(new Usuario("Marcos"), 2000.0));
		
		assertEquals(1, leilao.getLances().size());
		assertEquals(2000.0, leilao.getLances().get(0).getValor(), 0.00001);
		
	}
	
	public void receberVariosLances() {
		
		Leilao leilao = new Leilao("Macbook Pro 16");
		
		leilao.propoe(new Lance(new Usuario("Lucas"), 3500.0));
		leilao.propoe(new Lance(new Usuario("Marcos"), 2000.0));
		leilao.propoe(new Lance(new Usuario("Raul"), 6000.0));
		
		assertEquals(3, leilao.getLances().size());
		assertEquals(3500.0, leilao.getLances().get(0).getValor(), 0.00001);
		assertEquals(2000.0, leilao.getLances().get(1).getValor(), 0.00001);
		assertEquals(6000.0, leilao.getLances().get(2).getValor(), 0.00001);
		
	}
	
	@Test
	public void rejeitarDoisLancesSeguidosDoMesmoUsuario() {
		
		Leilao leilao = new Leilao("Macbook Pro 16");
		
		Usuario samuel = new Usuario("Samuel");
		
		leilao.propoe(new Lance(samuel, 2000.0));
		leilao.propoe(new Lance(samuel, 3000.0));
		
		assertEquals(1, leilao.getLances().size());
		assertEquals(2000.0, leilao.getLances().get(0).getValor(), 0.00001);
		
	}

}
