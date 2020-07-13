package elementosbasicos.personagens;

public class Elfo extends Heroi {
	private static final int ATAQUE = 2;
	private static final int DEFESA = 2;
	private static final int HP = 6;
	private static final int IP = 4;
	
	public Elfo(int x, int y) {
		super(x, y, HP, IP, ATAQUE, DEFESA);
		//this.equipar(true, arma);
		//this.adicionarMagia(magia);
	}
	
	@Override
	public String toString() {
		return "EL";
	}
}
