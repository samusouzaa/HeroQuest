package elementosbasicos.personagens;

public class Feiticeiro extends Heroi {
	private static final int ATAQUE = 1;
	private static final int DEFESA = 2;
	private static final int HP = 4;
	private static final int IP = 6;
	
	public Feiticeiro(int x, int y) {
		super(x, y, HP, IP, ATAQUE, DEFESA);
	}
	
	@Override
	public String toString() {
		return "FE";
	}
	
	@Override
	public void Vez() {
		System.out.println("Vez do feiticeiro");
		System.out.println("Vida:" + HP);
	}


}
