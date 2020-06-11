package Usaveis;

import personagens.GameObject;

public class SimpleHeal extends Magia {
	public void Usar(GameObject gameobject) {
		int dado = ComumDado();
		gameobject.receberCura(dado);
		
	}
}
