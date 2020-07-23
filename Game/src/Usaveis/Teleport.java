package Usaveis;

import java.util.Scanner;

import Externos.Dados;
import Externos.Direcao;
import Externos.TipoDado;
import elementosbasicos.Mapa;
import elementosbasicos.GameObject;

public class Teleport extends Magia {

	private static final String nome = "Teleport";

	public Teleport() {
		super(nome);
		// TODO Auto-generated constructor stub
	}

	public void Usar(GameObject gameobject, Mapa mapa) {
		// Jogar dados
		Scanner keyboard = new Scanner(System.in);
		Direcao direcao;
		boolean conferido = false;
		boolean verificado = false;
		int xi = gameobject.getX();
		int yi = gameobject.getY();
		mapa.removeObjeto(gameobject);

		while (!conferido || !verificado) {
			gameobject.atualizaCoordinate(xi, yi);
			Mapa copia = mapa.getCopia();
			while (true) {
				copia.addObjeto(gameobject);

				System.out.println("Digite a próxima direção e [C] para confirmar a posicao");
				String command = keyboard.nextLine();

				if (command.compareTo("w") == 0)
					direcao = Direcao.UP;
				else if (command.compareTo("a") == 0)
					direcao = Direcao.LEFT;
				else if (command.compareTo("d") == 0)
					direcao = Direcao.RIGHT;
				else if (command.compareTo("s") == 0)
					direcao = Direcao.DOWN;
				else {
					conferido = true;
					break;
				}

				gameobject.Mover(direcao, copia);

				copia.printMap();

				conferido = false;
			}

			verificado = Teletransportavel(mapa, gameobject, xi, yi);
			if(!verificado) 
				System.out.println("Voce nao pode se teleportar para ca");
			

		}

		mapa.addObjeto(gameobject);
		mapa.printMap();

	}

	private boolean Teletransportavel(Mapa mapa, GameObject gameobject, int xi, int yi) {
		int x = gameobject.getX();
		int y = gameobject.getY();
		if (mapa.getObjetoMapa(x, y) != null) {
			return false;
		} else {
			for (int i = xi; i < mapa.getAltura(); i++) {
				if (mapa.getObjetoMapa(i, yi) != null)
					break;
				if (i == x && y == yi) {
					return true;
				}
			}
			for (int i = xi; i > 0; i--) {
				if (mapa.getObjetoMapa(i, yi) != null)
					break;
				if (i == x && y == yi) {
					return true;
				}
			}

			for (int i = yi; i < mapa.getLargura(); i++) {
				if (mapa.getObjetoMapa(xi, i) != null)
					break;
				if (i == yi && x == xi) {
					return true;
				}
			}

			for (int i = yi; i > 0; i--) {
				if (mapa.getObjetoMapa(xi, i) != null)
					break;
				if (i == yi && x == xi) {
					return true;
				}
			}

		}
		return false;
	}
}
