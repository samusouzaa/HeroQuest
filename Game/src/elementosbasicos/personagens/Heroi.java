package elementosbasicos.personagens;

import Externos.Dados;
import Externos.Direcao;
import Externos.TipoDado;
import Usaveis.Arma;
import elementosbasicos.GameObject;
import elementosbasicos.Mapa;
import elementosbasicos.Parede;
import excecoes.ArmaInvalidaException;

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
	
	public GameObject inimigosTurno(Mapa mapa, Arma arma){
		
		int x = this.getX();
		int y = this.getY();
		int posicao_inimigo = 1;
		int alcance = 1;
		boolean existe_inimigo = false;
		
		if (arma != null)
			alcance = arma.getAlcance();
		
		GameObject inimigo_atacado;
		
		for (int i = 1; i <= alcance; i++) {
			//verifica inimigos acima
			if (mapa.getObjetoMapa(x, y+i) instanceof Inimigo) {
				System.out.println("Pressione " + posicao_inimigo + " para atacar o " + mapa.getObjetoMapa(x, y+i).toString());
				inimigos_proximos.add((GameObject) mapa.getObjetoMapa(x, y+i));
				posicao_inimigo++;
				existe_inimigo = true;
				}
			
			else if (mapa.getObjetoMapa(x, y+i) instanceof Parede)
				break;
		}
			
		for (int i = 1; i <= alcance; i++) {
			//verifica inimigos na direita
			if (mapa.getObjetoMapa(x+i, y) instanceof Inimigo) {
				System.out.println("Pressione " + posicao_inimigo + " para atacar o " + mapa.getObjetoMapa(x+i, y).toString());
				inimigos_proximos.add((GameObject) mapa.getObjetoMapa(x+i, y));
				posicao_inimigo++;
				existe_inimigo = true;
			}
			
			else if (mapa.getObjetoMapa(x+i, y) instanceof Parede)
				break;
		}
		
		for (int i = 1; i <= alcance; i++) {
			//verifica inimigos embaixo
			if (mapa.getObjetoMapa(x, y-i) instanceof Inimigo) {
				System.out.println("Pressione " + posicao_inimigo + " para atacar o " + mapa.getObjetoMapa(x, y-i).toString());
				inimigos_proximos.add((GameObject) mapa.getObjetoMapa(x, y-i));
				posicao_inimigo++;
				existe_inimigo = true;
			}
			
			else if (mapa.getObjetoMapa(x, y-i) instanceof Parede)
				break;
		}
		
		for (int i = 1; i <= alcance; i++) {
			//verifica inimigos na esquerda
			if (mapa.getObjetoMapa(x-i, y) instanceof Inimigo) {
				System.out.println("Pressione " + posicao_inimigo + " para atacar o " + mapa.getObjetoMapa(x-i, y).toString());
				inimigos_proximos.add((GameObject) mapa.getObjetoMapa(x-i, y));
				posicao_inimigo++;
				existe_inimigo = true;
			}
			else if (mapa.getObjetoMapa(x-i, y) instanceof Parede)
				break;
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
	
	public boolean realizaAtaque(Mapa mapa){
		
		Arma arma_ataque = null;
		
		if (Armado()) {
			System.out.println("Usar armas disponÃ­veis?"); // excecao pra caso a arma for null
			System.out.println("y = sim");
			System.out.println("n = nÃ£o");
			Scanner in = new Scanner(System.in);
			String s = in.nextLine();
			if (s.compareTo("y") == 0) {
				try {
					arma_ataque = escolhaArmas();
				} catch (ArmaInvalidaException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				System.out.println("NÃ£o hÃ¡ armas disponÃ­veis");

			}
		}
		GameObject inimigo = inimigosTurno(mapa, arma_ataque);
		if (inimigo != null) {
			try {
				this.Atacar(inimigo, arma_ataque);
			} catch (ArmaInvalidaException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return true;
			}
		else
			return false;
	}
	
	
}
