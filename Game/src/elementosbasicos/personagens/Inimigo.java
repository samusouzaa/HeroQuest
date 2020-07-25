package elementosbasicos.personagens;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import Externos.Dados;
import Externos.Direcao;
import Externos.TipoDado;
import Usaveis.Arma;
import elementosbasicos.GameObject;
import elementosbasicos.Mapa;
import elementosbasicos.Parede;
import excecoes.ArmaInvalidaException;
import excecoes.DigitoInvalidoException;


public abstract class Inimigo extends GameObject {
	public Inimigo(int x, int y, int hp, int ip, int atq, int defesa, String icon) {
		super(x, y, hp, ip, atq, defesa, icon);
	}

	private ArrayList<GameObject> herois_proximos = new ArrayList<GameObject>();

	public abstract void Andar(Mapa mapa);

	protected int Defender() {
		int numeroDados = this.getDefesa(); // + armadura.getDefesa; obs.: herois n�o possuem aramadura
		int aux;
		int dadoAliado = 0;
		for (int i = 0; i < numeroDados; i++) {
			aux = Dados.resultadoDado(TipoDado.LUTA);
			if (aux == 6)
				dadoAliado += 1;
		}
		return dadoAliado;
	}

	public GameObject heroisTurno(Mapa mapa, Arma arma) {

		int x = this.getX();
		int y = this.getY();
		int posicao_heroi = 1;
		int alcance = 1;
		boolean existe_heroi = false;

		if (arma != null)
			alcance = arma.getAlcance();

		GameObject heroi_atacado;

		for (int i = 1; i <= alcance; i++) {
			// verifica herois acima
			if (mapa.getObjetoMapa(x, y + i) instanceof Heroi) {
				herois_proximos.add((GameObject) mapa.getObjetoMapa(x, y + i));
				posicao_heroi++;
				existe_heroi = true;
			}

			else if (mapa.getObjetoMapa(x, y + i) instanceof Parede)
				break;
		}

		for (int i = 1; i <= alcance; i++) {
			// verifica herois na direita
			if (mapa.getObjetoMapa(x + i, y) instanceof Heroi) {
				herois_proximos.add((GameObject) mapa.getObjetoMapa(x + i, y));
				posicao_heroi++;
				existe_heroi = true;
			}

			else if (mapa.getObjetoMapa(x + i, y) instanceof Parede)
				break;
		}

		for (int i = 1; i <= alcance; i++) {
			// verifica herois embaixo
			if (mapa.getObjetoMapa(x, y - i) instanceof Heroi) {
				herois_proximos.add((GameObject) mapa.getObjetoMapa(x, y - i));
				posicao_heroi++;
				existe_heroi = true;
			}

			else if (mapa.getObjetoMapa(x, y - i) instanceof Parede)
				break;
		}

		for (int i = 1; i <= alcance; i++) {
			// verifica herois na esquerda
			if (mapa.getObjetoMapa(x - i, y) instanceof Heroi) {
				herois_proximos.add((GameObject) mapa.getObjetoMapa(x - i, y));
				posicao_heroi++;
				existe_heroi = true;
			} else if (mapa.getObjetoMapa(x - i, y) instanceof Parede)
				break;
		}

		// Se existir algum heroi proximo, perguntamos se o ataque ocorrer
		if (existe_heroi == true) {
			// Se nao quiser realizar ataque
			int heroi_escolhido = new Random().nextInt(herois_proximos.size());
			heroi_atacado = herois_proximos.get(heroi_escolhido);
			return heroi_atacado;
		}

		else
			return null;
	}

	public boolean realizaAtaque(Mapa mapa) throws DigitoInvalidoException {

		Arma arma_ataque = null;

		if (Armado()) {
			int escolhe_arma = new Random().nextInt(2);

			if (escolhe_arma == 0)
				arma_ataque = this.getArmaD();

			else
				arma_ataque = this.getArmaE();
		}

		GameObject heroi = heroisTurno(mapa, arma_ataque);
		if (heroi != null) {
			try {
				this.Atacar(heroi, arma_ataque);
			} catch (ArmaInvalidaException e) {
			}
			return true;
		} else
			return false;
	}

}
