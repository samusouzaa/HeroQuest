package Usaveis;

import java.util.Scanner;
import elementosbasicos.Mapa;
import elementosbasicos.GameObject;

public class Teleport extends Magia{
	

	private static final String nome = "Teleport";
	
	public Teleport() {
		super(nome);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void Usar(GameObject gameobject, Mapa mapa) {
		System.out.println("Digite as coordenadas da posição para qual se teletransportará");
		Scanner keyboard = new Scanner(System.in);
		while(true) {
			int x = keyboard.nextInt();
			int y = keyboard.nextInt(); 
			
			if (Teletransportavel) {
				//Mudar coordenadas
				break;
			}
			else {
				System.out.println("Coordenadas inválidas. Redigite-as");
			}
		}
		
	}
	
	private boolean Teletransportavel() {
		
	}

}
