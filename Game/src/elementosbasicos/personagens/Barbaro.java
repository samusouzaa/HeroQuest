package elementosbasicos.personagens;

import Usaveis.Arma;
import Usaveis.TipoArma;

public class Barbaro extends Heroi {
	private static final int ATAQUE = 3;
	private static final int DEFESA = 2;
	private static final int HP = 8;
	private static final int IP = 2;
	private static final String ICON = "BA";

	public Barbaro(int x, int y) {

		super(x, y, HP, IP, ATAQUE, DEFESA, ICON);
		Arma espada_longa = new Arma(TipoArma.ESPADALONGA, "ESPADALONGA");
		this.equipar(true, espada_longa);
		this.equipar(false, espada_longa);
	}

	@Override
	public void Vez() {
		System.out.println("Vez do barbaro");
		System.out.println("Vida:" + this.getHp());
	}

}
