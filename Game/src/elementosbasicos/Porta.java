package elementosbasicos;

public class Porta extends Objeto{

	private static final String ICON = "PP";
	
	public Porta(int x, int y) {
		super(x, y, ICON);
	}
	
	@Override 
	public boolean Abrivel() {
		return true;
	}
	
	@Override
	public String toString() {
		if(getVisibilidade())
			return "PP";
		return "XX";
	}
}
