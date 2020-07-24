package elementosbasicos.personagens;

public class Goblin extends Inimigo {
	private static final int ATAQUE = 2;
	private static final int DEFESA = 1;
	private static final int HP = 5;
	private static final int IP = 6;
	private static final String ICON = "go";
	
	public Goblin(int x, int y) {
		super(x, y, HP, IP, ATAQUE, DEFESA, ICON);
		
	} 
	
}
