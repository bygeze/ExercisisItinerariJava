package m3ex1;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		/*
		 *  ==========================================================
		 *  FASE (1)
		 */
		
		System.out.println("\nFASE 1\n");
		
		// Crea sis variables de tipus "String" buides.
		String var1, var2, var3, var4, var5, var6;
		
		// Demana per consola que s'introdueixin els noms
		Scanner myScanner = new Scanner(System.in);
		
		int z = 0;
		z++; System.out.println("Ingresa el nombre de la ciudad #" + z);
		var1 = myScanner.nextLine();
		z++; System.out.println("Ingresa el nombre de la ciudad #" + z);
		var2 = myScanner.nextLine();
		z++; System.out.println("Ingresa el nombre de la ciudad #" + z);
		var3 = myScanner.nextLine();
		z++; System.out.println("Ingresa el nombre de la ciudad #" + z);
		var4 = myScanner.nextLine();
		z++; System.out.println("Ingresa el nombre de la ciudad #" + z);
		var5 = myScanner.nextLine();
		z++; System.out.println("Ingresa el nombre de la ciudad #" + z);
		var6 = myScanner.nextLine();
		
		
		System.out.println(var1 + ", " + var2 + ", " + var3 + ", " + var4 + ", " + var5 + ", " + var6);
		
		
		/*
		 *  ==========================================================
		 *  FASE (2)
		 */
		
		System.out.println("\nFASE 2\n");
		
		// Un cop tenim els noms de les ciutats guardats en variables 
		// haurem de pasar l’informacio a un array (arrayCiutats). 
		String[] arrayCiutats = new String[6];
		
		int x = 0;
		arrayCiutats[x] = var1; x++; 
		arrayCiutats[x] = var2; x++; 
		arrayCiutats[x] = var3; x++; 
		arrayCiutats[x] = var4; x++; 
		arrayCiutats[x] = var5; x++; 
		arrayCiutats[x] = var6;
		
		// Quan tinguem l’array ple, haurem de mostrar per consola 
		// el nom de les ciutats ordenadas per ordre alfabetic. 
		
		// ordenar el array
		Arrays.sort(arrayCiutats);
		
		// imprimirlo
		for(int i = 0; i < arrayCiutats.length; i++) {
			System.out.println(arrayCiutats[i]);
		}
		
		/*
		 *  ==========================================================
		 *  FASE (3)
		 */
		
		System.out.println("\nFASE 3\n");
		
		// Cambieu les vocals “a” dels noms de les ciutats per el numero 4 
		// i guardeu els noms modificats en un nou array(ArrayCiutatsModificades). 
		
		String[] arrayCiutatsModificades = new String[6];
		
		for(int i = 0; i < arrayCiutatsModificades.length; i++) {
			arrayCiutatsModificades[i] = arrayCiutats[i].replace('a', '4');
		}
		
		// Mostreu per consola l’array modificat i ordenat per ordre alfabetic. 

		
		Arrays.sort(arrayCiutatsModificades);
		
		for(int i = 0; i < arrayCiutatsModificades.length; i++) {
			System.out.println(arrayCiutatsModificades[i]);
		}
		
		/*
		 *  ==========================================================
		 *  FASE (4)
		 */
		
		System.out.println("\nFASE 4\n");
		
		
		// Creeu un nou array de caràcters (char array[])per cada una de les ciutats que tenim. 
		// La mida dels nous arrays sera la llargada de cada string ( string nomCiutat.Length).  
		
		// plus: creo un array de arrays de caracteres para acceder mas facilmente luego.
		char[][] arrayCiutatsToChar = new char[arrayCiutats.length][];
		
		for(int i = 0; i < arrayCiutatsToChar.length; i++) {
			char[] aux = new char[arrayCiutats[i].length()];
			
			// Ompliu els nous arrays lletra per lletra. 
			
			aux = arrayCiutats[i].toCharArray();
			
				// tmb podria usar un for para añadir elemento por elemento
			
			arrayCiutatsToChar[i] = aux;
		}
		
		// imprimir ex: Barcelona - anolecraB
		
		for(int i = 0; i < arrayCiutatsToChar.length; i++) {
			for(int j = 0; j < arrayCiutatsToChar[i].length; j++) {
				System.out.print(arrayCiutatsToChar[i][j]);
			}
			
			System.out.print(" - ");
			
			for(int k = arrayCiutatsToChar[i].length; k > 0 ; k--) {
				System.out.print(arrayCiutatsToChar[i][k-1]);
			}
			
			System.out.println();
		}
	}

}
