package elementosbasicos;

import java.util.ArrayList;

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
	
	
}
