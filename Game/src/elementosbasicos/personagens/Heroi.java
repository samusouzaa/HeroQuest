package elementosbasicos.personagens;

import Externos.Dados;
import Externos.Direcao;
import Externos.TipoDado;
import elementosbasicos.GameObject;
import elementosbasicos.Mapa;

import java.util.ArrayList;
import java.util.Scanner;

public class Heroi extends GameObject {
	
	public Heroi(int x, int y, int hp, int ip, int atq, int dfs) {
		super(x, y,hp, ip, atq, dfs);
	}
	
	private ArrayList<GameObject> inimigos_proximos = new ArrayList<GameObject>();
	
	public void Andar(Mapa mapa) {
		//Jogar dados
		//se um ataque for realizado,ele não andará mais
		boolean atacou = false;
		int passos = Dados.resultadoDado(TipoDado.COMUM);
		Scanner keyboard = new Scanner(System.in);
		Direcao direcao;

		
		for (int i = 0; i < passos; i++) {
			System.out.println("Digite a prÃ³xima direÃ§Ã£o");
			String command = keyboard.nextLine();
			
			if(command.compareTo("w") == 0)
				direcao = Direcao.UP;
			else if(command.compareTo("a") == 0)
				direcao = Direcao.LEFT;
			else if(command.compareTo("d") == 0)
				direcao = Direcao.RIGHT;
			else
				direcao = Direcao.DOWN;
			
			this.Mover(direcao, mapa);
			
			mapa.printMap();
			
			atacou = realizaAtaque(mapa);
			
			if (atacou == true) {
				mapa.printMap();
				break;
				}
		}
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
		
		//Se existir algum inimigo proximo, perguntamos se o ataque ocorrerá
		if (existe_inimigo == true) {
			//Se não quiser realizar ataque
			System.out.println("Pressione qualquer outra tecla se não quiser realizar o ataque");
		
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
