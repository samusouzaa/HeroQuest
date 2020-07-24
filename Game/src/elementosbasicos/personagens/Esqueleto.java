package elementosbasicos.personagens;

public class Esqueleto extends Inimigo {
	private static final int ATAQUE = 1;
	private static final int DEFESA = 1;
	private static final int HP = 5;
	private static final int IP = 7;
	private static final String ICON = "ee";
	
	public Esqueleto(int x, int y) {
		super(x, y, HP, IP, ATAQUE, DEFESA, ICON);
	}

}
