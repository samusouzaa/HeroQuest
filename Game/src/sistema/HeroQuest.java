package sistema;

import Usaveis.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.InputMismatchException;
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

	protected HeroQuest() {
		herois = new ArrayList<GameObject>();
		inimigos = new ArrayList<GameObject>();
		
		mapa = new Mapa();
		mapa.CriarMapaPadrao();
		loadRandomMap();
//		mapa.visualizarMapaTodo(); PARA TESTE E DEBUGERS
		boolean valido = true;
		do {
			try {
				valido = true;
				EscolherPersonagem();
			} catch (InputMismatchException exception) {
				valido = false;
				System.out.println("Entrada invalida, tente novamente!");
			} catch (DigitoInvalidoException exception) {
				valido = false;
				System.out.println(exception.getMessage());
			}
		} while (!valido);

	}

	protected HeroQuest(String filename) {
		herois = new ArrayList<GameObject>();
		inimigos = new ArrayList<GameObject>();

		mapa = new Mapa();
		mapa.CriarMapaPadrao();
		
		loadMapFromFile(filename);
		//mapa.visualizarMapaTodo(); FUNCAO PARA DEBUGUER
		boolean valido = true;
		do {
			try {
				EscolherPersonagem();
			} catch (InputMismatchException exception) {
				valido = false;
				System.out.println("Entrada invalida, tente novamente!");
			} catch (DigitoInvalidoException exception) {
				valido = false;
				System.out.println(exception.getMessage());
			}
		} while (!valido);

	}

	private boolean Ganhou() {
		if(inimigos.isEmpty())
			return true;
		return false;
	}

	private boolean Perdeu() {
		if(herois.isEmpty())
			return true;
		else {
			boolean player = false;
			for(GameObject heroi : herois) {
				if(((Heroi) heroi).getPlayer())
					player = true;
			}
			if(player)
				return false;
			return true;
		}
	}

	protected void Jogar() {
		Scanner keyboard = new Scanner(System.in);
		String command;
		boolean andar, acao;
		
		Instrucoes();

		while (!Ganhou() && !Perdeu()) {

			// Vez dos herois
			System.out.println("\n\n");
			System.out.println("Turno dos Herois");
			System.out.println("\n\n");
			for (GameObject heroi : herois) {
				heroi.Vez();
				if (((Heroi) heroi).getPlayer()) {
					andar = false;
					acao = false;
					while (!andar || !acao) {
	
						System.out.println("Selecione sua acao [w/a/m/n/o/t]");
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
							EnterrarCorpos(inimigos);
						}
	
						else if (command.compareTo("m") == 0 && !acao) {
							heroi.escolheMagia(mapa);
							acao = true;
							EnterrarCorpos(inimigos);
						}
	
						else if (command.compareTo("o") == 0) {
							mapa.AbrirPorta(heroi);
						}
						
						else if (command.compareTo("t") == 0) {
							((Heroi) heroi).buscarTesouro((Heroi) heroi, mapa);
							acao = true;
						}
	
						else if (command.compareTo("n") == 0) {
							break;
						} else if (command.compareTo("a") != 0 || command.compareTo("w") != 0 || command.compareTo("s") != 0
								|| command.compareTo("d") != 0) {
							System.out.println("Dígito inválido, tente novamente!");
	
						}
	
						else
	
							System.out.println("Voce ja usou esta acao"); // na entendeu
	
						mapa.Ver(heroi.getX(), heroi.getY());
						mapa.Ver(heroi.getX() + 1, heroi.getY());
						mapa.Ver(heroi.getX() - 1, heroi.getY());
						mapa.Ver(heroi.getX(), heroi.getY() + 1);
						mapa.Ver(heroi.getX(), heroi.getY() - 1);
						mapa.printMap();
					}
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
					System.out.println("\n\n");
				}
				
				else {
					System.out.println(heroi.toString() + " ira andar");
					
					try {
						heroi.Andar(mapa);
					} catch (DigitoInvalidoException e1) {
						// TODO Auto-generated catch block
						e1.getMessage();
					}

					mapa.Ver(heroi.getX(), heroi.getY());
					mapa.Ver(heroi.getX() + 1, heroi.getY());
					mapa.Ver(heroi.getX() - 1, heroi.getY());
					mapa.Ver(heroi.getX(), heroi.getY() + 1);
					mapa.Ver(heroi.getX(), heroi.getY() - 1);
					mapa.printMap();
					
					int acao_controlada = new Random().nextInt(3);
					
					if (acao_controlada == 0) {
						if (heroi.semMagia()) {
							System.out.println(heroi.toString() + " ira atacar");
							((Heroi) heroi).realizaAtaque(mapa);
						}
						
						else {
							System.out.println(heroi.toString() + " ira usar magia");
							heroi.escolheMagia(mapa);
						}
					}
						
					else if(acao_controlada == 1) {
						System.out.println(heroi.toString() + " ir� atacar");
						((Heroi) heroi).realizaAtaque(mapa);
					}
					
					else {
						System.out.println(heroi.toString() + " nao realizara outra acao no turno");
					}
					
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("\n\n");

			}
			
			System.out.println("Turno dos Monstros");
			System.out.println("\n\n");
			for (GameObject inimigo : inimigos) {
				if (inimigo.getVisibilidade())
					try {
						inimigo.Vez();
						((Inimigo) inimigo).realizaAtaque(mapa);
						inimigo.escolheMagia(mapa);
						inimigo.Andar(mapa);
						try {
							Thread.sleep(3000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}

					} catch (DigitoInvalidoException exception) {
						System.out.println(exception.getMessage());
					}
				EnterrarCorpos(herois);
			}
			mapa.printMap();
		}

		if (Ganhou()) {
			System.out.println("Voce ganhou");
		}

		else {
			System.out.println("Voce perdeu");
		}

	}

	private void loadMapFromFile(String filename) {
		try {
			File myObj = new File(filename);
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
				
				else if (data.compareTo("b") == 0) {
					Bau bau = new Bau(x, y, armas, itens, magias);
					mapa.addObjeto(bau);
				}
			}

		} catch (FileNotFoundException e) {
			System.out.println("Nao foi possível encontrar mapa");
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

	private void loadRandomMap() {
		Porta porta = new Porta(10, 17);
		mapa.addObjeto(porta);
		porta = new Porta(13, 14);
		mapa.addObjeto(porta);
		porta = new Porta(13, 21);
		mapa.addObjeto(porta);
		porta = new Porta(17, 17);
		mapa.addObjeto(porta);

		Anao anao = new Anao(13, 17);
		Elfo elfo = new Elfo(13, 18);
		Barbaro barbaro = new Barbaro(14, 17);
		Feiticeiro feiticeiro = new Feiticeiro(14, 18);
		mapa.addObjeto(anao);
		mapa.addObjeto(feiticeiro);
		mapa.addObjeto(elfo);
		mapa.addObjeto(barbaro);

		herois.add(feiticeiro);
		herois.add(barbaro);
		herois.add(elfo);
		herois.add(anao);

		porta = new Porta(10, 12);
		mapa.addObjeto(porta);
		porta = new Porta(6, 12);
		mapa.addObjeto(porta);
		porta = new Porta(10, 7);
		mapa.addObjeto(porta);
		porta = new Porta(5, 4);
		mapa.addObjeto(porta);
		porta = new Porta(4, 7);
		mapa.addObjeto(porta);

		porta = new Porta(15, 10);
		mapa.addObjeto(porta);
		porta = new Porta(18, 9);
		mapa.addObjeto(porta);
		porta = new Porta(16, 6);
		mapa.addObjeto(porta);
		porta = new Porta(21, 16);
		mapa.addObjeto(porta);
		porta = new Porta(11, 10);
		mapa.addObjeto(porta);
		porta = new Porta(20, 6);
		mapa.addObjeto(porta);
		porta = new Porta(22, 19);
		mapa.addObjeto(porta);
		porta = new Porta(20, 26);
		mapa.addObjeto(porta);
		porta = new Porta(15, 30);
		mapa.addObjeto(porta);
		porta = new Porta(20, 30);
		mapa.addObjeto(porta);

		porta = new Porta(8, 21);
		mapa.addObjeto(porta);
		porta = new Porta(4, 23);
		mapa.addObjeto(porta);
		porta = new Porta(5, 25);
		mapa.addObjeto(porta);
		porta = new Porta(10, 17);
		mapa.addObjeto(porta);
		
		Bau bau = new Bau(3, 20, armas, itens, magias);
		mapa.addObjeto(bau);
		bau = new Bau(23, 7, armas, itens, magias);
		mapa.addObjeto(bau);
		bau = new Bau(18, 19, armas, itens, magias);
		mapa.addObjeto(bau);
		bau = new Bau(20, 23, armas, itens, magias);
		mapa.addObjeto(bau);
	


		AdicionarMonstroAleatorio(3, 4);
		AdicionarMonstroAleatorio(8, 4);
		AdicionarMonstroAleatorio(4, 9);
		AdicionarMonstroAleatorio(10, 10);

		AdicionarMonstroAleatorio(18, 4);
		AdicionarMonstroAleatorio(19, 9);
		AdicionarMonstroAleatorio(19, 11);
		AdicionarMonstroAleatorio(22, 4);
		AdicionarMonstroAleatorio(23, 10);
		AdicionarMonstroAleatorio(22, 14);

		AdicionarMonstroAleatorio(17, 26);
		AdicionarMonstroAleatorio(19, 30);
		AdicionarMonstroAleatorio(22, 22);
		AdicionarMonstroAleatorio(22, 31);

	}

	private void AdicionarMonstroAleatorio(int x, int y) {
		int resultado = new Random().nextInt(3) + 1;
		Inimigo monstro = null;
		switch (resultado) {
		case 1:
			monstro = new Goblin(x, y);
			break;
		case 2:
			monstro = new EsqueletoMago(x, y);
			break;
		case 3:
			monstro = new Esqueleto(x, y);
			break;
		}
		mapa.addObjeto(monstro);
		inimigos.add(monstro);
	}


	private void EscolherPersonagem() throws DigitoInvalidoException {
		System.out.println("Quantos jogadores jogarao? [1/4]");

		Scanner keyboard = new Scanner(System.in);
		int command = keyboard.nextInt();
		if (command < 1 || command > 4) {
			throw new DigitoInvalidoException();

		}
		boolean b = false;
		boolean a = false;
		boolean f = false;
		boolean e = false;
		boolean existe;
		String heroi = keyboard.nextLine();
		for (int i = 0; i < command; i++) {
			System.out.println("Escolha o personagem para jogador " + (i + 1) + " [A/B/F/E]");
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
	
	private void Instrucoes() {
		System.out.println("------Instrucoes------");
		System.out.println("No seu turno aperte w para andar, a para atacar, m para lançar magia, o para abir porta e t para abrir tesouro e n para pular a vez");
		System.out.println("Mate todos os inimigos espalhados pelo mapa");
	}

}
