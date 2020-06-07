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
	
	public GameObject(int hp, int ip, int atq) {
		this.hp = a;
		this.ip = b;
		this.dadosAtq = atq;
		this.itens = new ArrayList<Item>();
	}
	
	protected abstract void Atacar();
	
	protected abstract void Andar();
	
	protected abstract void UsarItem();
	
	

	
}
