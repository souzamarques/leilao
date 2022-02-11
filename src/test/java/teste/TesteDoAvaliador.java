package teste;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import builder.CriadorDeLeilao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import dominio.Avaliador;
import dominio.Lance;
import dominio.Leilao;
import dominio.Usuario;

public class TesteDoAvaliador {
	
	private Avaliador leiloeiro;
	private Usuario daniele;
	private Usuario eduardo;
	private Usuario joao;
	private Usuario juliana;
	private Usuario lucia;
	private Usuario paulo;
	private Usuario pedro;
	private Usuario mateus;

	
	@Before
	public void criaAvaliador() {
		this.leiloeiro = new Avaliador();
		this.daniele = new Usuario("Daniele");
		this.eduardo = new Usuario("Eduardo");
		this.joao = new Usuario("João");
		this.juliana = new Usuario("Juliana");
		this.lucia = new Usuario("Lúcia");
		this.paulo = new Usuario("Paulo");
		this.pedro = new Usuario("Pedro");
		this.mateus = new Usuario("Mateus");
	}
	
	@Test(expected=RuntimeException.class)
	public void NaoAvaliarLeilaoSemNenhumLance() {
		
		Leilao leilao = new CriadorDeLeilao().para("Xiaomi").constroi();
		
		leiloeiro.avalia(leilao);
		
	}
	
	@Test
	public void LancesEmOrdemDecrescente() {
		
		// parte 1: cenário
		Leilao leilao = new CriadorDeLeilao().para("Iphone 13")
				.lance(daniele, 1000.0)
				.lance(eduardo, 900.0)
				.lance(joao, 1300.0)
				.lance(juliana, 700.0)
				.lance(lucia, 650.0)
				.lance(paulo, 800.0)
				.lance(pedro, 1200.0)
				.lance(mateus, 300.0)
				.constroi();
		
		// parte 2: ação
		leiloeiro.avalia(leilao);
		
		// parte 3: validação
		double maiorLanceEsperado = 1300.0;
		double menorLanceEsperado = 300.0;
		
		assertEquals(maiorLanceEsperado, leiloeiro.getMaiorLance(), 0.00001);
		assertEquals(menorLanceEsperado, leiloeiro.getMenorLance(), 0.00001);
		
		
	}
	
	@Test
	public void EncontrarTresMaioresLances() {
		
		Leilao leilao = new CriadorDeLeilao().para("Motorola Edge 20 Pro")
				.lance(daniele, 1000.0)
				.lance(eduardo, 900.0)
				.lance(joao, 1300.0)
				.lance(juliana, 700.0)
				.lance(lucia, 650.0)
				.lance(paulo, 800.0)
				.lance(pedro, 1200.0)
				.lance(mateus, 300.0)
				.constroi();
		
		leiloeiro.avalia(leilao);
		
		List<Lance> maiores = leiloeiro.getTresMaiores();
		assertEquals(3, maiores.size());
		assertEquals(1300.0, maiores.get(0).getValor(), 0.00001);
		assertEquals(1200.0, maiores.get(1).getValor(), 0.00001);
		assertEquals(1000.0, maiores.get(2).getValor(), 0.00001);
		
	}
	
}
