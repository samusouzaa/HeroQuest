package elementosbasicos.personagens;

import Externos.Dados;
import Externos.TipoDado;
import elementosbasicos.GameObject;
import elementosbasicos.Mapa;

public class Inimigo extends GameObject {
	public Inimigo(int x, int y, int hp, int ip, int atq, int defesa) {
		super(x, y, hp, ip, atq, defesa);
	}
	
	protected void Andar(Mapa mapa) {
		//Ainda vamos desenvolver
	}
	
	protected int Defender() {
		int numeroDados = this.getDefesa(); // + armadura.getDefesa; 
		int aux;
		int dadoAliado = 0;
		for (int i = 0; i < numeroDados; i++) {
			aux = Dados.resultadoDado(TipoDado.LUTA);
			if(aux== 6)
				dadoAliado += 1;
		}
		return dadoAliado;
	}
}
