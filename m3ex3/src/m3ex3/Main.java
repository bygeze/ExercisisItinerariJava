package m3ex3;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Ingresa el limite");
		int limite = scanner.nextInt();
		
		int num1 = 0, num2 = 1, suma = 1;
		
		System.out.print(num1 + " ");
		for(int i = 1; i < limite; i++) {

			
			suma = num1 + num2;
			
			num1 = num2;
			
			num2 = suma;
			
			System.out.print(suma + " ");
		}
	}
	

}
