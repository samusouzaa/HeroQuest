package Usaveis;
import Externos.Dados;
import Externos.TipoDado;
import elementosbasicos.GameObject;

public class SimpleHeal extends Magia {
	
	private static final String nome = "SimpleHeal";
	
	public SimpleHeal() {
		super(nome);
	}

	public void Usar(GameObject gameobject) {
		int dado = Dados.resultadoDado(TipoDado.COMUM);
		gameobject.receberCura(dado);
		
	}
}
