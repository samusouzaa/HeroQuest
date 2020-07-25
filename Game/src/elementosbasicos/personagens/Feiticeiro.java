package elementosbasicos.personagens;
import Usaveis.*;

public class Feiticeiro extends Heroi {
	private static final int ATAQUE = 1;
	private static final int DEFESA = 2;
	private static final int HP = 4;
	private static final int IP = 6;
	
	Fireball fireball = new Fireball();
	MagicMissile magic_missile = new MagicMissile();
	Teleport teleport = new Teleport();
	
	public Feiticeiro(int x, int y) {
		super(x, y, HP, IP, ATAQUE, DEFESA);
		this.adicionaMagia(fireball);
		this.adicionaMagia(magic_missile);
		this.adicionaMagia(teleport);
		
	}
	
	@Override
	public String toString() {
		return "FE";
	}
	
	@Override
	public void Vez() {
		System.out.println("Vez do feiticeiro");
		System.out.println("Vida:" + this.getHp());
	}


}
