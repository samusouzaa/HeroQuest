package elementosbasicos.personagens;

import Externos.Coordenada;
import Externos.Dados;
import Externos.Direcao;
import Externos.TipoDado;
import Usaveis.Arma;
import Usaveis.Armadura;
import Usaveis.Item;
import Usaveis.Magia;
import Usaveis.Moedas;
import Usaveis.TipoArma;
import elementosbasicos.Bau;
import elementosbasicos.GameObject;
import elementosbasicos.Mapa;
import elementosbasicos.Parede;
import excecoes.ArmaInvalidaException;
import excecoes.DigitoInvalidoException;
import excecoes.GameException;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public abstract class Heroi extends GameObject {

	public Heroi(int x, int y, int hp, int ip, int atq, int dfs, String icon) {
		super(x, y, hp, ip, atq, dfs, icon);
		this.Visto();
	}

	private boolean eh_player = false;
	private int moedas = 0;
	
	protected int getMoedas() {
		return moedas;
	}
	public void setPlayer(boolean eh_player) {
		this.eh_player = eh_player;
	}

	public boolean getPlayer() {
		return eh_player;
	}

	private ArrayList<GameObject> inimigos_proximos = new ArrayList<GameObject>();

	public void Andar(Mapa mapa) throws DigitoInvalidoException {
		int passos = Dados.resultadoDado(TipoDado.COMUM);

		if (eh_player) {
			Scanner keyboard = new Scanner(System.in);
			Direcao direcao = null; 
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

					System.out.println("Digite a prï¿½xima direï¿½ï¿½o ou 'q' se desejar parar");
					String command = keyboard.nextLine().toLowerCase();

					try {
						if (command.compareTo("w") == 0)
							direcao = Direcao.UP;
						else if (command.compareTo("a") == 0)
							direcao = Direcao.LEFT;
						else if (command.compareTo("d") == 0)
							direcao = Direcao.RIGHT;
						else if (command.compareTo("s") == 0)
							direcao = Direcao.DOWN;
						else if (command.compareTo("q") == 0)
							break;
						else
							throw new DigitoInvalidoException(); // OK
					} catch (DigitoInvalidoException exception) {

						System.out.println(exception.getMessage());
					}

					this.Mover(direcao, copia);

					copia.printMap();
				}
				System.out.println("Esta ï¿½ a posiï¿½ï¿½o desejada? [Y/N]");

				String command = keyboard.nextLine().toLowerCase();
				if (command.compareTo("y") == 0)
					conferido = true;
				else
					conferido = false;

				verificado = mapa.verificarPosicao(getX(), getY());
			}
			mapa.addObjeto(this);
			mapa.printMap();
		}

		else {
			ArrayList<Direcao> lugares_andar = new ArrayList<Direcao>();

			if (mapa.verificarPosicao(this.getX() - 1, this.getY()))
				lugares_andar.add(Direcao.UP);

			if (mapa.verificarPosicao(this.getX() + 1, this.getY()))
				lugares_andar.add(Direcao.DOWN);

			if (mapa.verificarPosicao(this.getX(), this.getY() + 1))
				lugares_andar.add(Direcao.RIGHT);

			if (mapa.verificarPosicao(this.getX(), this.getY() - 1))
				lugares_andar.add(Direcao.LEFT);

			if (lugares_andar.size() == 0)
				return;

			else {
				int posicao = new Random().nextInt(lugares_andar.size());
				for (int i = 0; i < passos; i++) {
					if (mapa.verificarPosicao(this, lugares_andar.get(posicao))) {
						this.Mover(lugares_andar.get(posicao), mapa);
						mapa.printMap();
					} else
						break;
				}

			}
		}

	}
	
	protected Bau verificaTesouro(Heroi heroi, Mapa mapa) {
		
		int x = heroi.getX();
		int y = heroi.getY();
		
		if (mapa.getObjetoMapa(x, y + 1) instanceof Bau) {
			return (Bau) mapa.getObjetoMapa(x, y + 1);
		}
		
		else if (mapa.getObjetoMapa(x, y - 1) instanceof Bau)
			return (Bau) mapa.getObjetoMapa(x, y - 1);
		
		else if (mapa.getObjetoMapa(x+1, y) instanceof Bau)
			return (Bau) mapa.getObjetoMapa(x+1, y);

		else if (mapa.getObjetoMapa(x-1, y) instanceof Bau)
			return (Bau) mapa.getObjetoMapa(x-1, y);
		
		else if (mapa.getObjetoMapa(x-1, y + 1) instanceof Bau)
			return (Bau) mapa.getObjetoMapa(x-1, y + 1);
		
		else if (mapa.getObjetoMapa(x-1, y - 1) instanceof Bau)
			return (Bau) mapa.getObjetoMapa(x-1, y - 1);
		
		else if (mapa.getObjetoMapa(x+1, y + 1) instanceof Bau)
			return (Bau) mapa.getObjetoMapa(x+1, y + 1);
		
		else if (mapa.getObjetoMapa(x+1, y - 1) instanceof Bau)
			return (Bau) mapa.getObjetoMapa(x+1, y - 1);
		
		else
			return null;
	}
	
	public void buscarTesouro(Heroi heroi, Mapa mapa) {
		Bau bau;
		
		bau = verificaTesouro(heroi, mapa);
		
		if (bau != null) {
			System.out.println("Você encontrou um bau, deseja abri-lo?");
			System.out.println("y = sim");
			System.out.println("n = nÃƒÂ£o");
			Scanner in = new Scanner(System.in);
			String s = in.nextLine().toLowerCase(); 
			if (s.compareTo("y") == 0) {
				bau.abrirBau(heroi);
				}
			else
				System.out.println("O baú continuará nessa posição");

		}
		
		else
			return;
	}
	
	public void adicionaItemBau(Item item) {
		if (item instanceof Arma) {
			if (((Arma) item).getDestrutivel()) {
				this.adicionaItem(item);
			}
			else {
				if(!this.ArmadoD()) {
					System.out.println("A arma será equipada na mão direita");
					this.equipar(false, (Arma) item);
				}
				
				else if(!this.ArmadoE()) {
					System.out.println("A arma será equipada na mão esquerda");
					this.equipar(true, (Arma) item);
				}
				
				else {
					System.out.println("As duas maos estão cheias, deseja trocar de arma?");
					System.out.println("y = sim");
					System.out.println("n = nÃƒÂ£o");
					Scanner in = new Scanner(System.in);
					String s = in.nextLine().toLowerCase(); 
					if (s.compareTo("y") == 0) {
						System.out.println("1. Empunhar na direita");
						System.out.println("2. Empunhar na esquerda");
						int command = in.nextInt();
						if (command == 1)
							this.equipar(true, (Arma) item);
						
						else if (command == 2)
							this.equipar(false, (Arma) item);
						
						else
							System.out.println("A arma foi jogada fora");
						
					}
						
					else
						System.out.println("A arma foi jogada fora");

				}
			}
		}
		
		else if (item instanceof Magia) {
			this.adicionaMagia((Magia) item);
		}
		
		else if (item instanceof Moedas) {
			this.moedas += ((Moedas) item).getValor();
			this.adicionaItem(item);
		}
		
		else if (item instanceof Armadura) {
			System.out.println("Você tem uma " + this.armadura.getChave() + ", deseja trocar?");
			System.out.println("y = sim");
			System.out.println("n = nÃƒÂ£o");
			Scanner in = new Scanner(System.in);
			String s = in.nextLine().toLowerCase(); 
			if (s.compareTo("y") == 0) {
				this.setArmadura((Armadura) item);
				}
			else
				System.out.println("A armadura do baú foi jogada fora");
		}
	}
	protected int Defender() {
		int numeroDados = this.getDefesa() + this.getArmadura();
		int aux;
		int dadoAliado = 0;
		for (int i = 0; i < numeroDados; i++) {
			aux = Dados.resultadoDado(TipoDado.LUTA);
			if (aux > 3 && aux < 6)
				dadoAliado += 1;
		}
		return dadoAliado;
	}

	public int BloquearMagia() {
		int numeroDados = this.getIp();
		int aux;
		int dadoAliado = 0;
		System.out.println("Dados de Bloqueio da Magia");
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

		else {
			if (this.eh_player) {

				for (Magia magia : magias)
					System.out.println(magias.indexOf(magia) + 1 + "." + " " + magia.getChave());
				Scanner keyboard = new Scanner(System.in);
				int magia_escolhida = keyboard.nextInt();

				lancaMagia(magia_escolhida, mapa);

			}

			else {
				int magia_escolhida = new Random().nextInt(magias.size());
				lancaMagia(magia_escolhida + 1, mapa);
			}

		}

	}

	private GameObject inimigosTurno(Mapa mapa, Arma arma) {

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
						"Pressione " + posicao_inimigo + " para atacar o " + mapa.getObjetoMapa(x, y + i).toString()
								+ " (vida: " + ((GameObject) mapa.getObjetoMapa(x, y + i)).getHp() + ")");
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
						"Pressione " + posicao_inimigo + " para atacar o " + mapa.getObjetoMapa(x + i, y).toString()
								+ " (vida: " + ((GameObject) mapa.getObjetoMapa(x + i, y)).getHp() + ")");
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
						"Pressione " + posicao_inimigo + " para atacar o " + mapa.getObjetoMapa(x, y - i).toString()
								+ " (vida: " + ((GameObject) mapa.getObjetoMapa(x, y - i)).getHp() + ")");
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
						"Pressione " + posicao_inimigo + " para atacar o " + mapa.getObjetoMapa(x - i, y).toString()
								+ " (vida: " + ((GameObject) mapa.getObjetoMapa(x - i, y)).getHp() + ")");
				inimigos_proximos.add((GameObject) mapa.getObjetoMapa(x - i, y));
				posicao_inimigo++;
				existe_inimigo = true;
			} else if (mapa.getObjetoMapa(x - i, y) instanceof Parede)
				break;
		}

		// Se existir algum inimigo proximo, perguntamos se o ataque ocorrer
		if (existe_inimigo == true) {
			if (this.eh_player) {
				System.out.println("Pressione qualquer outra tecla se nï¿½o quiser realizar o ataque");

				Scanner keyboard = new Scanner(System.in);
				int inimigo_escolhido = keyboard.nextInt();
				if (inimigo_escolhido > 0 && inimigo_escolhido <= posicao_inimigo - 1) {
					inimigo_atacado = inimigos_proximos.get(inimigo_escolhido - 1);
					inimigos_proximos.clear();
					return inimigo_atacado;
				} else
					return null;
			} else {
				int inimigo_escolhido = new Random().nextInt(inimigos_proximos.size());
				inimigo_atacado = inimigos_proximos.get(inimigo_escolhido);
				return inimigo_atacado;
			}

		}
		return null;

	}

	public boolean realizaAtaque(Mapa mapa) {

		Arma arma_ataque = null;
		boolean utilizou_punhal = false;
		
		if(this.temPunhal()) {
			System.out.println("VocÃª possui um punhal, deseja utilizÃ¡-lo? VocÃª nÃ£o poderÃ¡ atacar com suas armas apÃ³s essa aÃ§Ã£o");
			System.out.println("y = sim");
			System.out.println("n = nÃƒÂ£o");
			Scanner in = new Scanner(System.in);
			String s = in.nextLine().toLowerCase(); 
			if (s.compareTo("y") == 0) {
				int posicao_punhal = this.retornaPosPunhal();
				if (posicao_punhal < 0)
					return false;
				arma_ataque = (Arma) this.itens.get(posicao_punhal);
				this.excluiItem(posicao_punhal);
				utilizou_punhal = true;
				}
			else
				System.out.println("Voce poderÃ¡ usÃ¡-lo no prÃ³ximo turno");

		} 
		
		if (Armado() && !utilizou_punhal) {

			if (this.eh_player) {
				System.out.println("Usar armas ou disponÃƒÂ­veis?"); 
				System.out.println("y = sim");
				System.out.println("n = nÃƒÂ£o");
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
	
				} else 
					arma_ataque = null;
			}
			
			else {
				int escolhe_arma = new Random().nextInt(2);
				
				if (escolhe_arma == 0)
					arma_ataque = this.getArmaD();
				
				else
					arma_ataque = this.getArmaE();
			}
		}
		
		GameObject inimigo = inimigosTurno(mapa, arma_ataque);
		if (inimigo != null) {
			boolean valido = true;
			do {
				try {
					this.Atacar(inimigo, arma_ataque);
					System.out.println("Vida do " + inimigo.toString() + " apos o ataque: " + inimigo.getHp());
				} catch (ArmaInvalidaException exception) {
					valido = false;
					System.out.print(exception.getMessage());
				}
			} while (!valido);
			return true;
		} else
			return false;
	}
	
	public void escolherPlayer() {
		eh_player = true;
	}
}
