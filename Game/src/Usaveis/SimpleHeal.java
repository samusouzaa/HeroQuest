package Usaveis;
import Externos.Dados;
import Externos.TipoDado;
import elementosbasicos.GameObject;
import elementosbasicos.Mapa;

public class SimpleHeal extends Magia {
	
	private static final String nome = "SIMPLEHEAL";
	
	public SimpleHeal() {
		super(nome);
	}

	public void Usar(GameObject gameobject, Mapa mapa) {
		int dado = Dados.resultadoDado(TipoDado.COMUM);
		gameobject.receberCura(dado);
		System.out.println("Simple Heal utilizado");
		
	}
}
