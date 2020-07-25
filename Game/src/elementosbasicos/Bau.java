package elementosbasicos;

import java.util.ArrayList;
import java.util.Scanner;

import Usaveis.Item;

public class Bau extends Objeto {
	
	private static final String ICON = "BB";
	
	private ArrayList<Item> bau;

	public Bau(int x, int y) {
		super(x, y, ICON );
		bau = new ArrayList<Item>();
	}
	
	public void addItem(Item item) {
		bau.add(item);
	}
	
//	public void abrirBau() {
//		System.out.println("Itens do bau");
//		for(int i = 0; i < bau.size(); i++) {
//			System.out.println("Item " + (i+1) + " : " + bau.get(i).getChave());
//		}
//		System.out.println("Quais itens voce quer pegar [Digite 0 para sair do bau]");
//	
//		Scanner keyboard = new Scanner(System.in);
//		int command = keyboard.nextInt();
//		
//		while(command != 0) {
//			
//		}
//		
//	}
	
	
}
