package view;

import java.util.Scanner;
import java.util.regex.Pattern;

import exceptions.CannotBeEmptyException;

public class MyScanner {
	private static Scanner scanner = new Scanner(System.in);
	
	public MyScanner() {}
	
	public Integer handlerGenericMenu(String menu, int[] options) {
		Integer toReturnSelectedOption = null;
		
		boolean loopFlag = true;
		while(loopFlag) { 
			System.out.print(menu);
			toReturnSelectedOption = userInputSelectMenuOption(options);
			
			if(toReturnSelectedOption != null) {
				loopFlag = false;
			}
			
			if(loopFlag) {
				System.out.println("No conozco la opción. Intente de nuevo.");
			}
		}
		
		return toReturnSelectedOption;
	}
	
	
	public Integer userInputSelectMenuOption(int[] options) {
		Integer toReturn;
		
		String input = scanner.nextLine();
		
		try {
			toReturn = Integer.parseInt(input);
		} catch(NumberFormatException e) {
			toReturn = null;
		}
		
		boolean validateOptions = false;
		if(toReturn != null) {
			for(int i = 0; i < options.length; i++) {
				if(toReturn.equals(options[i])) {
					validateOptions = true;
					break;
				}
			}
		}
		
		if(!validateOptions) toReturn = null;

		return toReturn;
	}
	
	public String userInputTextLoop(String msg, Integer length, Boolean empty, String regex) {
		String toReturn = "";
		Boolean loopFlag = true;
		while(loopFlag) {
			System.out.print(msg);
			String[] input = userInputText(length, empty, regex);
			
			if(input[0] != null) {
				toReturn = input[0];
				loopFlag = false;
			} else {
				System.out.println(input[1]);
			}
		}
		return toReturn;
	}
	
	public String[] userInputText(Integer length, Boolean empty, String regex) {
		String toReturn[] = new String[2]; 
		 toReturn[0] = null;
		 toReturn[1] = "Ha habido un error";
		
		String input = scanner.nextLine();
		
		boolean validated = false;
		
		if(length != null) {
			if(input.length() < length || input.length() == length) {
				validated = true;
			} else {
				validated = false;
				toReturn[1] = "El campo no acepta mas de " + length + " caracteres";
			}
		} else {
			validated = true;
		}
		
		if(empty != null) {
			if(!empty) {
				try{
					isEmpty(input);
					validated = true;
				} catch(Exception e) {
					validated = false;
					toReturn[1] = e.getMessage();
				}
			}
		}
		
		if(regex != null) {
			if(Pattern.matches(regex, input)) {
				validated = true;
			} else {
				validated = false;
				toReturn[1] = "No cumple el formato adecuado";
			}		
		}	
		
		if(validated) toReturn[0] = input;
		
		return toReturn;
	}
	
	public  boolean isEmpty(String str) throws Exception {
		if(str.equals("")) {
			throw new CannotBeEmptyException("El campo no puede estar vacío.");
		} else {
			return false;
		}
	}
	
	public Boolean userInputBooleanLoop(String msg) {
		Boolean toReturn = null;
		
		String input = userInputTextLoop(msg + "\nEscriba Y para Sí o N para No\\n  =>", 1, false, "[YN]");
		
		switch(input) {
		case "Y":
			toReturn = true;
			break;
		case "N":
			toReturn = false;
			break;
		}
		
		return toReturn;
	}
	
	public Integer userInputPositiveIntLoop(String msg) {
		Integer toReturn = null;
		Boolean loopFlag = true;
		while(loopFlag) {
			System.out.print(msg);
			Integer input = userInputPositiveInt();
			
			if(input != null) {
				toReturn = input;
				loopFlag = false;
			} else {
				System.out.println("Intente de nuevo.");
			}
		}
		
		return toReturn;
	}
	
	public Integer userInputPositiveInt() {
		Integer toReturn;
		
		String input = scanner.nextLine();
		
		try {
			toReturn = Integer.parseInt(input);
		} catch(NumberFormatException e) {
			toReturn = null;
		}
		
		boolean validateOptions = false;
		if(toReturn != null) {
			if(toReturn >= 0) {
				validateOptions = true;
			}
		}
		
		if(!validateOptions) toReturn = null;

		return toReturn;
	}
}
