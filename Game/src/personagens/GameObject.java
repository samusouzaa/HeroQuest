package personagens;
import java.util.ArrayList;

public abstract class GameObject {
	private int hp;
	private int ip;
	private int dadosAtq;
	
	//Posição no mapa que será configurado posteriormente
	//private Posic pos;
	
	//Lista de itens
	private ArrayList<Item> itens;
	
	public GameObject(int a, int b, int c) {
		hp = a;
		ip = b;
		dadosAtq = c;
		this.itens = new ArrayList<Item>;
	}
	
	protected Atacar() {
		
	}

	
}
