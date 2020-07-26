package sistema;

import excecoes.DigitoInvalidoException;

public class Main {
	public static void main(String[] args) {

		HeroQuest jogo = new HeroQuest();
		boolean valido = true;
		do {
			try {
				jogo.Jogar();
			} catch (DigitoInvalidoException e) {
				valido = false;
				System.out.println(e.getMessage());
			}
		} while (!valido);
	}
}
