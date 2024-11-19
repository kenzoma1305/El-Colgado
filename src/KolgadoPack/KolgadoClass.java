package KolgadoPack;
import java.util.Scanner;
public class KolgadoClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner usuario = new Scanner(System.in);
		
		//Creamos la palabra oculta para el juego con un string
		String palabraOculta = "baldufa";
		int LetrasPalabraOculta = palabraOculta.length();
		
		//Comenzamos el juego con las palabras ocultas con un guión bajo
		char [] palabraGuiones = new char[LetrasPalabraOculta];
		for (int i = 0; i < palabraGuiones.length; i++) {
			palabraGuiones[i] = '_';
		}
		
		//Creamos variables para almacenar los intentos y las letras adivinadas (como contador)
		int intentos = 6;
		int letrasAdivinadas = 0;
		
		//Imprimimos dos mensajes para introducir el juego
		System.out.println("¡Debemos salvar a nuestro amigo Pepito!");
		System.out.println("¿Podrás adivinar la palabra oculta?");
		
		//Creamos un bucle mientras queden intentos y no se haya adivinado toda la palabra.
		while (intentos > 0 && letrasAdivinadas < LetrasPalabraOculta) {
			//Nos muestra el progreso de la partida
			System.out.println("Palabra: ");
			for (char c : palabraGuiones) {
				System.out.println(c + "");
			}
			System.out.println("\nIntentos restantes: " + intentos);
			
			System.out.println("Escribe una letra: ");
			char letra = usuario.nextLine().toLowerCase().charAt(0);
			
			int aciertos = 0;
			for (int i = 0; i < palabraOculta.length(); i++) {
				if (palabraOculta.charAt(i) == letra && palabraGuiones[i] == '_') {
					palabraGuiones[i] = letra;
					aciertos++;
					letrasAdivinadas++;
				}
			}
		}
		
		
	}

}
