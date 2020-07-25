package elementosbasicos.personagens;

import Usaveis.Arma;
import Usaveis.SimpleHeal;
import Usaveis.TipoArma;

public class Elfo extends Heroi {
	private static final int ATAQUE = 2;
	private static final int DEFESA = 2;
	private static final int HP = 6;
	private static final int IP = 4;
	private static final String ICON = "EL";
	
	Arma espada_curta = new Arma(TipoArma.ESPADACURTA, "ESPADACURTA");
	SimpleHeal simple_heal = new SimpleHeal();
	
	public Elfo(int x, int y) {

		super(x, y, HP, IP, ATAQUE, DEFESA, ICON);
		this.equipar(true, espada_curta);
		this.adicionaMagia(simple_heal);

	}
	
	@Override
	public void Vez() {
		System.out.println("Vez do elfo");
		System.out.println("Vida:" + this.getHp());
	}
}
