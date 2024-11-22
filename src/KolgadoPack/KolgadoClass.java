package KolgadoPack;
import java.util.Scanner;
public class KolgadoClass {

	public static void main(String[] args) {
	
		/*Este es el juego del colgado y tendremos que salvar a Cecilio de la soga...
		 * Las reglas del jugo son:
		 * 			- Cada jugador tiene que adivinar una letra de la palabra secreta en cada ronda.
		 * 			- El número máximo de intentos por jugador es 6.
		 * 			- Si un jugador adivina correctamente una letra, esta se revela en su posición en la palabra secreta.
		 * 			- Si un jugador se queda sin intentos, pierde la ronda.
		 * 			- El jugador que adivine toda la palabra primero o quien gane más rondas será el ganador.*/
		
		//Abrimos scanner para que el usuario pueda entrar los datos que se pidan más adelante
		Scanner usuario = new Scanner(System.in);
		
		//El juego preguntará por el número de jugadores, siendo mínimo 2 y máximo 4
		System.out.println("¡Bienvenido al juego del colgado héroe!");
		System.out.print("¿Cuántos quereis salvar a Cecilio? (Mín: 2; Máx: 4): ");
		int numJugadores = usuario.nextInt();
		
		//Validamos el número de jugadores con las condiciones que pusimos con un pequeño bucle, si no lo está, nos lo vuelve a preguntar
		while (numJugadores < 2 || numJugadores > 4) {
			System.out.println("Oops... ¡El número de jugadores es inválido!");
			System.out.print("Recuerda que teneis que ser entre 2 y 4: ");
			numJugadores = usuario.nextInt();
		}
		usuario.nextLine();
		
		/*Creción de nicknames para cada jugador con dos arrays, 
		 *para almacenar los nombres automáticos y para llevar la cuenta de las 
		 *rondas ganadas por cada jugador.
		 */
		String[] jugadores = new String[numJugadores];
		int[] points = new int[numJugadores];
		for (int i = 0; i < numJugadores; i++) {
			jugadores[i] = "Jugador nº " + (i + 1); //Esto hace que el nombre del jugador sea: Jugador 1 y en adelante
		}
		
		//Se nos preguntará por el número de rondas
		System.out.println("Dime cúantas rondas quieres jugar: ");
		int numRondas = usuario.nextInt();
		usuario.nextLine(); 
		
		//Para jugar por rondas creamos bucle
		for (int ronda = 1; ronda <= numRondas; ronda++ ) {
			System.out.println("\n···RONDA " + ronda + "···");
			
			//El usuario eligirá la palabra secreta al inicio de la partida
			System.out.println("¡Oye! Dime qué palabra quieres ocultar: ");
			String palabraOculta = usuario.nextLine().toLowerCase(); //En minúsculas para evitar errores de comparación de caracteres
			int LetrasPalabraOculta = palabraOculta.length();
			
			//Comenzamos el juego con las palabras ocultas con un guión bajo
			System.out.println("¡COMENCEMOS!");
			char [] palabraGuiones = new char[LetrasPalabraOculta]; //Array que contiene guiones bajos en vez de letras
			for (int i = 0; i < palabraGuiones.length; i++) {
				palabraGuiones[i] = '_';
			}
			
			//Creamos variables para contar el progreso de la partida
			int letrasAdivinadas = 0; //Contador de letras acertadas 
			int[] intentosJugador = new int[numJugadores];
			for (int i = 0; i < numJugadores; i++) {
				intentosJugador[i] = 6;  //Cada uno de los jugadores tiene 6 intentos
			}
			
			int contadorTurno = 0; //Contador de turnos 
			int winnerRonda = -1; //He puesto este valor ya que al principio, no existe ningún ganador
			
			//Creamos el bucle principal de la ronda
			while (letrasAdivinadas < LetrasPalabraOculta) {
				//Comprobamos si el jugador que está jugando la ronda 
				if (intentosJugador[contadorTurno] <= 0) {
					System.out.println("¡" + jugadores[contadorTurno] + " se quedó seco y pierde la ronda!" );
					contadorTurno = (contadorTurno + 1) % numJugadores;
					continue; //Esto hace que cuando esto suceda, se cambie al siguiente jugador
				}
				
				//El progreso de la palabra oculta
				System.out.println("Palabra: ");
				for (char c : palabraGuiones) {
					System.out.print(c + " "); //Se nos muestra los guiones y las letras acertadas
				}
				System.out.println("\nIntentos restantes del " + jugadores[contadorTurno] + ": " + intentosJugador[contadorTurno]);
				
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
				
				//Si no hubieron aciertos, el jugador pierde un intento
				if (aciertos == 0) {
					intentosJugador[contadorTurno]--;
				}
				
				//Cuando haya un error, se cambia automáticamente al siguiente jugador
				contadorTurno = (contadorTurno + 1) % numJugadores;
				
				//Si se ha completado la palabra
				if(letrasAdivinadas == LetrasPalabraOculta) {
					winnerRonda = contadorTurno;
					break;
				}	
			}
			
			//Finalización de la ronda
			if (winnerRonda != -1) {
				System.out.println("\n¡El " + jugadores[winnerRonda] + " adivinó la palabra y es el ganador de la ronda!");
				points[winnerRonda]++;
			} else {
				System.out.println("\n¡Vaya! Nadie consiguió descifrar la palabra... Era: " + palabraOculta);
			}
			
		}
		
		//Final del juego
		System.out.println("\n>>>·FINAL RESULTS·<<<");
		int maxPoints = 0;
		String finalWinner = "";
		
		for (int i = 0; i < numJugadores; i++) {
			System.out.println(jugadores[i] + ": " + points[i] + " rondas ganadas.");
			if (points[i] > maxPoints) {
				maxPoints = points[i];
				finalWinner = jugadores[i];
			}
		}
		
		//Creamos un mensaje final
		System.out.println("\n¡El que rescató a Cecilio fue " + finalWinner + " con " + maxPoints + " rondas ganadas!");
		
		//Cerramos al terminar
		System.out.println("¡Hasta la próxima héroes!");
		usuario.close();
	}

}
