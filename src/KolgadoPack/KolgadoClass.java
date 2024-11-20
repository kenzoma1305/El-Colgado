package KolgadoPack;
import java.util.Scanner;
public class KolgadoClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner usuario = new Scanner(System.in);
		
		//El usuario eligirá la palabra secreta al inicio de la partida
		System.out.println("¡Oye! Dime qué palabra quieres ocultar: ");
		String palabraOculta = usuario.nextLine().toLowerCase();
		int LetrasPalabraOculta = palabraOculta.length();
		
		//El juego preguntará por el número de jugadores, siendo mínimo 2 y máximo 4
		System.out.println("¡Bienvenido al juego del colgado héroe!");
		System.out.print("¿Cuántos quereis salvar a Cecilio? (Mín: 2; Máx: 4): ");
		int numJugadores = usuario.nextInt();
		
		//Validamos el número de jugadores con las condiciones que pusimos con un pequeño bucle
		while (numJugadores < 2 || numJugadores > 4) {
			System.out.println("Oops... ¡El número de jugadores es inválido!");
			System.out.print("Recuerda que teneis que ser entre 2 y 4: ");
			numJugadores = usuario.nextInt();
		}
		usuario.nextLine();
		
		//Creción de nicknames para cada jugador
		String[] jugadores = new String[numJugadores];
		for (int i = 0; i < numJugadores; i++) {
			jugadores[i] = "Jugador nº " + (i + 1); /*Esto hace que el nombre del jugador sea: Jugador 1
			 											y en adelante*/
		}
		
		//Comenzamos el juego con las palabras ocultas con un guión bajo
		System.out.print("¡COMENCEMOS!");
		char [] palabraGuiones = new char[LetrasPalabraOculta];
		for (int i = 0; i < palabraGuiones.length; i++) {
			palabraGuiones[i] = '_';
		}
		
		/*Creamos variables para almacenar los intentos, las letras adivinadas (como contador)
		 y el tuno actual de la partida*/
		int intentos = 6;
		int letrasAdivinadas = 0;
		int contadorTurno = 0;
		
		//Imprimimos dos mensajes para introducir el juego
		System.out.println("¡Debemos salvar a nuestro amigo Cecilio!");
		System.out.println("¿Podreis adivinar la palabra oculta?");
		
		//Creamos un bucle mientras queden intentos y no se haya adivinado toda la palabra.
		while (intentos > 0 && letrasAdivinadas < LetrasPalabraOculta) {
			//Nos muestra el progreso de la partida
			System.out.println("Palabra: ");
			for (char c : palabraGuiones) {
				System.out.print(c + " "); //Se nos muestra los guiones y las letras acertadas
			}
			System.out.println("\nIntentos restantes: " + intentos);
			
			//Le pide al usuario que introduzca una letra
			System.out.println("\nEs el turno de " + jugadores[contadorTurno]);
			System.out.println("Escribe una letra: ");
			char letra = usuario.nextLine().toLowerCase().charAt(0);
			
			//Comprobar si la letra esta en la palabra por adivinar
			int aciertos = 0;
			for (int i = 0; i < palabraOculta.length(); i++) {
				if (palabraOculta.charAt(i) == letra && palabraGuiones[i] == '_') {
					palabraGuiones[i] = letra; //Reemplazará el guión con la letra de la posición
					aciertos++;
					letrasAdivinadas++;
				}
			}
			
			//Si no hubieron aciertos
			if (aciertos == 0) {
				intentos--;
			}
			
			//Cuando haya un error, se cambia automáticamente al siguiente jugador
			contadorTurno = (contadorTurno + 1) % numJugadores;
			
			//Si se ha completado la palabra
			if(letrasAdivinadas == LetrasPalabraOculta) {
				break;
			}
		}
		
		//Final del juego
		if (letrasAdivinadas == LetrasPalabraOculta) {
			System.out.println("\n¡Muy bien! Conseguisteis salvar a Pepito con la palabra: " + palabraOculta);
		} else {
			System.out.println("\nVaya... Os quedaste sin intentos. Para salvarlo, era con: " + palabraOculta + "...");
		}
		
		//Cerramos al terminar
		System.out.println("¡Hasta la próxima héroes!");
		usuario.close();
	}

}
