package sistema;

//TESTE MAGIAS
import Usaveis.*;

import java.util.ArrayList;
import java.util.Scanner;

import elementosbasicos.*;
import elementosbasicos.personagens.*;
import excecoes.DigitoInvalidoException;

public class HeroQuest {
	private Mapa mapa;
	private ArrayList<GameObject> herois;
	private ArrayList<GameObject> inimigos;

	public HeroQuest() {
		Anao anao = new Anao(14, 1);
		Elfo elfo = new Elfo(1, 2);
		Barbaro barbaro = new Barbaro(1, 3);

		Feiticeiro feiticeiro = new Feiticeiro(13, 4);
		Fireball magia1 = new Fireball();
		MagicMissile magia2 = new MagicMissile();
		Teleport magia3 = new Teleport();
	
		feiticeiro.adicionaMagia(magia1);
		feiticeiro.adicionaMagia(magia2);
		feiticeiro.adicionaMagia(magia3);
		
		//TESTE
		EsqueletoMago goblin = new EsqueletoMago(14, 9);
		goblin.adicionaMagia(magia2);

		herois = new ArrayList<GameObject>();
		inimigos = new ArrayList<GameObject>();

		// TESTE
		inimigos.add(goblin);

		// TESTE ATAQUE
		Arma arma1 = new Arma(TipoArma.ESPADACURTA, "A");
		Arma arma2 = new Arma(TipoArma.ESPADALONGA, "B");
		feiticeiro.equipar(true, arma1);
		feiticeiro.equipar(false, arma2);

		herois.add(feiticeiro);
		herois.add(elfo);
		herois.add(barbaro);
		herois.add(anao);

		mapa = new Mapa();

		mapa.addObjeto(feiticeiro);
		mapa.addObjeto(barbaro);
		mapa.addObjeto(elfo);
		mapa.addObjeto(anao);
		mapa.addObjeto(goblin);
	}

	public boolean Ganhou() {
		for (GameObject inimigo : inimigos) {
			if (!inimigo.isAlive())
				return false;
		}
		return true;
	}

	public boolean Perdeu() {
		for (GameObject aliado : herois) {
			if (!aliado.isAlive())
				return false;
		}
		return true;
	}

	public void Jogar() {
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

					System.out.println("Selecione sua acao [w/a/m/n]"); // TODO ajeitar o else
					command = keyboard.nextLine().toLowerCase();
					if (command.compareTo("w") == 0 && !andar) {
						boolean valido = true;
						do {
							try {
								heroi.Andar(mapa);

							} catch (DigitoInvalidoException exception) {
								valido = false;
								System.out.println(exception.getMessage());
							}
						} while (!valido);

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

					else if (command.compareTo("n") == 0) {
						break;
					}

					else
						System.out.println("Voce ja usou esta acao"); // na entendeu

					mapa.Ver(heroi.getX(), heroi.getY());
					mapa.printMap();
				}

			}

			for (GameObject inimigo : inimigos) {
				if (inimigo.getVisibilidade())
					try {
						((Inimigo) inimigo).realizaAtaque(mapa);
						inimigo.escolheMagia(mapa);
						inimigo.Andar(mapa);
						
						
					}
					 catch (DigitoInvalidoException exception) {
						System.out.println(exception.getMessage());
					}
					
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

	}
