package elementosbasicos.personagens;

public class Barbaro extends Heroi {
	private static final int ATAQUE = 3;
	private static final int DEFESA = 2;
	private static final int HP = 8;
	private static final int IP = 2;
	private static final String ICON = "BA";
	
	public Barbaro(int x, int y) {
		super(x, y, HP, IP, ATAQUE, DEFESA, ICON);
		//this.equipar(true, arma);
		//this.equipar(false, arma);
	}
	
	@Override
	public void Vez() {
		System.out.println("Vez do barbaro");
		System.out.println("Vida:" + HP);
	}

}
