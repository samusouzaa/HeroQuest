package Usaveis;

import elementosbasicos.GameObject;
import elementosbasicos.Mapa;
import excecoes.DigitoInvalidoException;

public abstract class Magia extends Item{
	
	Magia(String chave) {
		super(chave);
	}

	public abstract void Usar(GameObject GameObject, Mapa mapa) throws DigitoInvalidoException;
	
}