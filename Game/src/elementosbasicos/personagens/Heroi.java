package elementosbasicos.personagens;

import Externos.Coordenada;
import Externos.Dados;
import Externos.Direcao;
import Externos.TipoDado;
import elementosbasicos.GameObject;
import elementosbasicos.Mapa;

import java.util.Scanner;

public class Heroi extends GameObject {
	
	public Heroi(int x, int y, int hp, int ip, int atq, int dfs) {
		super(x, y,hp, ip, atq, dfs);
	}
	
	public void Andar(Mapa mapa) {
		//Jogar dados
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
	
}
