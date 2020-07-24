package elementosbasicos.personagens;

import Externos.Coordenada;
import Externos.Dados;
import Externos.Direcao;
import Externos.TipoDado;
import Usaveis.Arma;
import Usaveis.Magia;
import elementosbasicos.GameObject;
import elementosbasicos.Mapa;
import elementosbasicos.Parede;
import excecoes.ArmaInvalidaException;
import excecoes.DigitoInvalidoException;
import excecoes.GameException;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class Heroi extends GameObject {

	public Heroi(int x, int y, int hp, int ip, int atq, int dfs) {
		super(x, y, hp, ip, atq, dfs);
		this.Visto();
	}

	private ArrayList<GameObject> inimigos_proximos = new ArrayList<GameObject>();

	public void Andar(Mapa mapa) throws DigitoInvalidoException {
		// Jogar dados
		// se um ataque for realizado,ele nao andara mais
		boolean atacou = false;

		int passos = Dados.resultadoDado(TipoDado.COMUM);
		Scanner keyboard = new Scanner(System.in);
		Direcao direcao = Direcao.UP; // inicializei pq ele tava reclamando
		boolean conferido = false;
		boolean verificado = false;
		int xi = getX();
		int yi = getY();
		mapa.removeObjeto(this);

		while (!conferido || !verificado) {
			this.atualizaCoordinate(xi, yi);
			Mapa copia = mapa.getCopia();
			for (int i = 0; i < passos; i++) {
				copia.addObjeto(this);

				System.out.println("Digite a próxima direção");
				String command = keyboard.nextLine();
				boolean valido = true;

				try {
					if (command.compareTo("w") == 0)
						direcao = Direcao.UP;
					else if (command.compareTo("a") == 0)
						direcao = Direcao.LEFT;
					else if (command.compareTo("d") == 0)
						direcao = Direcao.RIGHT;
					else if (command.compareTo("s") == 0)
						direcao = Direcao.DOWN;
					else
						throw new DigitoInvalidoException(); // OK
				} catch (DigitoInvalidoException exception) {
					System.out.println(exception.getMessage());
					valido = false;
				}

				this.Mover(direcao, copia);

				copia.printMap();
			}
			System.out.println("Esta é a posição desejada? [Y/N]");

			String command = keyboard.nextLine();
			if (command.compareTo("Y") == 0)
				conferido = true;
			else
				conferido = false;

			verificado = mapa.verificarPosicao(getX(), getY());

		}

		mapa.addObjeto(this);
		mapa.printMap();
	}

	protected int Defender() {
		int numeroDados = this.getDefesa(); // + armadura.getDefesa;
		int aux;
		int dadoAliado = 0;
		for (int i = 0; i < numeroDados; i++) {
			aux = Dados.resultadoDado(TipoDado.LUTA);
			if (aux > 3 && aux < 6)
				dadoAliado += 1;
		}
		return dadoAliado;
	}
	
	public void escolheMagia(Mapa mapa) {
		
		if (magias.size() <= 0) {
			System.out.println("Voce nao tem magias");
			return;
		}
		
		for (Magia magia : magias)
			System.out.println(magias.indexOf(magia) + 1 + "." + " " + magia.toString());
		Scanner keyboard = new Scanner(System.in);
		int magia_escolhida = keyboard.nextInt();

		lancaMagia(magia_escolhida, mapa);

	}

	private GameObject inimigosTurno(Mapa mapa, Arma arma) throws DigitoInvalidoException {

		int x = this.getX();
		int y = this.getY();
		int posicao_inimigo = 1;
		int alcance = 1;
		boolean existe_inimigo = false;

		if (arma != null)
			alcance = arma.getAlcance();

		GameObject inimigo_atacado;

		for (int i = 1; i <= alcance; i++) {
			// verifica inimigos acima
			if (mapa.getObjetoMapa(x, y + i) instanceof Inimigo) {
				System.out.println(
						"Pressione " + posicao_inimigo + " para atacar o " + mapa.getObjetoMapa(x, y + i).toString() + " (vida: " + ((GameObject) mapa.getObjetoMapa(x, y + i)).getHp() + ")");
				inimigos_proximos.add((GameObject) mapa.getObjetoMapa(x, y + i));
				posicao_inimigo++;
				existe_inimigo = true;
			}

			else if (mapa.getObjetoMapa(x, y + i) instanceof Parede)
				break;
		}

		for (int i = 1; i <= alcance; i++) {
			// verifica inimigos na direita
			if (mapa.getObjetoMapa(x + i, y) instanceof Inimigo) {
				System.out.println(
						"Pressione " + posicao_inimigo + " para atacar o " + mapa.getObjetoMapa(x + i, y).toString()+ " (vida: " + ((GameObject) mapa.getObjetoMapa(x + i, y)).getHp() + ")");
				inimigos_proximos.add((GameObject) mapa.getObjetoMapa(x + i, y));
				posicao_inimigo++;
				existe_inimigo = true;
			}

			else if (mapa.getObjetoMapa(x + i, y) instanceof Parede)
				break;
		}

		for (int i = 1; i <= alcance; i++) {
			// verifica inimigos embaixo
			if (mapa.getObjetoMapa(x, y - i) instanceof Inimigo) {
				System.out.println(
						"Pressione " + posicao_inimigo + " para atacar o " + mapa.getObjetoMapa(x, y - i).toString()+ " (vida: " + ((GameObject) mapa.getObjetoMapa(x, y - i)).getHp() + ")");
				inimigos_proximos.add((GameObject) mapa.getObjetoMapa(x, y - i));
				posicao_inimigo++;
				existe_inimigo = true;
			}

			else if (mapa.getObjetoMapa(x, y - i) instanceof Parede)
				break;
		}

		for (int i = 1; i <= alcance; i++) {
			// verifica inimigos na esquerda
			if (mapa.getObjetoMapa(x - i, y) instanceof Inimigo) {
				System.out.println(
						"Pressione " + posicao_inimigo + " para atacar o " + mapa.getObjetoMapa(x - i, y).toString()+ " (vida: " + ((GameObject) mapa.getObjetoMapa(x-i, y)).getHp() + ")");
				inimigos_proximos.add((GameObject) mapa.getObjetoMapa(x - i, y));
				posicao_inimigo++;
				existe_inimigo = true;
			} else if (mapa.getObjetoMapa(x - i, y) instanceof Parede)
				break;
		}

		// Se existir algum inimigo proximo, perguntamos se o ataque ocorrer
		if (existe_inimigo == true) {
			// Se nao quiser realizar ataque
			System.out.println("Pressione qualquer outra tecla se n�o quiser realizar o ataque");

			Scanner keyboard = new Scanner(System.in);
			int inimigo_escolhido = keyboard.nextInt();
			inimigos_proximos.clear();
			if (inimigo_escolhido > 0 && inimigo_escolhido <= posicao_inimigo - 1) {
				inimigo_atacado = inimigos_proximos.get(inimigo_escolhido - 1);
				return inimigo_atacado;
			} else {
				throw new DigitoInvalidoException();
			}
		}

		else
			return null;
	}

	public boolean realizaAtaque(Mapa mapa) throws DigitoInvalidoException {

		Arma arma_ataque = null;

		if (Armado()) {
			System.out.println("Usar armas disponíveis?"); 
			System.out.println("y = sim");
			System.out.println("n = não");
			Scanner in = new Scanner(System.in);
			String s = in.nextLine().toLowerCase(); 
			if (s.compareTo("y") == 0) {
				boolean valido = true;
				do {
					try {
						arma_ataque = escolhaArmas(); 
					} catch (ArmaInvalidaException e) {
						valido = false;
						System.out.print(e.getMessage());
					}
				} while (!valido);

			} else if (s.compareTo("n") == 0) {
				System.out.println("Não há armas disponíveis");

			} else {
				throw new DigitoInvalidoException();
			}
		}
		GameObject inimigo = inimigosTurno(mapa, arma_ataque);
		if (inimigo != null) {
			boolean valido = true;
			do {
				try {
					this.Atacar(inimigo, arma_ataque);
					System.out.println("Vida do " + inimigo.toString() + " ap�s o ataque: " + inimigo.getHp());
				} catch (ArmaInvalidaException exception) {
					System.out.print(exception.getMessage());
				}
			} while (!valido);
			return true;
		} else
			return false;
	}

}
