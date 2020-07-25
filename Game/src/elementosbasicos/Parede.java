package elementosbasicos;

public class Parede extends Objeto {
	
	private static final String ICON = "XX";

	public Parede(int x, int y) {
		super(x, y, ICON );
		this.Visto();
	}
	
	public Parede(int x, int y, boolean b) {
		super(x, y, ICON );
	}

}
