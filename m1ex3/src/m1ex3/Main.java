package m1ex3;

public class Main {
	public static void main(String[] args) {
		int[] array = {1,2,3,4,5,6,7,8,9,10};
		
		for(int i = 0; i < array.length; i++) {
			System.out.print(array[i]);
		}
		System.out.println();
		
		// proceso de rotacion
		// el valor en la posicion 0 se guarda en la variable auxiliar
		// el valor en la posicion 0 se cmabia por el de su posicion simetrica, el final del array (longitud - (i + 1)
		// la posicion de donde recogimos el valor se cambia por la auxuilar
		
		for(int i = 0; i < (array.length / 2); i++) {
			int aux = array[i];
			
			array[i] = array[array.length - 1 - i];
			
			array[array.length - 1 - i] = aux;
		}

		for(int i = 0; i < array.length; i++) {
			System.out.print(array[i]);
		}
		
	}
}
