package Usaveis;
import Externos.Dados;
import Externos.TipoDado;
import elementosbasicos.GameObject;
import elementosbasicos.Mapa;

public class SimpleHeal extends Magia {
	
	private static final String nome = "SimpleHeal";
	
	public SimpleHeal() {
		super(nome);
	}
	
	@Override
	public void Usar(GameObject gameobject, Mapa mapa) {
		int dado = Dados.resultadoDado(TipoDado.COMUM);
		gameobject.receberCura(dado);
		
	}
}
