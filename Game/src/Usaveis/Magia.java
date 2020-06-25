package Usaveis;
import elementosbasicos.GameObject;

public abstract class Magia extends Item{
	
	Magia (String nome_magia){
		super(nome_magia);
	}
	
	public abstract void Usar(GameObject gameobject);
	
}
