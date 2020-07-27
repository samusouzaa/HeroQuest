//Projeto final de MC322
//Pedro Andrade Ferreira Sobrinho 242887
//Thais Steinmuller Farias 224707
//Samuel Souza 244192
package sistema;

import java.util.Scanner;

import excecoes.DigitoInvalidoException;

public class Main {
	public static void main(String[] args) {

		Scanner keyboard = new Scanner(System.in);
		String command;
		System.out.println("Bem vindo a HeroQuest");
		System.out.println("Digite S para jogar uma mapa no sistema");
		System.out.println("Digite qualquer outra letra para jogar uma mapa aleatorio");
		
		command = keyboard.nextLine().toLowerCase();
		HeroQuest jogo; 
		
		if (command.compareTo("s") == 0) {
			System.out.println("Digite o nome do arquivo");
			String filename = keyboard.nextLine();

			jogo = new HeroQuest(filename);
		}
		else
			jogo = new HeroQuest();
		
		jogo.Jogar();
			
	}
}
