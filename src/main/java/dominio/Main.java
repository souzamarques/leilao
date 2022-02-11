package dominio;

import builder.CriadorDeLeilao;

public class Main {

	public static void main(String[] args) {
		Avaliador leiloeiro = new Avaliador();
		Usuario daniele = new Usuario("Daniele");
		Usuario eduardo = new Usuario("Eduardo");
		Usuario joao = new Usuario("João");
		Usuario juliana = new Usuario("Juliana");
		Usuario pedro = new Usuario("Pedro");
		Usuario mateus = new Usuario("Mateus");
		
		Leilao leilao = new CriadorDeLeilao().para("Iphone 13")
				.lance(daniele, 1000.0)
				.lance(eduardo, 900.0)
				.lance(joao, 1300.0)
				.lance(juliana, 700.0)
				.lance(pedro, 1200.0)
				.lance(mateus, 300.0)
				.constroi();
		
		
	}

}
