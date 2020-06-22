package Usaveis;

import java.util.HashMap;
import java.util.Map;

public class ListaItens {
	
	Map<String, Item> lista_itens = new HashMap<>();
	
	protected void adicionaItem(Item item, String chave) {
		lista_itens.put(chave, item);
	}
	
	public Item getItem(String chave) {
		Item item = lista_itens.get(chave);
		return item;
	}
}
