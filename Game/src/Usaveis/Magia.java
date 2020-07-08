package Usaveis;
import elementosbasicos.GameObject;
import elementosbasicos.Mapa;

public abstract class Magia extends Item{
	
	Magia (String nome_magia){
		super(nome_magia);
	}
	
	public abstract void Usar(GameObject gameobject, Mapa mapa);
	
}
