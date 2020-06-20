package Externos;

public class Coordenada {
	private int x;
	private int y;

	public Coordenada(int x, int y) {
			this.x = x;
			this.y = y;
		}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void changeCoordinates(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public boolean isSameCoordinates(int x, int y) {
		if (this.x == x && this.y == y) {
			return true;
		}
		return false;
	}

}
