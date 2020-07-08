package Usaveis;

public enum TipoArma {
	PUNHAL(1, 2, true), ESPADACURTA(2, 3, false), ESPADALONGA(3, 5, false), LANCA(4, 1, false);

	public final int alcance;
	public final int danosataque;
	public final boolean destrutivel;

	TipoArma(int alcance, int danosataque, boolean destrutivel) {
		/*
		 * Cada tipo de arma é criado, com seus valores arbitrários
		 */

		this.alcance = alcance;
		this.danosataque = danosataque;
		this.destrutivel = destrutivel;

	}

}
