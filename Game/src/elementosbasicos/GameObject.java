package elementosbasicos;

import java.util.ArrayList;
import java.util.Scanner;

import Usaveis.*;
import elementosbasicos.personagens.Inimigo;
import excecoes.ArmaInvalidaException;
import excecoes.DigitoInvalidoException;
import excecoes.GameException;
import Externos.*;

public abstract class GameObject extends Objeto implements Personagem {
	private final int hpcheio;
	private int hp;
	private int ip;
	private int dadosAtq;
	private int dadosDfs;
	private Armadura armadura;
	
	//Posição no mapa que será configurado posteriormente
	//private Posic pos;
	
	private Arma armaD;
	private Arma armaE;

	// Lista de itens
	private ArrayList<Item> itens;
	// Lista de magias
	private ArrayList<Magia> magias;
	
	public GameObject(int x, int y, int hp, int ip, int atq, int dfs) {
		super(x, y);
		this.hpcheio = hp;
		this.hp = hp;
		this.ip = ip;
		this.dadosAtq = atq;
		this.dadosDfs = dfs;
		this.itens = new ArrayList<Item>();
		this.magias = new ArrayList<Magia>();
		//this.armadura.setValor_armadura(0);
	}
	///////RETIRAR
	public int getHp() {
		return this.hp;
	}
	
	protected void Mover(Direcao direcao, Mapa mapa) {
		int x = this.getX();
		int y = this.getY();
		switch(direcao) {
			case UP:
				x -= 1;
				break;
			case DOWN:
				x += 1;
				break;
			case LEFT:
				y -= 1;
				break;
			case RIGHT:
				y += 1;
				break;
		}
		if(mapa.verificarPosicao(x,y)) {
			mapa.removeObjeto(this);
			this.atualizaCoordinate(x, y);
			mapa.addObjeto(this);
		}
	}

	public void equipar(boolean mao, Arma arma) {// true esquerda false direita
		if (mao) {
			armaE = arma;
		} else {
			armaD = arma;
		}
	}

	protected void destruirArma(Arma arma) { // destrói armas destrutíveis transformando em null
		if (arma.getDestrutivel()) {
			if (arma.equals(armaD)) {
				armaD = null;
			} else if (arma.equals(armaE)) {
				armaE = null;
			}
		}

	}

	protected boolean Armado() {
		if (armaD != null || armaE != null) {
			return true;
		}
		return false;
	}


	protected Arma escolhaArmas() throws ArmaInvalidaException {
		
		if (armaE != null) {
			System.out.println("1 - " + armaE);
		} else {
			System.out.print("1 - " + " ---- ");
		}
		if (armaD != null) {
			System.out.println("2 - " + armaD);
		} else {
			System.out.println("2 -" + " ---- ");
		}

		Scanner in = new Scanner(System.in);
		String s = in.nextLine();
		switch (s) {
		case ("1"):
			if (armaE == null) {
				throw new ArmaInvalidaException();
			} else {
				destruirArma(armaE);
				return armaE;
			}
		case ("2"):
			if (armaD == null) {
				throw new ArmaInvalidaException();
			} else {
				destruirArma(armaD);
				return armaD;
			}

		}

		return null;
	}

	protected boolean isAlive() {
		if (hp <= 0)
			return false;
		return true;

	}

	public int getDefesa() {
		return dadosDfs;
	}

	// Se escolhe qual direção cardinal se atacará

	protected void Atacar(GameObject inimigo, Arma arma) throws ArmaInvalidaException {

		int numeroDados = dadosAtq;
		
		if (arma != null)
			numeroDados += arma.getDano();

		int dadoAliado = 0;
		int aux;

		for (int i = 0; i < numeroDados; i++) {
			aux = Dados.resultadoDado(TipoDado.LUTA);
			if (0 < aux && aux < 4)
				dadoAliado += 1;
		}

		int dadoInimigo = inimigo.Defender(); // Função será criada posteriormente e devolve o número de escudos

		int resultado = dadoAliado - dadoInimigo;

		if (resultado > 0)
			inimigo.receberDano(resultado);
	}

	protected abstract int Defender();

	public abstract void Andar(Mapa mapa) throws DigitoInvalidoException;

	public void receberDano(int dano) {
		hp -= dano;
	}

	public void receberCura(int cura) {
		if (hp + cura > hpcheio)
			hp = hpcheio;
		else
			hp += cura;

	}
	
	public void adicionaMagia(Magia magia) {
		magias.add(magia);
	}
	
	public void escolheMagia(Mapa mapa) {
		for (Magia magia : magias)
			System.out.println(magias.indexOf(magia)+1 +"."+ " "+magia.toString());
		Scanner keyboard = new Scanner(System.in);
		int magia_escolhida = keyboard.nextInt();
		lancaMagia(magia_escolhida, mapa);
	}
	
	protected void lancaMagia(int posic, Mapa mapa) { // Minha ideia é que quando um jogador quiser lançar uma magia apareceria
											// todas com números e ele escolheria a que ele quer lançar

		int dado = Dados.resultadoDado(TipoDado.COMUM);
		if (ip < dado) {
			System.out.println("Magia fracassou");
			return;
		}

		Magia magia = magias.get(posic - 1);

		magia.Usar(this, mapa);
	}

	
	public void mudarPosicao(int x, int y) {
		this.atualizaCoordinate(x, y);
	}

}
