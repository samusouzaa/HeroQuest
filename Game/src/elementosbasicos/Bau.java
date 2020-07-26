package elementosbasicos;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import Usaveis.Item;
import Usaveis.ListaItens;
import elementosbasicos.personagens.Heroi;

public class Bau extends Objeto {
	
	private static final String ICON = "BB";
	
	private ArrayList<Item> bau;

	public Bau(int x, int y, ListaItens armas, ListaItens itens, ListaItens magias) {
		super(x, y, ICON );
		bau = new ArrayList<Item>();
		this.inicializaBau(armas, itens, magias);
	}
	
	public void addItem(Item item) {
		bau.add(item);
	}
	
	public void abrirBau(Heroi heroi) {
		System.out.println("Itens do bau");
		for(int i = 0; i < bau.size(); i++) {
			System.out.println("Item " + (i+1) + " : " + bau.get(i).getChave());
		}
		System.out.println("Quais itens voce quer pegar [Digite 0 para sair do bau]");
	
		Scanner keyboard = new Scanner(System.in);
		int command = keyboard.nextInt();
		
		while(command != 0 && bau.size()>0 ) {
			if (command <= bau.size()) {
				heroi.adicionaItemBau(bau.get(command-1));
				bau.remove(command-1);
				for(int i = 0; i < bau.size(); i++) {
					System.out.println("Item " + (i+1) + " : " + bau.get(i).getChave());
				}
			if (bau.size() > 0 )
				command = keyboard.nextInt();
			}
			else {
				System.out.println("Digite um item v�lido");
				command = keyboard.nextInt();
			}
		}
		
	}
	
	private void inicializaBau(ListaItens armas, ListaItens itens, ListaItens magias){
		int numero_armas = new Random().nextInt(3);
		int numero_itens = new Random().nextInt(3) + 1;
		int numero_magias = new Random().nextInt(2);
		
		for (int i = 0; i < numero_armas; i++) {
			bau.add(armas.itemAleatorio());
		}
		
		for (int i = 0; i < numero_itens; i++) {
			bau.add(itens.itemAleatorio());
		}
		
		for (int i = 0; i < numero_magias; i++) {
			bau.add(magias.itemAleatorio());
		}
	}
	
	
}
