package sistema;


import Usaveis.*;

public class InicializaUtilizaveis {
	private ListaItens magias = new ListaItens();
	private ListaItens armas = new ListaItens();
	private ListaItens itens = new ListaItens();
	
	public ListaItens inicializaMagias() {

		MagicMissile magic_missile = new MagicMissile();
		Fireball fireball = new Fireball();
		Teleport teleport = new Teleport();
		SimpleHeal simple_heal = new SimpleHeal();
		
		magias.adicionaItem(magic_missile, magic_missile.getChave());
		magias.adicionaItem(fireball, fireball.getChave());
		magias.adicionaItem(teleport, teleport.getChave());
		magias.adicionaItem(simple_heal, simple_heal.getChave());
		
		
		return magias;
	}
	
	public ListaItens inicializaArmas() {
		
		Arma espada_curta = new Arma(TipoArma.ESPADACURTA, "ESPADACURTA");
		Arma espada_longa = new Arma(TipoArma.ESPADALONGA, "ESPADALONGA");
		Arma lanca = new Arma(TipoArma.LANCA, "LANCA");
		Arma punhal = new Arma(TipoArma.PUNHAL, "PUNHAL");
		
		armas.adicionaItem(espada_curta, espada_curta.getChave());
		armas.adicionaItem(espada_longa, espada_longa.getChave());
		armas.adicionaItem(lanca, lanca.getChave());
		armas.adicionaItem(punhal, punhal.getChave());
		
		return armas;
	}
	
	public ListaItens inicializaItens() {
		
		Armadura armadura_level1 = new Armadura("ARMADURALEVEL1", 1);
		Armadura armadura_level2 = new Armadura("ARMADURALEVEL2", 2);
		Moedas moeda_5 = new Moedas("MOEDA5", 5);
		Moedas moeda_10 = new Moedas("MOEDA10", 10);
		Moedas moeda_25 = new Moedas("MOEDA25", 25);
		
		itens.adicionaItem(armadura_level1, armadura_level1.getChave());
		itens.adicionaItem(armadura_level2, armadura_level2.getChave());
		itens.adicionaItem(moeda_5, moeda_5.getChave());
		itens.adicionaItem(moeda_10, moeda_10.getChave());
		itens.adicionaItem(moeda_25, moeda_25.getChave());
		
		return itens;
	}
}
