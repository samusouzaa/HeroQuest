package elementosbasicos.personagens;

import Externos.Coordenada;
import Externos.Dados;
import Externos.Direcao;
import Externos.TipoDado;
import elementosbasicos.GameObject;
import elementosbasicos.Mapa;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class Heroi extends GameObject {
	
	public Heroi(int x, int y, int hp, int ip, int atq, int dfs) {
		super(x, y,hp, ip, atq, dfs);
		this.Visto();
	}
	
	private ArrayList<GameObject> inimigos_proximos = new ArrayList<GameObject>();
	
	public void Andar(Mapa mapa) {
		//Jogar dados
		//se um ataque for realizado,ele n�o andar� mais
		boolean atacou = false;
		int passos = Dados.resultadoDado(TipoDado.COMUM);
		Scanner keyboard = new Scanner(System.in);
		Direcao direcao;
		boolean conferido = false;
		boolean verificado = false;
		int xi = getX();
		int yi = getY();
		mapa.removeObjeto(this);
		
		while(!conferido || !verificado) {
			this.atualizaCoordinate(xi, yi);
			Mapa copia = mapa.getCopia();
			for (int i = 0; i < passos; i++) {
				copia.addObjeto(this);
				
				System.out.println("Digite a próxima direção");
				String command = keyboard.nextLine();
				
				if(command.compareTo("w") == 0)
					direcao = Direcao.UP;
				else if(command.compareTo("a") == 0)
					direcao = Direcao.LEFT;
				else if(command.compareTo("d") == 0)
					direcao = Direcao.RIGHT;
				else
					direcao = Direcao.DOWN;
				
				this.Mover(direcao, copia);
				
				copia.printMap();
			}
			System.out.println("Esta é a posição desejada [Y/N]");
			String command = keyboard.nextLine();
			if(command.compareTo("Y") == 0)
				conferido = true;
			else
				conferido = false;
			
			verificado = mapa.verificarPosicao(getX(), getY());

		}
		
		mapa.addObjeto(this);
		mapa.printMap();
	}
	
	protected int Defender() {
		int numeroDados = this.getDefesa(); // + armadura.getDefesa; 
		int aux;
		int dadoAliado = 0;
		for (int i = 0; i < numeroDados; i++) {
			aux = Dados.resultadoDado(TipoDado.LUTA);
			if(aux > 3 && aux < 6)
				dadoAliado += 1;
		}
		return dadoAliado;
	}

	
	
	public GameObject inimigosTurno(Mapa mapa){
		
		int x = this.getX();
		int y = this.getY();
		int posicao_inimigo = 1;
		boolean existe_inimigo = false;
		
		GameObject inimigo_atacado;
		
		//verifica inimigos acima
		if (mapa.getObjetoMapa(x, y+1) instanceof Inimigo) {
			System.out.println("Pressione " + posicao_inimigo + " para atacar o " + mapa.getObjetoMapa(x, y+1).toString());
			inimigos_proximos.add((GameObject) mapa.getObjetoMapa(x, y+1));
			posicao_inimigo++;
			existe_inimigo = true;
			}
		
		//verifica inimigos na direita
		if (mapa.getObjetoMapa(x+1, y) instanceof Inimigo) {
			System.out.println("Pressione " + posicao_inimigo + " para atacar o " + mapa.getObjetoMapa(x+1, y).toString());
			inimigos_proximos.add((GameObject) mapa.getObjetoMapa(x+1, y));
			posicao_inimigo++;
			existe_inimigo = true;
		}
			
		//verifica inimigos embaixo
		if (mapa.getObjetoMapa(x, y-1) instanceof Inimigo) {
			System.out.println("Pressione " + posicao_inimigo + " para atacar o " + mapa.getObjetoMapa(x, y-1).toString());
			inimigos_proximos.add((GameObject) mapa.getObjetoMapa(x, y-1));
			posicao_inimigo++;
			existe_inimigo = true;
		}
		
		//verifica inimigos na esquerda
		if (mapa.getObjetoMapa(x-1, y) instanceof Inimigo) {
			System.out.println("Pressione " + posicao_inimigo + " para atacar o " + mapa.getObjetoMapa(x-1, y).toString());
			inimigos_proximos.add((GameObject) mapa.getObjetoMapa(x-1, y));
			posicao_inimigo++;
			existe_inimigo = true;
		}
		
		//Se existir algum inimigo proximo, perguntamos se o ataque ocorrer�
		if (existe_inimigo == true) {
			//Se n�o quiser realizar ataque
			System.out.println("Pressione qualquer outra tecla se n�o quiser realizar o ataque");
		
			Scanner keyboard = new Scanner(System.in);
			int inimigo_escolhido = keyboard.nextInt();
		
			if (inimigo_escolhido > 0 && inimigo_escolhido <= posicao_inimigo-1) {
				inimigo_atacado = inimigos_proximos.get(inimigo_escolhido-1);
				return inimigo_atacado;
				}
		
			else
				return null;
		}
		
		else
			return null;
	}
	
	public boolean realizaAtaque(Mapa mapa) {
		GameObject inimigo = inimigosTurno(mapa);
		if (inimigo != null) {
			this.Atacar(inimigo);
			return true;
			}
		else
			return false;
	}
	
	
}
