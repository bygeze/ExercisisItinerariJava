package m4ex3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// EJERCICIO RESTAURANT
		
		/*
		 * FASE (1)
		 */
		
		// Creeu una variable int per cada un dels bitllets que existeixen des de 5€ a 500€.
		int BILLETECINCO = 5;
		int BILLETEDIEZ = 10;
		int BILLETEVEINTE = 20;
		int B_CINCUENTA = 50;
		int B_CIEN = 100;
		int B_DOSCIENTOS = 200;
		int B_QUINIENTOS = 500;
		
		// haureu de crear un altre variable per guardar el preu total del menjar.  
		int sumaTotalPedido;
		
		// Creeu dos arrays, un on guardarem el menú i un altre on guardarem el preu de cada plat.
		String plats[] = new String[10];
		int preus[] = new int[10];
		
		// FASE (2)
		
		// Pots fer us de diccionaris de dades(Java HasMap).
		Map<String, Integer> preuPlat = new HashMap<String, Integer>();
		preuPlat.put("Bufalina", 12);
		preuPlat.put("4 Formaggi", 12);
		preuPlat.put("Pino Daniele", 18);
		preuPlat.put("Margherita", 9);
		preuPlat.put("Prosciuto", 10);
		preuPlat.put("Parmiggiana", 11);
		preuPlat.put("Al Tonno", 13);
		preuPlat.put("Carbonara", 11);
		preuPlat.put("Massimo Troise", 18);
		preuPlat.put("Ortolana", 12);
		
		// Amb un bucle for haurem d’omplir els dos arrays anteriorment creats. Afegirem el nom del plat i després el preu. 	
		int contador = 0;
		for(Map.Entry<String, Integer> entry : preuPlat.entrySet()) {
			//entry.
			plats[contador] = entry.getKey();
			preus[contador] = entry.getValue();
			contador++;
		}
		
		//Un cop plens els dos arrays haurem de mostrar-los 
		System.out.println("    Menu\n===========");
		for(int i = 0; i < plats.length; i++) {
			System.out.println(" " + i + ". " + plats[i] + " / " + preus[i] + "€");
		}
		
		
		// i preguntar que es vol per menjar, guardarem la informació en una List fent servir un bucle while. 
		
		List<Integer> pedido = new ArrayList<Integer>();
		
		boolean flagPedido = true;
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("\nEl pedido se realiza introduciendo los números de los platos:");
		
		do {
			System.out.println("Introduzca un número (o cualquier otro caracter para terminar el pedido)");
			try {
				int input = scanner.nextInt();
				try {
					addPlato(input, plats, pedido);
					System.out.println("Plato añadido: " + plats[input]);
				} catch (platoNoExistente e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch(InputMismatchException e) {
				System.out.println("Dado que no has escrito un número entiendo que has acabado.");
				flagPedido = false;
			}
		} while(flagPedido);
	
			
		
	}
	
	static void addPlato(int i, String[] platos, List<Integer> pedido) throws platoNoExistente {
		if(i > platos.length - 1 || i < 0) {
			throw new platoNoExistente("El plato no existe");
		} else {
			pedido.add(i);
		}
	}

}

class platoNoExistente extends Exception {
	
	public platoNoExistente() {}
	
	public platoNoExistente(String e_msg) {
		super(e_msg);
		
	}
	
}