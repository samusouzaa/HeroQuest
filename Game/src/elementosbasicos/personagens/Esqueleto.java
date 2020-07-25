package elementosbasicos.personagens;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import Externos.Dados;
import Externos.Direcao;
import Externos.TipoDado;
import Usaveis.Magia;
import elementosbasicos.Mapa;

public class Esqueleto extends Inimigo {
	private static final int ATAQUE = 1;
	private static final int DEFESA = 1;
	private static final int HP = 5;
	private static final int IP = 7;
	
	public Esqueleto(int x, int y) {
		super(x, y, HP, IP, ATAQUE, DEFESA);
	}
	
	@Override
	public String toString() {
		return "ee";
	}

	@Override
	public void Vez() {
		System.out.println("Ataque do Esqueleto:");
	}

	@Override
	public void Andar(Mapa mapa) {
		int passos = Dados.resultadoDado(TipoDado.COMUM);
		
		ArrayList<Direcao> lugares_andar = new ArrayList<Direcao>();
		
		if (mapa.verificarPosicao(this.getX()-1, this.getY()))
			lugares_andar.add(Direcao.UP);
		
		if (mapa.verificarPosicao(this.getX()+1, this.getY()))
			lugares_andar.add(Direcao.DOWN);
		
		if (mapa.verificarPosicao(this.getX(), this.getY()+1))
			lugares_andar.add(Direcao.RIGHT);
		
		if (mapa.verificarPosicao(this.getX(), this.getY()-1))
			lugares_andar.add(Direcao.LEFT);
		
		if (lugares_andar.size() == 0)
			return;
		
		else {
			int posicao = new Random().nextInt(lugares_andar.size());
			for (int i = 0; i < passos; i++) {
				if (mapa.verificarPosicao(this, lugares_andar.get(posicao))) {
					this.Mover(lugares_andar.get(posicao), mapa);
					mapa.printMap();
				}
				else
					break;
			}
			
		}	
	}
	
public void escolheMagia(Mapa mapa) {
		return;		//nao pode usar magia
	}

}
