package Usaveis;

public class Armadura extends Item {
	private int valor_armadura;
	
	public Armadura(String nome_armadura, int valor_armadura) {
		super(nome_armadura);
		this.valor_armadura = valor_armadura;
	}
	
	public int getValor_armadura() {
		return valor_armadura;
	}
	public void setValor_armadura(int valor_armadura) {
		this.valor_armadura = valor_armadura;
	}
}
