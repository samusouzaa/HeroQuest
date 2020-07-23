package elementosbasicos.personagens;

import elementosbasicos.Mapa;

public class Esqueleto extends Inimigo {
	private static final int ATAQUE = 1;
	private static final int DEFESA = 1;
	private static final int HP = 5;
	private static final int IP = 7;
	
	public Esqueleto(int x, int y) {
		super(x, y, HP, IP, ATAQUE, DEFESA);
	}
	
	@Override
	public String toString() {
		return "ee";
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
