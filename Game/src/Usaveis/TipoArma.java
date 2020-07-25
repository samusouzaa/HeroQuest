package Usaveis;

public enum TipoArma {
	PUNHAL(7, 1, false, "arco"), ESPADACURTA(2, 3, false, "espada curta"), 
	ESPADALONGA(3, 5, false, "espada longa"), LANCA(4, 1, false, "lanca");

	public final int alcance;
	public final int danosataque;
	public final boolean destrutivel;
	public final String nome;

	TipoArma(int alcance, int danosataque, boolean destrutivel, String nome) {
		/*
		 * Cada tipo de arma é criado, com seus valores arbitrários
		 */

		this.alcance = alcance;
		this.danosataque = danosataque;
		this.destrutivel = destrutivel;
		this.nome = nome;

	}

}
