package Usaveis;

public enum TipoArma {
	PUNHAL(1, 2, true), MARTELO(2, 3, true), MACHADO(3, 5, false), LANCA(4, 1, false);

	private final int alcance;
	private final int bonus;
	private final boolean destrutivel;

	TipoArma(int alcance, int bonus, boolean destrutivel) {
		/*
		 * Cada tipo de arma é criado, com seus valores arbitrários
		 */

		this.alcance = alcance;
		this.bonus = bonus;
		this.destrutivel = destrutivel;

	}

	public boolean getEhdestruida() {
		return destrutivel;
	}

	public int getBonus() {
		return bonus;
	}

	public int getAlcance() {
		return alcance;
	}

}
