package elementosbasicos;

import Externos.Coordenada;

public abstract class Objeto  {
private Coordenada coordenada;
private boolean visivel;
private String icon;
	
	public Objeto(int x, int y, String icon) {
		coordenada = new Coordenada(x,y);
		visivel = false;
		this.icon = icon;
	}
	
	protected Coordenada getCoordinate() {
		return coordenada;
	}
	
	public void atualizaCoordinate(int x, int y) {
		this.coordenada.changeCoordinates(x,y);
	}
	
	public int getX() {
		return coordenada.getX();
	}
	
	
	public int getY() {
		return coordenada.getY();
	}
	
	public boolean isSameCoordinates(int x, int y) {
		return coordenada.isSameCoordinates(x, y);
	}
	
	public boolean isSameCoordiantes(Objeto object) {
		return coordenada.equals(object);
	}
	
	public void Visto() {
		visivel = true;
	}
	
	public void receberDano(int dano) {
		return;
	}
	
	public boolean copiavel() {
		return true;
	}
	
	public boolean getVisibilidade() {
		return visivel;
	}
	
	@Override
	public String toString() {
		if(visivel)
			return icon;
		else
			return "  ";
	}

	
	
}
