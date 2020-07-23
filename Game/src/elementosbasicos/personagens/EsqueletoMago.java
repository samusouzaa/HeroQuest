package elementosbasicos.personagens;

import java.util.Random;

import elementosbasicos.Mapa;

public class EsqueletoMago extends Inimigo{
	
	private static final int ATAQUE = 1;
	private static final int DEFESA = 2;
	private static final int HP = 4;
	private static final int IP = 6;
	
	public EsqueletoMago(int x, int y) {
		super(x, y, HP, IP, ATAQUE, DEFESA);
	}
	
	public void mudarPosicao() {
		int proxima_posicao = new Random().nextInt(8) + 1;
		
		if (proxima_posicao == 1) {
			int x = getX() - 1;
			int y = getY() + 1;
			atualizaCoordinate(x,y);
		}
		
		else if (proxima_posicao == 2) {
			int x = getX();
			int y = getY() + 1;
			atualizaCoordinate(x,y);
		}
		
		else if (proxima_posicao == 3) {
			int x = getX() + 1;
			int y = getY() + 1;
			atualizaCoordinate(x,y);
		}
		
		else if (proxima_posicao == 4) {
			int x = getX() - 1;
			int y = getY();
			atualizaCoordinate(x,y);
		}
		
		else if (proxima_posicao == 5) {
			int x = getX() + 1;
			int y = getY();
			atualizaCoordinate(x,y);
		}
		
		else if (proxima_posicao == 6) {
			int x = getX() - 1;
			int y = getY() - 1;	
			atualizaCoordinate(x,y);
		}
		
		else if (proxima_posicao == 7) {
			int x = getX();
			int y = getY() - 1;
			atualizaCoordinate(x,y);
		}
		
		else if (proxima_posicao == 8) {
			int x = getX() + 1;
			int y = getY() - 1;
			atualizaCoordinate(x,y);
		}
	}
	
	@Override
	public String toString() {
		return "em";
	}

	@Override
	public void Vez() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Andar(Mapa mapa) {
		// TODO Auto-generated method stub
		
	}
	
}