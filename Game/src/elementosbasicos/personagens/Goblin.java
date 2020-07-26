package elementosbasicos.personagens;

import java.util.Random;
import java.util.Scanner;

import Externos.Dados;
import Externos.Direcao;
import Externos.TipoDado;
import Usaveis.Arma;
import Usaveis.Magia;
import Usaveis.TipoArma;
import elementosbasicos.Mapa;
import elementosbasicos.Objeto;
import elementosbasicos.Parede;

public class Goblin extends Inimigo {
	private static final int ATAQUE = 2;
	private static final int DEFESA = 1;
	private static final int HP = 5;
	private static final int IP = 6;
	private static final String ICON = "go";

	public Goblin(int x, int y) {
		super(x, y, HP, IP, ATAQUE, DEFESA, ICON);
		Arma punhal = new Arma(TipoArma.PUNHAL, "PUNHAL");
		this.adicionaItem(punhal);
		this.adicionaItem(punhal);
		this.adicionaItem(punhal);

	}

	@Override
	public void Vez() {
		System.out.println("Ataque do Goblin:");
	}

	@Override
	public void Andar(Mapa mapa) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int passos = Dados.resultadoDado(TipoDado.COMUM);
		int x = this.getX();
		int y = this.getY();
		Direcao direcao_andar;

		if (getPrimeiroHeroi(x, y, Direcao.DOWN, mapa) != null)
			direcao_andar = Direcao.DOWN;

		else if (getPrimeiroHeroi(x, y, Direcao.LEFT, mapa) != null)
			direcao_andar = Direcao.LEFT;

		else if (getPrimeiroHeroi(x, y, Direcao.RIGHT, mapa) != null)
			direcao_andar = Direcao.RIGHT;

		else if (getPrimeiroHeroi(x, y, Direcao.UP, mapa) != null)
			direcao_andar = Direcao.UP;

		else {
			int lancar = new Random().nextInt(4);

			if (lancar == 0)
				direcao_andar = Direcao.DOWN;

			else if (lancar == 1)
				direcao_andar = Direcao.UP;

			else if (lancar == 2)
				direcao_andar = Direcao.RIGHT;

			else
				direcao_andar = Direcao.LEFT;
		}

		for (int i = 0; i < passos; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (mapa.verificarPosicao(this, direcao_andar)) {
				this.Mover(direcao_andar, mapa);
				mapa.printMap();
			} else
				break;
		}

	}

	private Objeto getPrimeiroHeroi(int x, int y, Direcao direcao, Mapa mapa) {
		// Essa função vai percorrer o mapa numa direção e devolver um inimigo assim que
		// o vir
		Objeto heroi = null;
		int nx = x;
		int ny = y;

		while (heroi == null) {

			if (direcao == Direcao.DOWN)
				nx += 1;

			else if (direcao == Direcao.RIGHT)
				ny += 1;

			else if (direcao == Direcao.LEFT)
				ny -= 1;

			else
				nx -= 1;

			if (nx > mapa.getAltura() || ny > mapa.getLargura())
				break;

			heroi = mapa.getObjetoMapa(nx, ny);

			if (heroi instanceof Parede)
				return null;
		}
		return heroi;
	}

	public void escolheMagia(Mapa mapa) {
		return; // nao pode usar magia
	}
}
