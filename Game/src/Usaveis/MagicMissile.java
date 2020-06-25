package Usaveis;

import elementosbasicos.GameObject;
import java.util.Scanner;
import Externos.Direcao;

public class MagicMissile extends Magia {

	private static final String nome = "MagicMissile";

	MagicMissile() {
		super(nome);
		// TODO Auto-generated constructor stub
	}

	private GameObject getPrimeiroInimigo(Direcao direcao) {
		//Essa função vai percorrer o mapa numa direção e devolver um inimigo assim que o vir
	}

	@Override
	public void Usar(GameObject gameobject) {
		// TODO Auto-generated method stub
		for (int i = 0; i < 3; i++) {
			System.out.println("Digite a direção na qual você atirará");
			Scanner keyboard = new Scanner(System.in);

			String command = keyboard.nextLine();
			Direcao direcao;

			switch (command) {
			case "s":
				direcao = Direcao.DOWN;
			case "d":
				direcao = Direcao.RIGHT;
			case "a":
				direcao = Direcao.LEFT;
			default:
				direcao = Direcao.UP;
			}

			GameObject inimigo = getPrimeiroInimigo(direcao);
			inimigo.receberDano(2);
		}

	}

}
