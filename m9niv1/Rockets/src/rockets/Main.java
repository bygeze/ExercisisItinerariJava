package rockets;

import java.util.Scanner;

public class Main {
	
	static private Scanner sc = new Scanner(System.in);;
	

	public static void main(String[] args) {

		
		Rocket rocket = new Rocket("32WESSDS", new int[] {10, 30, 80}) ;
		Rocket rocket2 = new Rocket("LDSFJA32", new int[] {30, 40, 50, 50, 30, 10});
		
		System.out.println(rocket.toString());
		System.out.println(rocket2.toString());
		
		System.out.println("Se utilizará el cohete: " + rocket.getId());
		
		boolean exec = true;
		while(exec) {
			if(!rocket.isMoving()) {
				Integer in = userInput();
				
				if(in == 0) {
					break;
				}
				rocket.move(in);
			}
		}
		
		
	}
	
	private static Integer userInput() {
		System.out.println("Escribe un número (positivo acelera, negativo frena): ");
		String input = sc.nextLine();
		Integer i_input = Integer.parseInt(input);
		
		return i_input;
	}

}
