package KolgadoPack;
import java.util.Scanner;
public class KolgadoClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
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
		
		
		
	}

}
