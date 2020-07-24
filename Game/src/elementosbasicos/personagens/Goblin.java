package elementosbasicos.personagens;

import elementosbasicos.Mapa;

public class Goblin extends Inimigo {
	private static final int ATAQUE = 2;
	private static final int DEFESA = 1;
	private static final int HP = 5;
	private static final int IP = 6;
	private static final String ICON = "go";
	
	public Goblin(int x, int y) {
		super(x, y, HP, IP, ATAQUE, DEFESA, ICON);
		
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
