package Usaveis;
import java.util.ArrayList;

import Externos.Coordenada;
import elementosbasicos.GameObject;
import elementosbasicos.Mapa;

public class Fireball extends Magia {
	
	private static final String nome = "Fireball";

	Fireball() {
		super(nome);
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	public void Usar(GameObject gameobject, Mapa mapa) {
		// TODO Auto-generated method stub
		ArrayList<GameObject> inimigosProximos = getInimigos(gameobject.getCoordinate());
		
		for (GameObject inimigo : inimigosProximos) {
			inimigo.receberDano(6);
		}
		
	}
	
	private ArrayList<GameObject> getInimigos(Coordenada coordenadas){
		
	}
	
	

}
