package personagens;

public class Elfo extends Heroi {
	private static final int ATAQUE = 2;
	private static final int DEFESA = 2;
	private static final int HP = 6;
	private static final int IP = 4;
	
	public Elfo() {
		super(HP, IP, ATAQUE, DEFESA);
		//this.equipar(true, arma);
		//this.adicionarMagia(magia);
	}

}

//Barbaro. Ataque: 3 dados, defesa: 2 dados, pontos de vida: 8, pontos  ́
//de inteligencia: 2. Comec ̧a o jogo com uma espada longa, que for- ˆ
//nece +3 dados para ataque, mas necessita o uso de ambas as maos.  ̃
//• Anao. Ataque: 2 dados, defesa: 2 dados, pontos de vida: 7, pontos  ̃
//de inteligencia: 3. Comec ̧a o jogo com uma espada curta, que fornece ˆ
//+2 dados para ataque.
//• Elfo. Ataque: 2 dados, defesa: 2 dados, pontos de vida: 6, pontos de
//inteligencia: 4. Comec ̧a o jogo com uma espada curta, que fornece ˆ
//+2 dados para ataque. Comec ̧a o jogo com uma magia simple heal.
//
//• Feiticeiro. Ataque: 1 dado, defesa: 2 dados, pontos de vida: 4, pon-
//tos de inteligencia: 6. Comec ̧a o jogo com 3 punhais, cada um forne- ˆ
//
//cendo +1 dado para ataque, mas sao perdidos ap  ̃ os o uso. Comec ̧a o  ́
//jogo com 3 magias magic missile, 1 magia  ́ fireball e 1 magia teleport.