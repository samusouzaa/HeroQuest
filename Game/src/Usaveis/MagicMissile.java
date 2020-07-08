package Usaveis;

import elementosbasicos.*;
import elementosbasicos.GameObject;
import elementosbasicos.Mapa;

import java.util.Scanner;

import Externos.Direcao;

public class MagicMissile extends Magia {

	private static final String nome = "MagicMissile";

	MagicMissile() {
		super(nome);
		// TODO Auto-generated constructor stub
	}

	private Objeto getPrimeiroInimigo(int x, int y, Direcao direcao, Mapa mapa) {
		// Essa função vai percorrer o mapa numa direção e devolver um inimigo assim que
		// o vir
		Objeto inimigo = null;
		int nx = x;
		int ny = y;

		while (inimigo == null) {
			switch (direcao) {
			case DOWN:
				nx += 1;

			case RIGHT:
				ny += 1;

			case LEFT:
				ny -= 1;

			default:
				nx -= 1;

			}
			if(nx > mapa.getAltura() || ny > mapa.getLargura())
				break;
			
			inimigo = mapa.getObjetoMapa(nx, ny);
		
		}
		return inimigo;	
	}

	@Override
	public void Usar(GameObject gameobject, Mapa mapa) {
		// TODO Auto-generated method stub
		for (int i = 0; i < 3; i++) {
			int x = gameobject.getX();
			int y = gameobject.getY();

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

			Objeto alvo = getPrimeiroInimigo(x, y, direcao, mapa);
			if(alvo != null) {
				alvo.receberDano(2);
			}
		}

	}

}
