package m1ex1;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 *   FASE (1)
		 *   ==================================================
		 */
		System.out.println("FASE 1");
		
		// Crea tres variables string e inicialitzales amb les dades pertinents (nom, cognom1, cognom2).
		String nom, cognom1, cognom2;
		
		nom = "Lionel";
		cognom1 = "Messi";
		cognom2 = "Cuccittini";
		
		//Crea tres variables int e inicialitzales amb les dades pertinents (dia, mes, any).
		int dia, mes, any;
		
		dia = 24;
		mes = 6;
		any = 1987;
		
		//Mostra per pantalla les variables string concatenant-les en aquest ordre (cognom1 + cognom2, + nom).
		System.out.println(cognom1 + " " + cognom2 + ", " + nom);
		
		// Mostra per pantalla les variables int concatenant-les amb “/” entre cada una d’elles
		System.out.println(dia + "/" + mes + "/" + any);
		
		
		/*
		 * FASE (2)
		 * ============================================ 
		 */
		System.out.println("\nFASE 2");
		
		// Creeu una constant amb el valor de l’any (1948).
		int ANY = 1948;
		int TIEMPOTRASPASO = 4;
		int MYANYNAIXEMENT = 1998;
		
		// Calculeu quants anys de traspàs hi ha entre 1948 i el vostre any de naixement i emmagatzemeu el valor resultant en una variable. 
		int resultado = (MYANYNAIXEMENT - ANY) / 4;
		
		// Mostreu per pantalla el resultat del càlcul.
		System.out.println("Numero de años bisiestos desde " + MYANYNAIXEMENT + " hasta " + MYANYNAIXEMENT + ": " + resultado);
		
		// Feu servir un bucle for, mostrant tots aquests anys.
		int auxAnys = ANY;
		for(int i = ANY; i < MYANYNAIXEMENT; i = i + 4) {
			System.out.print(i + " ");
		}
		
		/*
		 * FASE (3)
		 * ============================================ 
		 */
		System.out.println("\n\nFASE 3");
		boolean esTraspaso = intEsTraspaso(MYANYNAIXEMENT);
		
		sayEsTraspaso(esTraspaso, MYANYNAIXEMENT);
		

		
		/*
		 * FASE (4)
		 * ============================================ 
		 */
		// Creeu una variable on juntareu el nom i els cognoms (tot en una variable) 
		//i un altre on juntareu la data de naixement separada per “/” (tot en una variable). 
		//Mostreu per consola les variables del nom complet, la data de naixement i si l’any de(//
		//naixement es de traspàs o no.
		System.out.println("\nFASE 4");
		
		String sayMyNameIs = "El meu nom es " + nom + " " + cognom1 + " " + cognom2;
		String sayDateOfBirth = "Vaig neixer el " + dia + "/" + mes + "/" + any;
		
		System.out.println(sayMyNameIs);
		System.out.println(sayDateOfBirth);
		
		sayEsTraspaso(intEsTraspaso(any), any);
		
			
		
	}
	
	static boolean intEsTraspaso(int a) {
		if(a % 100 == 0) {
			return true;
		} else if(a % 4 == 0 && a % 100 != 0) {
			return true;
		} else {
			return false;
		}
	}
	
	static void sayEsTraspaso(boolean esTraspas, int any) {
		String saySiTraspaso = "El año " + any + " es bisiesto";
		String sayNoTraspaso = "El año " + any + " no es bisiesto";
		
		if(esTraspas) {
			System.out.println(saySiTraspaso);
		} else {
			System.out.println(sayNoTraspaso);
		}
	}
}
