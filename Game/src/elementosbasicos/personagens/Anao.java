package elementosbasicos.personagens;

import Usaveis.Arma;
import Usaveis.TipoArma;

public class Anao extends Heroi {
	private static final int ATAQUE = 2;
	private static final int DEFESA = 2;
	private static final int HP = 7;
	private static final int IP = 3;
	private static final String ICON = "AN";
	
	Arma espada_curta = new Arma(TipoArma.ESPADACURTA, "ESPADACURTA");
	
	public Anao(int x, int y) {

		super(x, y,HP, IP, ATAQUE, DEFESA, ICON);
		this.equipar(true, espada_curta);

	}
	
	@Override
	public void Vez() {
		System.out.println("Vez do anao");
		System.out.println("Vida:" + this.getHp());
	}

}
