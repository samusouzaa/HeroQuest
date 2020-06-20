package elementosbasicos.personagens;

import java.util.Random;

public class EsqueletoMago extends Inimigo{

	private int posicao_atual;
	
	private static final int ATAQUE = 1;
	private static final int DEFESA = 2;
	private static final int HP = 4;
	private static final int IP = 6;
	
	public EsqueletoMago(int x, int y) {
		super(x, y, HP, IP, ATAQUE, DEFESA);
	}
	
	public void mudarPosicao() {
		int proxima_posicao = new Random().nextInt(8) + 1;
		this.posicao_atual = proxima_posicao; 
		/*terminar implementacao*/
	}
	
}