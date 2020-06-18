package Usaveis;

import personagens.GameObject;
import java.util.Scanner;

public class Teleport extends Magia{
	public void Usar(GameObject gameobject) {
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
