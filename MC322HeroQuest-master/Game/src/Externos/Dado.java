package Externos;
import java.util.Random;

/*Classe de dados
 * O dado do tipo A serve para andar. Mostra o número tirado diretamente para o usuário e retorna o valor
 * O dado do tipo B é de ataque/defesa e possuem as seguintes características: 
 * 		- Os números retornados de 1 a 3 representam caveira
 * 		- Os número 4 e 5 representam o escudo do herói
 * 		- O número 6 representa o escudo do monstro
 * */
public class Dado{
	
	public int resultadoDado(char tipo_dado) {
		
		int resultado = new Random().nextInt(6) + 1;
		
		if(tipo_dado == 'A') {
			System.out.printf("Voce tirou o número %d no dado\n", resultado);
		}
		
		else {
			if(resultado < 4) {
				System.out.printf("Caveira\n");
			}
			else if(resultado == 6) {
				System.out.printf("Escudo de Monstro\n");
				
			}
			else {
				System.out.printf("Escudo de herói\n");
			}
		}
		return resultado;
	}
}