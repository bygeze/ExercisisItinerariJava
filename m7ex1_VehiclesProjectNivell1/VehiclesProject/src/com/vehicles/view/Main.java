package com.vehicles.view;

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;

import com.vehicles.domain.Bike;
import com.vehicles.domain.Car;
import com.vehicles.domain.Vehicle;
import com.vehicles.domain.Wheel;

public class Main {
	// scanner disponible para todos los metodos del main
	private static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		// funcion que ejecuta todo el codigo
		executeProgram();
		
		// cerrar el scanner
		scanner.close();
	}
	
	// método que ejecuta el programa
	private static void executeProgram() {
		// imprimir el titulo
		printTitle();		
		
		// ejecutar el menu principal
		executeLandingMenu();
	}
	
	// metodo que ejecuta el menu principal
	private static void executeLandingMenu() {
		// loop flag
		boolean executeLandingMenu = true; 
		
		System.out.println("  ¿Qué desea hacer?");
		while(executeLandingMenu) { 
			// imprimir el menu
			printLandingMenu(); 
			
			// input del usuario
			int selected = 0;
			String input = scanner.nextLine();
			
			// convertir la entrada a un numero
			try {
				selected = Integer.parseInt(input);	
			} catch(Exception e) {
				// salto la excepcion porque se gestiona luego con el switch
			}
			
			// switch para elegir si salir del programa o crear un vehiculo
			switch(selected) {
			// crear vehiculo
			case 1:
				// la funcion executecreatevehicle devuelve
				// nulo si no se ha podido crear el vehiculo
				// un objeto vacio cuando se ejecuta salir del menu
				// y un objeto que es instancia de la clase vehiculo si todo ha ido bien
				// seria el vehiculo que se acaba de crear par asu posterior manejo
				Object obj = executeCreateVehicle();
				
				if(obj == null) {
					System.out.println("\n  [ERROR] Algo ha salido mal.\n");
				} else if(obj instanceof Vehicle) {
					System.out.println("\n  [INFO]  Se creo el vehiculo correctamente.\n");
				}
				
				// imprimir el vehiculo
				System.out.println();
				System.out.println(obj.toString());
				// QUE HAGO CON EL VEHICULO??
				
				System.out.println("  ¿Desea hacer otra cosa?");
				break;
			case 9:
				System.out.println("\n  [INFO] Saliendo de la aplicación.");
				executeLandingMenu = false;
				break;
			default:
				showInputMismatchMessage();
				break;
			}
			
		}
	}
	
	// Create Vehicle Functionality
	private static Object executeCreateVehicle() {
		System.out.println("\n  [INFO] Se procedera a la creación de un vehiculo.\n");
		System.out.println("  Que tipo de vehiculo desea crear?");
		
		// para el input del usuario sobre el tipo de vehiculo
		int selectedVehicle = 0;
		
		// flag loop de pregunta
		boolean executeSelectVehicleMenu = true;
		
		// menu del tipo del vehiculo
		while(executeSelectVehicleMenu) {
			printSelectVehicleMenu();
			// input del usuario y conversion
			String input = scanner.nextLine();
			
			try {
				selectedVehicle = Integer.parseInt(input);
			} catch(Exception e) {
				// number format exceiption actually
				//selectedVehicle = 0;
				// se gestiona con el switch
			}
			
			switch(selectedVehicle) {
			case 1: 
				// crear vehiculo de tipo coche
				//executeSelectVehicleMenu = false;
				return createVehicleCar();
			case 2:
				//executeSelectVehicleMenu = false;
				return createVehicleBike();
			case 9:
				//executeSelectVehicleMenu = false;
				return new Object();
			default: 
				showInputMismatchMessage();
				break;
			}
			
		}
		
		return null;

	}
	
	// Crear vehiculos de un tipo
	private static Vehicle createVehicleCar() {
		
		// retrieve car data and create car
		String[] vehicleData = retrieveVehicleData();
		
		Car car = new Car(vehicleData[0], vehicleData[1], vehicleData[2]);
		
		// retrieve wheels data
		System.out.println("\n  Ingrese la información de la rueda delantera izquierda");
		Wheel frontLeftWheel = createWheel();
		System.out.println("\n  Ingrese la información de la rueda delantera derecha");
		Wheel frontRightWheel = createWheel();
		System.out.println("\n  Ingrese la información de la rueda trasera izquierda");
		Wheel backLeftWheel = createWheel();
		System.out.println("\n  Ingrese la información de la rueda trasera derecha");
		Wheel backRightWheel = createWheel();
		
		// add wheel data to the car
		List<Wheel> frontWheels = new ArrayList<Wheel>();
		frontWheels.add(frontLeftWheel);
		frontWheels.add(frontRightWheel);
		
		List<Wheel> backWheels = new ArrayList<Wheel>();
		backWheels.add(backLeftWheel);
		backWheels.add(backRightWheel);
		
		try {
			car.addWheels(frontWheels, backWheels);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return car;
	}
	
	private static Vehicle createVehicleBike() {
		
		String[] vehicleData = retrieveVehicleData();
		
		Bike bike = new Bike(vehicleData[0], vehicleData[1], vehicleData[2]);
		
		System.out.println("\n  Ingrese la información de la rueda delantera");
		Wheel frontWheel = createWheel();
		System.out.println("\n  Ingrese la información de la rueda trasera");
		Wheel backWheel = createWheel();
		
		bike.addWheels(frontWheel, backWheel);
		
		return bike;
	}
	
	// crear ruedas
	private static Wheel createWheel() {
		
		String[] aux = retrieveWheelData();
		
		Double diameter = 0.0;
		
		try {
			diameter = Double.parseDouble(aux[1]);
		} catch(Exception e) {
			// podria gestionarla pero estoy seguro que lo que vuelve es un double
		}

		Wheel wheel = new Wheel(aux[0], diameter);
		
		return wheel;
		
		
	}
	
	// devuelve un string de dos posicions con la marca y el diametro
	private static String[] retrieveWheelData() {
		// add brand and validate		
		boolean validateBrand = true;
		String brand = "";
		while(validateBrand) {
			System.out.print("\n  Ingresa la marca de la rueda:\n  => ");
			brand = scanner.nextLine();
			
			if(brand.equals("")) {
				showInputEmptyMessage();
			} else {
				validateBrand = false;
			}
		}
		
		boolean validateDiameter = true;
		String s_diam = "";
		Double diam = 0.0;
		
		while(validateDiameter) {
			System.out.print("\n  Ingresa el diametro de la rueda:\n  => ");
			s_diam = scanner.nextLine();
			
			if(s_diam.equals("")) {
				showInputEmptyMessage();
			} else {
				try {
					diam = Double.parseDouble(s_diam);
					// validar que este entre 0.4 y 4
					if(diam > 0.4 && diam < 4) {
						validateDiameter = false;
					} else {
						showInputWrongFormatMessage();
					}
				} catch(Exception e) {
					showInputMismatchMessage();
				}
			}
		}
		
		String[] toReturn = {brand, diam.toString()};
		
		return toReturn; 
	}
	
	// devuelve un string de tres posiciones con la matricula, la marca y el color	
	private static String[] retrieveVehicleData() {
		
		// add plate and validate
		boolean validatePlate = true;
		String plate = "";
		while(validatePlate) {
			System.out.print("\n  Ingresa la matricula del vehiculo:\n  Formato: 1234ABC o 1234AB\n  => ");
			plate = scanner.nextLine();
			
			if(Pattern.matches("\\d{4,4}\\w{2,3}", plate)) {
				validatePlate = false;
			} else {
				showInputWrongFormatMessage();
			}
		}
		
		// add brand and validate		
		boolean validateBrand = true;
		String brand = "";
		while(validateBrand) {
			System.out.print("\n  Ingresa la marca del vehiculo:\n  => ");
			brand = scanner.nextLine();
			
			if(brand.equals("")) {
				showInputEmptyMessage();
			} else {
				validateBrand = false;
			}
		}
		
		boolean validateColor = true;
		String color = "";
		while(validateColor) {
			System.out.print("\n  Ingresa el color del vehiculo:\n  => ");
			color = scanner.nextLine();
			
			if(color.equals("")) {
				showInputEmptyMessage();
			} else {
				validateColor = false;
			}
		}
		
		String[] toReturn = {plate, brand, color};
		return toReturn;
	}
	
	
	// Printing functions
	private static void printTitle() {
		System.out.println("==============================\n" +
				   "   Taller de Motos y Coches\n" +
				   "==============================\n");
	}
	
	private static void printLandingMenu() {
		String menu = "    1. Crear un vehiculo\n"
					+ "    9. Salir\n\n"
					+ "    =>  ";
		
		System.out.print(menu);
	}
	
	private static void printSelectVehicleMenu() {
		String menu = "    1. Coche\n"
					+ "    2. Moto\n"
					+ "    9. Salir\n\n"
					+ "    =>  ";
		
		System.out.print(menu);
	}
	
	private static void showInputMismatchMessage() {
		System.out.println("\n  [ERROR] No conozco esa opción, vuelva a intentarlo.\n");
	}
	
	private static void showInputEmptyMessage() {
		System.out.println("\n  [ERROR] Este campo no puede estar vacio.");
	}
	
	private static void showInputWrongFormatMessage() {
		System.out.println("\n  [ERROR] El formato del texto o el texto no son correctos.");
	}
	
	/* Implementacion que al final no use
	private static boolean showDataRiskInExitDialog() {
		System.out.println("\n  [WARN] Si sale ahora se perderan todos los ratos introducidos hasta el momento.");
		
		System.out.println("  [WARN] Seguro que desea continuar?"
						 + "\n         Escriba Y para Si y N para No\n\n    =>");
		
		boolean allowExitLoop = true;
		String input = "N";
		while(allowExitLoop) {
			input = scanner.nextLine();
			
			switch(input) {
				case "Y":
					allowExitLoop = false;
					break;
				case "N":
					allowExitLoop = false;
					break;
				default:
					showInputMismatchMessage();
					break;
			}
		}
		
		if(input == "Y") {
			return true;
		} else {
			return false;
		}
	}*/

}

