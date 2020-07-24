package elementosbasicos.personagens;

public class Feiticeiro extends Heroi {
	private static final int ATAQUE = 1;
	private static final int DEFESA = 2;
	private static final int HP = 4;
	private static final int IP = 6;
	private static final String ICON = "EL";
	
	public Feiticeiro(int x, int y) {
		super(x, y, HP, IP, ATAQUE, DEFESA, ICON);
	}
	
	@Override
	public void Vez() {
		System.out.println("Vez do feiticeiro");
		System.out.println("Vida:" + HP);
	}


}
