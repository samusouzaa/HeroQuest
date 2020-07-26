package sistema;

import excecoes.DigitoInvalidoException;

public class Main {
	public static void main(String[] args) {
		HeroQuest jogo = new HeroQuest("mapa.txt");
		jogo.Jogar();
	}
}
