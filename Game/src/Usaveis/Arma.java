package Usaveis;

public class Arma extends Item{
	private int alcance;
	private int bonusDados;
	private boolean ehdestruida;
	
	public Arma(int alcance, int bonus, boolean ehdestruida, String chave) {
		super(chave);
		this.alcance = alcance;
		this.bonusDados = bonus;
		this.ehdestruida = ehdestruida;
	}
}
