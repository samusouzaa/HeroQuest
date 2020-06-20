package elementosbasicos;
import elementosbasicos.personagens.*;
import java.util.ArrayList;

public class Mapa {
	private ArrayList<Heroi> aliados;
	private ArrayList<Inimigo> inimigos;
	private ArrayList<Objeto> tralhas;
	
	private int largura;
	private int altura;

	protected Mapa(int largura, int altura, ArrayList<Heroi> aliados, ArrayList<Inimigo> inimigos, ArrayList<Objeto> tralhas ) {
		this.largura = largura;
		this.altura = altura;
		this.aliados = aliados;
		this.inimigos = inimigos;
		this.tralhas = tralhas;
	}
	
	public int getLargura() {
		return largura;
	}
	
	public int getAltura() {
		return altura;
	}
	
	public boolean isWon() {
		for (GameObject inimigo : inimigos) {
			if(!inimigo.isAlive())
				return false;
		}
		return true;
	}
	
	public boolean isLost() {
		for (GameObject aliado : aliados) {
			if(!aliado.isAlive())
				return false;
		}
		return true;
	}
	
}
