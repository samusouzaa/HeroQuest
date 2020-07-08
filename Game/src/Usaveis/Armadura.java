package Usaveis;

public class Armadura extends Item {
	private int valor_armadura;
	Armadura(String nome_armadura) {
		super(nome_armadura);
	}
	public int getValor_armadura() {
		return valor_armadura;
	}
	public void setValor_armadura(int valor_armadura) {
		this.valor_armadura = valor_armadura;
	}
}
