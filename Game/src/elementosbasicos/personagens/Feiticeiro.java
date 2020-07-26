package elementosbasicos.personagens;
import Usaveis.*;

public class Feiticeiro extends Heroi {
	private static final int ATAQUE = 1;
	private static final int DEFESA = 2;
	private static final int HP = 4;
	private static final int IP = 6;
	private static final String ICON = "FE";
	
	
	public Feiticeiro(int x, int y) {
		super(x, y, HP, IP, ATAQUE, DEFESA, ICON);
		Fireball fireball = new Fireball();
		MagicMissile magic_missile = new MagicMissile();
		Teleport teleport = new Teleport();
		Arma punhal = new Arma(TipoArma.PUNHAL, "PUNHAL");
		this.adicionaMagia(fireball);
		this.adicionaMagia(magic_missile);
		this.adicionaMagia(teleport);
		this.adicionaItem(punhal);
		this.adicionaItem(punhal);
		this.adicionaItem(punhal);
	}
	
	@Override
	public void Vez() {
		System.out.println("Vez do feiticeiro");
		System.out.println("Vida:" + this.getHp());
		System.out.println("Economia:" + this.getMoedas() + " moedas");
	}


}
