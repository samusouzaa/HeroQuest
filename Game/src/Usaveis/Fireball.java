package Usaveis;
import java.util.ArrayList;
import java.util.Scanner;
import Externos.Direcao;
import elementosbasicos.GameObject;
import elementosbasicos.Mapa;
import elementosbasicos.Objeto;
import elementosbasicos.personagens.Inimigo;


public class Fireball extends Magia {
	
	private static final String nome = "Fireball";

	public Fireball() {
		super(nome);
		// TODO Auto-generated constructor stub
	}
	
	private Objeto getPrimeiroInimigo(int x, int y, Direcao direcao, Mapa mapa) {
		// Essa função vai percorrer o mapa numa direção e devolver um inimigo assim que
		// o vir
		Objeto inimigo = null;
		int nx = x;
		int ny = y;

		while (inimigo == null) {
			
			if (direcao == Direcao.DOWN)
				nx += 1;

			else if (direcao == Direcao.RIGHT)
				ny += 1;

			else if (direcao == Direcao.LEFT)
				ny -= 1;

			else
				nx -= 1;

			if(nx > mapa.getAltura() || ny > mapa.getLargura())
				break;
			
			inimigo = mapa.getObjetoMapa(nx, ny);
		
		}
		return inimigo;	
	}
	
	public void Usar(GameObject gameobject, Mapa mapa) {
		// TODO Auto-generated method stub
		int x = gameobject.getX();
		int y = gameobject.getY();

		System.out.println("Digite a direção na qual você atirará");
		Scanner keyboard = new Scanner(System.in);

		String command = keyboard.nextLine();
		Direcao direcao = null;

		if(command.compareTo("s") == 0)
			direcao = Direcao.DOWN;
		
		if(command.compareTo("d") == 0)
			direcao = Direcao.RIGHT;
		
		if(command.compareTo("a") == 0)
			direcao = Direcao.LEFT;
		
		if(command.compareTo("w") == 0)
			direcao = Direcao.UP;

		Objeto alvo = getPrimeiroInimigo(x, y, direcao, mapa);
		
		if(alvo != null) {
			alvo.receberDano(6);
		}
		
		ArrayList<GameObject> inimigosProximos = getInimigos(alvo.getX(), alvo.getY(), mapa);
		
		for (GameObject inimigo : inimigosProximos) {
			inimigo.receberDano(3);
		}
		
	}
	
	private ArrayList<GameObject> getInimigos(int x, int y, Mapa mapa){
	
		ArrayList<GameObject> inimigos = new ArrayList<GameObject>();
		
		if (mapa.getObjetoMapa(x-1, y-1) instanceof Inimigo)
			inimigos.add((GameObject) mapa.getObjetoMapa(x-1, y-1));
		
		if (mapa.getObjetoMapa(x-1, y) instanceof Inimigo)
			inimigos.add((GameObject) mapa.getObjetoMapa(x-1, y));
		
		if (mapa.getObjetoMapa(x, y-1) instanceof Inimigo)
			inimigos.add((GameObject) mapa.getObjetoMapa(x, y-1));
		
		if (mapa.getObjetoMapa(x+1, y+1) instanceof Inimigo)
			inimigos.add((GameObject) mapa.getObjetoMapa(x+1, y+1));
		
		if (mapa.getObjetoMapa(x+1, y) instanceof Inimigo)
			inimigos.add((GameObject) mapa.getObjetoMapa(x+1, y));
		
		if (mapa.getObjetoMapa(x, y+1) instanceof Inimigo)
			inimigos.add((GameObject) mapa.getObjetoMapa(x, y+1));
		
		if (mapa.getObjetoMapa(x-1, y+1) instanceof Inimigo)
			inimigos.add((GameObject) mapa.getObjetoMapa(x-1, y+1));
		
		if (mapa.getObjetoMapa(x+1, y-1) instanceof Inimigo)
			inimigos.add((GameObject) mapa.getObjetoMapa(x+1, y-1));
		
		return inimigos;
	}
	
	

}
