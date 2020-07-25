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
		Arma punhal = new Arma(TipoArma.ARCO, "ARCO");
		
		armas.adicionaItem(espada_curta, espada_curta.getChave());
		armas.adicionaItem(espada_longa, espada_longa.getChave());
		armas.adicionaItem(lanca, lanca.getChave());
		armas.adicionaItem(punhal, punhal.getChave());
		
		return armas;
	}
	
	public ListaItens inicializaItens() {
		return itens;
	}
}
