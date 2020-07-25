package Usaveis;

public class Moedas extends Item{
	private int valor;
	
	public Moedas(String chave, int valor) {
		super(chave);
		this.valor= valor;
		
	}

	

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}
}
