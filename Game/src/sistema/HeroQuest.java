package sistema;

import java.util.ArrayList;
import java.util.Scanner;

import Usaveis.Arma;
import Usaveis.Fireball;
import Usaveis.MagicMissile;
import Usaveis.Teleport;
import Usaveis.TipoArma;
import elementosbasicos.*;
import elementosbasicos.personagens.*;

public class HeroQuest {
	private Mapa mapa;
	private ArrayList<GameObject> herois;
	private ArrayList<GameObject> inimigos;
	
	public HeroQuest() {
		Anao anao = new Anao(13, 1);
		Arma arma = new Arma(TipoArma.ESPADALONGA, "A");
		anao.equipar(true, arma);
		Fireball magiam = new Fireball();
		anao.adicionaMagia(magiam);
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
		while(true) {
			//Herois andam 
			for(GameObject heroi : herois) {
				heroi.Andar(mapa);
				heroi.lancaMagia(1, mapa);
				}
			System.out.println("Vida goblin: " +inimigos.get(0).getHp());
			System.out.println("Vida esqueleto: " +inimigos.get(1).getHp());
			System.out.println("Vida esqueleto mago: " +inimigos.get(2).getHp());
			
		}
	}
	
	
}
