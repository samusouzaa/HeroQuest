package sistema;

import Usaveis.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import elementosbasicos.*;
import elementosbasicos.personagens.*;
import excecoes.DigitoInvalidoException;

public class HeroQuest {
	private Mapa mapa;
	private ArrayList<GameObject> herois;
	private ArrayList<GameObject> inimigos;

	InicializaUtilizaveis utilizaveis = new InicializaUtilizaveis();

	private ListaItens magias = utilizaveis.inicializaMagias();
	private ListaItens armas = utilizaveis.inicializaArmas();
	private ListaItens itens = utilizaveis.inicializaItens();

	public HeroQuest() {
		herois = new ArrayList<GameObject>();
		inimigos = new ArrayList<GameObject>();

		mapa = new Mapa();
		mapa.CriarMapaPadrao();
		loadMapFromFile();
		EscolherPersonagem();
//		mapa.CriarMapaPadrao();
//
//
//		mapa.addObjeto(feiticeiro);
////		mapa.addObjeto(barbaro);
////		mapa.addObjeto(elfo);
////		mapa.addObjeto(anao);
////		mapa.addObjeto(goblin);

	}

	private boolean Ganhou() {
		for (GameObject inimigo : inimigos) {
			if (!inimigo.isAlive())
				return false;
		}
		return true;
	}

	private boolean Perdeu() {
		for (GameObject aliado : herois) {
			if (!aliado.isAlive())
				return false;
		}
		return true;
	}

	protected void Jogar() {
		Scanner keyboard = new Scanner(System.in);
		String command;
		boolean andar, acao;

		while (true) {

			// Vez dos herois
			for (GameObject heroi : herois) {
				heroi.Vez();

				andar = false;
				acao = false;
				while (!andar || !acao) {

					System.out.println("Selecione sua acao [w/a/m/n]");
					command = keyboard.nextLine();
					if (command.compareTo("w") == 0 && !andar) {
						try {
							heroi.Andar(mapa);

						} catch (DigitoInvalidoException exception) {
							System.out.println(exception.getMessage());
						}

						andar = true;
					}

					else if (command.compareTo("a") == 0 && !acao) {
						((Heroi) heroi).realizaAtaque(mapa);
						acao = true;
					}

					else if (command.compareTo("m") == 0 && !acao) {
						heroi.escolheMagia(mapa);
						acao = true;
					}

					else if (command.compareTo("o") == 0) {
						mapa.AbrirPorta(heroi);
					}

					else if (command.compareTo("n") == 0) {
						break;
					}

					else
						System.out.println("Voce ja usou esta acao"); // na entendeu

					mapa.Ver(heroi.getX(), heroi.getY());
					mapa.Ver(heroi.getX() + 1, heroi.getY());
					mapa.Ver(heroi.getX() - 1, heroi.getY());
					mapa.Ver(heroi.getX(), heroi.getY() + 1);
					mapa.Ver(heroi.getX(), heroi.getY() - 1);
					mapa.printMap();
					EnterrarCorpos(inimigos);
				}

			}

			for (GameObject inimigo : inimigos) {
				if (inimigo.getVisibilidade())
					try {
						inimigo.Vez();
						((Inimigo) inimigo).realizaAtaque(mapa);
						inimigo.escolheMagia(mapa);
						inimigo.Andar(mapa);

					} catch (DigitoInvalidoException exception) {
						System.out.println(exception.getMessage());
					}
				EnterrarCorpos(herois);
			}

		}

//			if(Ganhou()) {
//				System.out.println("Voce ganhou");
//				break;
//			}
//			
//			if(Perdeu()) {
//				System.out.println("Voce perdeu");
//				break;
//			}

	}

	private void loadMapFromFile() {
		try {
			File myObj = new File("mapa.txt");
			System.out.println(myObj.getAbsolutePath());
			Scanner myReader = new Scanner(myObj);
			int i = 0;
			int maior = 0;
			String numero;

			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				numero = myReader.nextLine();
				int x = Integer.parseInt(numero);
				numero = myReader.nextLine();
				int y = Integer.parseInt(numero);

				if (data.compareTo("X") == 0) {
					Parede parede = new Parede(x, y, true);
					mapa.addObjeto(parede);
				}

				else if (data.compareTo("P") == 0) {
					Porta porta = new Porta(x, y);
					mapa.addObjeto(porta);
				}

				else if (data.compareTo("A") == 0) {
					Anao anao = new Anao(x, y);
					mapa.addObjeto(anao);
					herois.add(anao);
				}

				else if (data.compareTo("E") == 0) {
					Elfo elfo = new Elfo(x, y);
					mapa.addObjeto(elfo);
					herois.add(elfo);
				}

				else if (data.compareTo("B") == 0) {
					Barbaro barbaro = new Barbaro(x, y);
					mapa.addObjeto(barbaro);
					herois.add(barbaro);
				}

				else if (data.compareTo("F") == 0) {
					Feiticeiro feiticeiro = new Feiticeiro(x, y);
					mapa.addObjeto(feiticeiro);
					herois.add(feiticeiro);
				}

				else if (data.compareTo("e") == 0) {
					Esqueleto esqueleto = new Esqueleto(x, y);
					mapa.addObjeto(esqueleto);
					inimigos.add(esqueleto);
				}

				else if (data.compareTo("m") == 0) {
					EsqueletoMago esqueleto = new EsqueletoMago(x, y);
					mapa.addObjeto(esqueleto);
					inimigos.add(esqueleto);
				}

				else if (data.compareTo("g") == 0) {
					Goblin goblin = new Goblin(x, y);
					mapa.addObjeto(goblin);
					inimigos.add(goblin);
				}
			}

		} catch (FileNotFoundException e) {
			System.out.println("Não foi possível encontrar mapa");
			e.printStackTrace();
		}
	}

	private void EnterrarCorpos(ArrayList<GameObject> corpos) {
		for (int i = 0; i < corpos.size(); i++) {
			if (corpos.get(i).getHp() <= 0) {
				mapa.removeObjeto(corpos.get(i));
				corpos.remove(corpos.get(i));
				i--;
			}
		}
	}

	private void EscolherPersonagem() {
		System.out.println("Quantos jogadores jogarão? [1/4]");

		Scanner keyboard = new Scanner(System.in);
		int command = keyboard.nextInt();
		boolean b = false;
		boolean a = false;
		boolean f = false;
		boolean e = false;
		boolean existe;
		String heroi = keyboard.nextLine();
		for (int i = 0; i < command; i++) {
			System.out.println("Escolha o personagem para jogador " + (i+1) + " [A/B/F/E]");
			heroi = keyboard.nextLine().toLowerCase();
			existe = false;

			if (heroi.compareTo("a") == 0) {
				if (!a) {
					for (GameObject player : herois) {
						if (player instanceof Anao) {
							existe = true;
							((Heroi) player).escolherPlayer();
							a = true;
						}
					}
					if (!existe) {
						System.out.println("Personagem nao esta disponivel");
						i--;
					}

				} else
					System.out.println("Personagem ja foi escolhido");

			}

			else if (heroi.compareTo("b") == 0) {
				if (!b) {
					for (GameObject player : herois) {
						if (player instanceof Barbaro) {
							existe = true;
							((Heroi) player).escolherPlayer();
							b = true;
						}

					}
					if (!existe) {
						System.out.println("Personagem nao esta disponivel");
						i--;
					}
				} else
					System.out.println("Personagem ja foi escolhido");
			}

			else if (heroi.compareTo("f") == 0) {
				if (!f) {
					for (GameObject player : herois) {
						if (player instanceof Feiticeiro) {
							existe = true;
							((Heroi) player).escolherPlayer();
							f = true;
						}
					}
					if (!existe) {
						System.out.println("Personagem nao esta disponivel");
						i--;
					}

				} else
					System.out.println("Personagem ja foi escolhido");
			}

			else if (heroi.compareTo("e") == 0) {
				if (!e) {
					for (GameObject player : herois) {
						if (player instanceof Elfo) {
							existe = true;
							((Heroi) player).escolherPlayer();
							e = true;
						}
					}
					if (!existe) {
						System.out.println("Personagem nao esta disponivel");
						i--;
					}
				} else
					System.out.println("Personagem ja foi escolhido");

			} else {
				System.out.println("Comando invalido");
				i--;
			}

		}
	}

}
