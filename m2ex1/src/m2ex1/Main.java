package m2ex1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Iterator;

public class Main {
	public static void main(String args[]) {
		char[] myName = {'G', 'U', 'S', 'T', 'A', 'V', 'O', '+', '4', 'O'};
		
		for(int i = 0; i < myName.length; i++) {
			System.out.print(myName[i] + " ");
		}
		
		System.out.println("");
		
		List<Character> nameList = new ArrayList<Character>();
		
		for(int i = 0; i < myName.length; i++) {
			nameList.add(myName[i]);
			
			if(esVocal(myName[i])) {
				System.out.println("'" + myName[i] + "' " + "VOCAL");
			} else if(Character.isAlphabetic(myName[i])) {
				System.out.println("'" + myName[i] + "' " + "CONSONANTE");
			} else if(Character.isDigit(myName[i])) {
				System.out.println("'" + myName[i] + "' " + "Solo acepto numeros romanos ^^");
			} else if (myName[i] != ' '){
				System.out.println("'" + myName[i] + "' " + "Esto puede ocasionar errores, no conozco ese caracter");
			}
			
		}
		
		System.out.println(nameList);
		
		// Emmagatzemar en un Map tant les lletres de la llista com el nombre de vegades que apareixen.  
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		
		Iterator<Character> myNameIterator = nameList.iterator();
		
		while(myNameIterator.hasNext()) {
			Character c = myNameIterator.next();
			map.put(c, charVecesRepetido(nameList, c));
		}
		
		System.out.println(map);
		
		List<Character> surnameList = new ArrayList<Character>();
		surnameList.add('M');
		surnameList.add('A');
		surnameList.add('R');
		surnameList.add('T');
		surnameList.add('I');
		surnameList.add('N');
		surnameList.add('E');
		surnameList.add('Z');
		
		List<Character> fullList = new ArrayList<Character>();
		
		fullList.addAll(nameList);
		fullList.add(' ');
		fullList.addAll(surnameList);
		
		System.out.println(nameList);
		System.out.println(surnameList);
		System.out.println(fullList);
	}
	
	static boolean esVocal(char x) {
		if(x != 'a' && x != 'e' && x != 'i' && x != 'o' && x != 'u' &&
		   x != 'A' && x != 'E' && x != 'I' && x != 'O' && x != 'U' ) {
			
			return false;
			
		} else {
			return true;
		}
	}
	
	static int charVecesRepetido(List<Character> array, char x) {
		int res = 0;
		
		for(int i = 0; i < array.size(); i++) {
			if(array.get(i) == x) {
				res++;
			};
		}
		
		return res;
	}
}
