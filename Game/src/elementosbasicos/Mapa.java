package elementosbasicos;
import elementosbasicos.personagens.*;
import java.util.ArrayList;

public class Mapa {
	public static void main(String[] args) {
		Mapa mapa = new Mapa();
		mapa.printMap();
	}
	private Objeto[][] mapa;
	
	private static final int LARGURA = 36;
	private static final int ALTURA = 27;

	protected Mapa() {
		mapa = new Objeto[ALTURA][LARGURA];
		CriarMapaPadrao();
		
	}
	
	public int getLargura() {
		return LARGURA;
	}
	
	public int getAltura() {
		return ALTURA;
	}
	
	public Objeto getObjetoMapa(int x, int y){
		return mapa[x][y];
	}
	
	protected void addObjeto(Objeto objeto) {
		mapa[objeto.getX()][objeto.getY()] = objeto;
	}
	
	protected void removeObjeto(Objeto objeto) {
		mapa[objeto.getX()][objeto.getY()] = null;
	}
	
	private void CriarMapaPadrao(){
		for (int i = 0; i < LARGURA; i++ ) {
			Parede parede1 = new Parede(0, i);
			this.addObjeto(parede1);
			Parede parede2 = new Parede(ALTURA-1, i);
			this.addObjeto(parede2);
		}
		
		for (int i = 0; i < ALTURA; i++ ) {
			Parede parede1 = new Parede(i, 0);
			this.addObjeto(parede1);
			Parede parede2 = new Parede(i, LARGURA-1);
			this.addObjeto(parede2);
		}
		
		for (int i = 2; i < LARGURA - 2; i++) {
			if(i != 17 && i  != 18) {
				Parede parede = new Parede(2, i);
				this.addObjeto(parede);
			}
		}
		
		for (int i = 2; i < LARGURA - 2; i++) {
			if(i != 17 && i  != 18) {
				Parede parede = new Parede(2, i);
				this.addObjeto(parede);
			}
		}
		
		for (int i = 3; i < ALTURA-3; i++) {
			if((i > 1 && i < 12) || (i > 14 && i < 24)) {
				Parede parede = new Parede(i, 2);
				this.addObjeto(parede);
				parede = new Parede(i, 12);
				this.addObjeto(parede);
				parede = new Parede(i, 28);
				this.addObjeto(parede);
				parede = new Parede(i, 33);
				this.addObjeto(parede);
			}
		}
		
		for(int i = 3; i < 11; i++) {
			Parede parede = new Parede(i, 7);
			this.addObjeto(parede);
		}
		
		for(int i = 15; i < 24; i++) {
			Parede parede = new Parede(i, 6);
			this.addObjeto(parede);
		}
		
		for (int i = 3; i < ALTURA-3; i++) {
			if(i > 1 && i < 12) {
				Parede parede = new Parede(i, 23);
				this.addObjeto(parede);
			}
		}
		
		for (int i = 2; i < 12; i++) {
			
				Parede parede = new Parede(5, i);
				this.addObjeto(parede);
				parede = new Parede(5, 21 + i);
				this.addObjeto(parede);
				parede = new Parede(11, i);
				this.addObjeto(parede);
				parede = new Parede(11, 21 + i);
				this.addObjeto(parede);
				parede = new Parede(15, i);
				this.addObjeto(parede);
				parede = new Parede(15, 21 + i);
				this.addObjeto(parede);
		}
		
		for(int i = 2; i < 9; i++) {
			Parede parede = new Parede(i,16 );
			this.addObjeto(parede);
			parede = new Parede(i,19 );
			this.addObjeto(parede);
		}
		
		for (int i = 12; i <17; i++) {
			Parede parede = new Parede(8,i);
			this.addObjeto(parede);
			parede = new Parede(8,i + 7 );
			this.addObjeto(parede);
		}
		
		for (int i = 2; i < LARGURA - 2; i++) {
			if(i != 17 && i  != 18) {
				Parede parede = new Parede(24, i);
				this.addObjeto(parede);
			}
		}
		
		for (int i = 10; i < 18; i++) {
			Parede parede = new Parede(i,14 );
			this.addObjeto(parede);
			parede = new Parede(i,21 );
			this.addObjeto(parede);
		}
		
		for (int i = 2; i< 7; i++) {
			Parede parede = new Parede(19, i);
			this.addObjeto(parede);
			parede = new Parede(19, i + 10);
			this.addObjeto(parede);
			parede = new Parede(19, i + 18);
			this.addObjeto(parede);
		}
		
		for(int i = 19; i<24; i++) {
			Parede parede = new Parede(i, 19);
			this.addObjeto(parede);
			parede = new Parede(i, 16);
			this.addObjeto(parede);
		}
		
		for(int i = 24; i < 33; i++ ) {
			Parede parede = new Parede(20, i);
			this.addObjeto(parede);
		}
		
		for (int i = 6; i< 13; i++) {
			Parede parede = new Parede(18, i);
			this.addObjeto(parede);
		}
		
		for (int i = 15; i< 20; i++) {
			Parede parede = new Parede(i, 23);
			this.addObjeto(parede);
		}
		for (int i = 14; i< 21; i++) {
			Parede parede = new Parede(10, i);
			this.addObjeto(parede);
			parede = new Parede(17, i);
			this.addObjeto(parede);
		}
		
		
	}
	
	protected void printMap() {
		for (int i = 0; i < ALTURA; i++) {
			for (int j = 0; j < LARGURA; j++) {
				if(mapa[i][j] == null) 
					System.out.printf("  ");
					
				else
					System.out.printf(mapa[i][j].toString());
			}
			System.out.println();
		}
	}
	
	
//	public boolean isWon() {
//		for (GameObject inimigo : inimigos) {
//			if(!inimigo.isAlive())
//				return false;
//		}
//		return true;
//	}
//	
//	public boolean isLost() {
//		for (GameObject aliado : aliados) {
//			if(!aliado.isAlive())
//				return false;
//		}
//		return true;
//	}
//	
}
