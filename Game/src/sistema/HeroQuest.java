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
		Anao anao = new Anao(13, 1);
		
		//teste de ataque
		/*Elfo elfo = new Elfo(1, 2);
		Barbaro barbaro = new Barbaro(1, 3);
		Feiticeiro feiticeiro = new Feiticeiro(1,4);*/
		
		Goblin goblin = new Goblin(12,4);
		Esqueleto esqueleto = new Esqueleto(13,5);
		EsqueletoMago esqueleto_mago = new EsqueletoMago(14,4);
		
		herois = new ArrayList<GameObject>();
		inimigos = new ArrayList<GameObject>();
		
		//teste de ataque
		/*herois.add(feiticeiro);
		herois.add(elfo);
		herois.add(barbaro);*/
		herois.add(anao);
		inimigos.add(goblin);
		inimigos.add(esqueleto);
		inimigos.add(esqueleto_mago);
		
		
		mapa = new Mapa();
		
		//teste de ataque
		/*
		mapa.addObjeto(feiticeiro);
		mapa.addObjeto(barbaro);
		mapa.addObjeto(elfo);*/
		
		mapa.addObjeto(anao);
		mapa.addObjeto(goblin);
		mapa.addObjeto(esqueleto);
		mapa.addObjeto(esqueleto_mago);
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
					heroi.Atacar(null);
			}
			
		}
		
	}
	
	
}
