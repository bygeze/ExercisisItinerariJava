package m2ex2;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Escribe el limite: ");
		Scanner scanner = new Scanner(System.in);
		
		int z = scanner.nextInt();
		
		// contador de lineas
		for(int i = 1; i < z + 1; i++) {
			// contenido de las lineas
			for(int j = 1; j < i + 1; j++) {
				System.out.print(j);
			}
			System.out.println();
		}
		
		System.out.println("Escribe el limite: ");
		int x = scanner.nextInt();
		
		String toPrint = "";
		
		for(int k = 0; k < x + 1; k++) {
			for(int m = 0; m < (x + x - 2); m++) {
				if(m > k && m < (x + x - 2 - k) ) {
					toPrint += "*";
				} else {
					toPrint += " ";
				}
				
				
				
			}
			System.out.println(toPrint);
			toPrint = "";
			
		}
		
		/*
		
		for(int k = 0; k < x; k++) {
			for(int m = 0; m < x; m++) {
				if(m < k && m < x - 1 - k) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
		
		*/
		
		/*
		
		char[] asteriscos = new char[x];
		// llenar de astericos
		for(int j = 0; j < asteriscos.length; j++) {
			asteriscos[j] = '*';
		}
		
 		for(int k = 0; k < asteriscos.length / 2; k++) {
 	 		// print asteriscos
 	 		for(int p = 0; p < asteriscos.length; p++) {
 	 			System.out.print(asteriscos[p]);
 	 		}
 	 		
 	 		// replace start and end
 	 		asteriscos[k] = ' ';
 	 		asteriscos[x - 1 - k] = ' ';
 		}
 		*/
 		
		scanner.close();
	}

}
