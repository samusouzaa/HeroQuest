package Externos;
import java.util.Random;

/*Classe de dados
 * O dado do tipo A serve para andar. Mostra o n�mero tirado diretamente para o usu�rio e retorna o valor
 * O dado do tipo B � de ataque/defesa e possuem as seguintes caracter�sticas: 
 * 		- Os n�meros retornados de 1 a 3 representam caveira
 * 		- Os n�mero 4 e 5 representam o escudo do her�i
 * 		- O n�mero 6 representa o escudo do monstro
 * */
public class Dados{
	
	public int resultadoDado(char tipo_dado) {
		
		int resultado = new Random().nextInt(6) + 1;
		
		if(tipo_dado == 'A') {
			System.out.printf("Voce tirou o n�mero %d no dado\n", resultado);
		}
		
		else {
			if(resultado < 4) {
				System.out.printf("Caveira\n");
			}
			else if(resultado == 6) {
				System.out.printf("Escudo de Monstro\n");
				
			}
			else {
				System.out.printf("Escudo de her�i\n");
			}
		}
		return resultado;
	}
}