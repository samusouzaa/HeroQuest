package elementosbasicos.personagens;

public class Elfo extends Heroi {
	private static final int ATAQUE = 2;
	private static final int DEFESA = 2;
	private static final int HP = 6;
	private static final int IP = 4;
	private static final String ICON = "EL";
	
	public Elfo(int x, int y) {
		super(x, y, HP, IP, ATAQUE, DEFESA, ICON);
		//this.equipar(true, arma);
		//this.adicionarMagia(magia);
	}
	
	@Override
	public void Vez() {
		System.out.println("Vez do elfo");
		System.out.println("Vida:" + HP);
	}
}
