package sistema;

import java.util.ArrayList;
import java.util.Scanner;

import elementosbasicos.*;
import elementosbasicos.personagens.*;

public class HeroQuest {
	private Mapa mapa;
	private ArrayList<GameObject> herois;
	private ArrayList<GameObject> inimigos;

	public HeroQuest() {
		Anao anao = new Anao(1, 1);
		Elfo elfo = new Elfo(1, 2);
		Barbaro barbaro = new Barbaro(1, 3);
		Feiticeiro feiticeiro = new Feiticeiro(1, 4);

		herois = new ArrayList<GameObject>();
		inimigos = new ArrayList<GameObject>();

		herois.add(feiticeiro);
		herois.add(elfo);
		herois.add(barbaro);
		herois.add(anao);

		mapa = new Mapa();

		mapa.addObjeto(feiticeiro);
		mapa.addObjeto(barbaro);
		mapa.addObjeto(elfo);
		mapa.addObjeto(anao);
	}

	public void Jogar() {
		Scanner keyboard = new Scanner(System.in);
		String command;
		boolean andar, acao;
		
		while(true) {
			mapa.printMap();
			
			//Vez dos herois
			for(GameObject heroi : herois) {
				heroi.Vez();
				
				andar = false;
				acao = false;
				while (!andar || !acao) {
				
					System.out.println("Selecione sua ação [w/a/m/n]");
					command = keyboard.nextLine();
					if(command.compareTo("w") == 0 && !andar) {
						heroi.Andar(mapa);
						andar = true;
					}
					
					else if (command.compareTo("a") == 0 && !acao) {
						heroi.Atacar(null);
						acao = true;
					}
					
					else if (command.compareTo("m") == 0 && !acao) {
						//Usar magia
						acao = true;
					}
					
					else if (command.compareTo("n") == 0) {
						break;
					}
					
					else
						System.out.println("Voce ja usou esta acao");
				}
				
			}
			
		}
		
	}

}
