package Usaveis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class ListaItens {
	
	Map<String, Item> lista_itens = new HashMap<>();
	
	public void adicionaItem(Item item, String chave) {
		lista_itens.put(chave, item);
	}
	
	public Item getItem(String chave) {
		Item item = lista_itens.get(chave);
		return item;
	}
	
	public void removerItem(String chave) {
		lista_itens.remove(chave);
	}
	
	public Item itemAleatorio() {
		ArrayList<Item> itens = new ArrayList<Item>(lista_itens.values());
		int item_ecolhido = new Random().nextInt(itens.size());
		return itens.get(item_ecolhido);
		 
	}
}
