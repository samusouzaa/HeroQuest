package elementosbasicos.personagens;

public class Anao extends Heroi {
	private static final int ATAQUE = 2;
	private static final int DEFESA = 2;
	private static final int HP = 7;
	private static final int IP = 3;
	
	public Anao(int x, int y) {
		super(x, y,HP, IP, ATAQUE, DEFESA);
		//this.equipar(true, arma);
	}
	
	@Override
	public String toString() {
		return "AN";
	}
	
	@Override
	public void Vez() {
		System.out.println("Vez do anao");
		System.out.println("Vida:" + this.getHp());
	}

}
