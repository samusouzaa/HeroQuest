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
		Feiticeiro feiticeiro = new Feiticeiro(1,4);
		
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
		
		while(true) {
			mapa.printMap();
			//Vez dos herois
			for(GameObject heroi : herois) {
				heroi.Vez();
				
				System.out.println("Você quer andar [Y/N]");
				command = keyboard.nextLine();
				if(command.compareTo("Y") == 0)
					heroi.Andar(mapa);
				
				System.out.println("Você quer atacar [Y/N]");
				command = keyboard.nextLine();
				if(command.compareTo("Y") == 0)
					heroi.Andar(mapa);
			}
			
		}
		
	}
	
	
}
