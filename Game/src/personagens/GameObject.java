package personagens;
import java.util.ArrayList;
import Usaveis.*;


public abstract class GameObject extends Objeto {
	private final int hpcheio;
	private int hp;
	private int ip;
	private int dadosAtq;
	private int dadosDfs;
	
	//Posição no mapa que será configurado posteriormente
	//private Posic pos;
	
	//arma
	private Arma armaD;
	private Arma armaE;
	//Lista de itens
	private ArrayList<Item> itens;
	//Lista de magias
	private ArrayList<Magia> magias;
	
	public GameObject(int x, int y, int hp, int ip, int atq, int dfs) {
		super(x,y);
		this.hpcheio = hp;
		this.hp = hp;
		this.ip = ip;
		this.dadosAtq = atq;
		this.dadosDfs = dfs;
		this.itens = new ArrayList<Item>();
		this.magias = new ArrayList<Magia>();
	}
	
	protected void equipar(boolean mao, Arma arma) {// true esquerda false direita
		if(mao) {
			armaE = arma;
		}
		else {
			armaD = arma;
		}
	}
	
	//Se escolhe qual direção cardinal se atacará
	
	protected void Atacar(String direcao) {
		GameObject inimigo = InimigoAlcancavel(direcao); //Função será criada posteriormente e devolve o inimigo no alcance, ou devolve null
		
		if(inimigo == null)
			return;
		
		int dadoAliado = CaveiraDado(); //Função será criada posteriormente e devolve o número de caveiras
		
		int dadoInimigo = inimigo.EscudoDado(); //Função será criada posteriormente e devolve o número de escudos
		
		int resultado = dadoAliado - dadoInimigo;
		
		if (resultado > 0)
			inimigo.receberDano(resultado);
	}
	
	protected abstract void Andar();
	
	private void receberDano(int dano) {
		hp -= dano;
	}
	
	public void receberCura(int cura) {
		if(hp + cura > hpcheio)
			hp = hpcheio;
		else
			hp += cura;
				
	}
	
	protected void lancaMagia(int posic) { // Minha ideia é que quando um jogador quiser lançar uma magia apareceria todas com números e ele escolheria a que ele quer lançar
		int dado = ComumDado();
		if(dado < ip) {
			System.out.println("Magia fracassou");
			return;
		}
		
		Magia magia = magias.get(posic-1);
		
		magia.Usar();	
	}
	
	protected void usarItem(int posic) { // Minha ideia é que quando um jogador quiser lançar uma magia apareceria todas com números e ele escolheria a que ele quer lançar
		Item item = itens.get(posic-1);
		
		item.Usar();	
	}
	
	

	
}
