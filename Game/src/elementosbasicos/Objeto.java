package elementosbasicos;

import Externos.Coordenada;

public abstract class Objeto  {
private Coordenada coordenada;
private boolean visivel;
	
	public Objeto(int x, int y) {
		coordenada = new Coordenada(x,y);
		visivel = false;
	}
	
	protected Coordenada getCoordinate() {
		return coordenada;
	}
	
	protected void atualizaCoordinate(int x, int y) {
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
		return " ";
	}

	
	
}
