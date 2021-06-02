package com.vehicles.view;

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;

import com.vehicles.domain.Bike;
import com.vehicles.domain.Car;
import com.vehicles.domain.Conductor;
import com.vehicles.domain.Persona;
import com.vehicles.domain.TitularVehiculo;
import com.vehicles.domain.Truck;
import com.vehicles.domain.Vehicle;
import com.vehicles.domain.Wheel;
import com.vehicles.exceptions.DriverLicenseMismatchVehicleException;

public class Main {
	// Muchos métodos implementan Scanner.
	private static Scanner scanner = new Scanner(System.in);
	private static List<Persona> db_personas = new ArrayList<Persona>();
	private static List<Vehicle> db_vehiculos = new ArrayList<Vehicle>();
	
	
	public static void main(String[] args) {
		TitularVehiculo titular =  new TitularVehiculo("Gustavo", "", "Martinez", "Pintos", "00-00-0000","B","00-00-0000", true, true);
		Conductor conductor =  new Conductor("Gustavo", "", "Martinez", "Pintos", "00-00-0000","B","00-00-0000");
		Conductor conductor2 =  new Conductor("Gustavo", "", "Martinez", "Pintos", "00-00-0000","A","00-00-0000");
		
		db_personas.add(titular);
		db_personas.add(conductor);
		db_personas.add(conductor2);
		
		executeProgram();
		scanner.close();
	}
	
	// executeProgram
	private static void executeProgram() {
		printTitle();
		
		System.out.println("¿Qué desea hacer?");
		
		boolean loopFlag  = true;
		while(loopFlag) {
			Integer landingMenuOptionSelected = handlerLandingMenu();
			
			switch(landingMenuOptionSelected) {
			case 1:
				Integer createPersonaMenuOptionSelected = handlerCreatePersonaMenu();
				switch(createPersonaMenuOptionSelected) {
				case 1:
					Conductor conductor = createConductor();
					if(conductor != null) db_personas.add(conductor);
					break;
				case 2:
					TitularVehiculo titular = createTitular();
					if(titular != null) db_personas.add(titular);
					break;
				case 9:
					System.out.println("Saliendo");
					break;
				}
				break;
			case 2:
				Vehicle vehicle = createVehicle();
				if(vehicle != null) {
					db_vehiculos.add(vehicle);
					System.out.println(vehicle.toString());
				}
				
				break;
			case 9:
				System.out.println("Saliendo del programa.");
				loopFlag = false;
				break;
			default:
				System.out.println("Algo ha salido mal.");
				break;
			}
			
			if(loopFlag) System.out.println("¿Desea hacer otra cosa?");
		}

	}
	
	
	/*
	 * userInputText(Integer length, Boolean empty)
	 * length = maximo de caracteres o null;
	 * empty = false para que el campo no puede estar vacio, null o true para que si
	 * returns String[2]. posicion 1: texto correcto o nulo, posicion 2: mensaje de error
	 */
	private static String[] userInputText(Integer length, Boolean empty, String regex) {
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
				if(input.equals("")) {
					validated = false;
					toReturn[1] = "El campo no puede estar vacio";
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
	
	/*
	 * loopUserInputText(String msg, Integer length, Boolean empty)
	 * msg = string para presentar el campo a rellener
	 * length = maximo de caracteres o null;
	 * empty = false para que el campo no puede estar vacio, null o true para que si
	 * returns String[2]. posicion 1: texto correcto o nulo, posicion 2: mensaje de error
	 */
	private static String userInputTextLoop(String msg, Integer length, Boolean empty, String regex) {
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
	
	/*
	 * loopUserInputText(String msg)
	 * msg = string para presentar el campo a rellener
	 * returns boolean true or false
	 */
	private static Boolean userInputBooleanLoop(String msg) {
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
	
	/*
	 * userInputSelectMenuOption(int[] options)
	 * int[] options = array de opciones para verificar que sea una opcion del menu
	 * returns int = selected option
	 */
	private static Integer userInputSelectMenuOption(int[] options) {
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
	
	private static Integer userInputSelectID() {
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
	
	private static Persona userInputFindPersonaByIDLoop(Boolean titular) {
		Persona persona = null;
		Boolean loopFlag = true;
		while(loopFlag) {
			Integer id = userInputSelectID();
			try {
				persona = db_personas.get(id);
			} catch(IndexOutOfBoundsException e) {
				persona = null;
			} catch(NullPointerException e) {
				persona = null;
			}
			
			if(persona != null) {
				if(titular) {
					if(persona instanceof TitularVehiculo) {
						loopFlag = false;
					} else {
						System.out.println("Esta persona no es un titular");
						persona = null;
					}
				} else {
					persona = db_personas.get(id);
					loopFlag = false;
				}
			}
			
			if(loopFlag) System.out.println("Sin resultados, vuelva a intentarlo\n  => ");
		}
		
		return persona;
	}
	
	
	/* Handlers of the Menus */
	private static Integer handlerGenericMenu(String menu, int[] options) {
		Integer toReturnSelectedOption = null;
		
		boolean loopFlag = true;
		while(loopFlag) { 
			System.out.print(menu);
			toReturnSelectedOption = userInputSelectMenuOption(options);
			
			if(toReturnSelectedOption != null) {
				loopFlag = false;
			}
		}
		
		return toReturnSelectedOption;
	}
	
	private static Integer handlerCreatePersonaMenu() {
		String MENU = "    1. Crear un conductor\n"
				+ "    2. Crear un titular\n"
				+ "    9. Salir\n\n"
				+ "    =>  ";
		
		int[] OPTIONS = {1,2,9};
		
		return handlerGenericMenu(MENU, OPTIONS);
	}
	
	private static Integer handlerCreateVehicleMenu() {
		String MENU = "    1. Coche\n"
				+ "    2. Moto\n"
				+ "    3. Camion\n"
				+ "    9. Salir\n\n"
				+ "    =>  ";
		
		int[] OPTIONS = {1,2,3,9};
		
		return handlerGenericMenu(MENU, OPTIONS);
	}
	
	private static Integer handlerLandingMenu() {	
		String MENU = "1. Trabajar con Personas\n"
				+ "2. Trabajar con Vehiculos\n"
				+ "9. Salir\n\n"
				+ "=> ";
		
		int[] OPTIONS = {1, 2, 9};
		
		return handlerGenericMenu(MENU, OPTIONS);
	}
	
	private static Boolean dbPersonasHasTitular() {
		Boolean toReturn = false;
		for(int i = 0; i < db_personas.size(); i++) {
			if(db_personas.get(i) instanceof TitularVehiculo) {
				toReturn = true;
			}
		}
		return toReturn;
	}
	
	// create Vehicle, returns Vehicle created
	private static Vehicle createVehicle() {
		Vehicle toReturn = null;
		
		if(db_personas.size() <= 0) {
			System.out.println("No hay ninguna persona en la base de datos.");
			return null;
		} else if(!dbPersonasHasTitular()) {
			System.out.println("Es necesario que exista al menos un titular en la base de datos");
			return null;
		}
		
		System.out.println("\nPara crear un vehiculo es necesario primero añadir un titular.");
		System.out.print("Ingrese el ID del titular\n  => ");
			
		TitularVehiculo titular = (TitularVehiculo) userInputFindPersonaByIDLoop(true);
		
		// añadir ID titular al coche;
		
		System.out.println("\nSe procedera a la creación de un vehiculo.\n");
		System.out.println("Que tipo de vehiculo desea crear?");
		int selectedVehicleType = 0;
		Boolean loopFlag = true;
		while(loopFlag) {
			selectedVehicleType = handlerCreateVehicleMenu();
			
			if(selectedVehicleType == 9) {
				loopFlag = false;
				System.out.println("Saliendo del apartado.");
			} else {
				Boolean validateLicense = false;

				try {
					validateDriverLicense(titular.getTipoLicencia(), selectedVehicleType);
					validateLicense = true;
				} catch(DriverLicenseMismatchVehicleException e) {
					System.out.println(e.getMessage());
				}
				
				if(validateLicense) {
					String[] vehicleData = userInputVehicleData();
					
					switch(selectedVehicleType) {
					case 1:
						toReturn = createVehicleCar(vehicleData);
						loopFlag = false;
						break;
					case 2:
						toReturn = createVehicleBike(vehicleData);
						loopFlag = false;
						break;
					case 3:
						toReturn = createVehicleTruck(vehicleData);
						loopFlag = false;
					}
				} else {
					System.out.println("Desea cambiar el tipo de vehiculo que eligio o salir?");
				}		
			}
		}
		
		if(toReturn != null) {
			toReturn.setTitular(titular);
			
			Boolean loopFlag3 = true;
			while(loopFlag3) {
				if(userInputBooleanLoop("¿Desea añadir otro conductor?")) {
					System.out.print("\nIngrese el ID del conductor a asignar => ");
					Conductor conductor = (Conductor) userInputFindPersonaByIDLoop(false);
					
					if(conductor != null) {
						if(conductor.getTipoLicencia().equals(toReturn.getTipoLicencia())) {
							if(!titular.getID().equals(conductor.getID())) {
								if(toReturn.isConductorAlready(conductor.getID())) {
									System.out.println("Ese conductor ya esta asignado a este coche");
								} else {
									toReturn.addConductor(conductor);
									System.out.println("Se añadio el conductor");
								}
							} else {
								System.out.println("Este conductor es el mismo titular, no se puede añadir");
							}
						} else {
							System.out.println("Las licencias no concuerdan");
						}
					}
					
				} else {
					loopFlag3 = false;
				}
			}
		}
		
		return toReturn;

	}
	
	private static void validateDriverLicense(String driverLicense, int vehicleType) throws DriverLicenseMismatchVehicleException {
		Boolean validated = false;
		
		String okLicense = "";
		
		switch(vehicleType) {
		case 1:
			okLicense = Car.staticGetTipoLicencia();
			break;
		case 2:
			okLicense = Bike.staticGetTipoLicencia();
			break;
		case 3:
			okLicense = Truck.staticGetTipoLicencia();
			break;
		}
		
		if(driverLicense.equals(okLicense)) validated = true;
		
		
		if(!validated) throw new DriverLicenseMismatchVehicleException("La licencia del conductor (" + driverLicense + ") no concuerda con la licencia necesaria para el vehiculo (" + okLicense + ")");
	}
	

	
	private static Conductor createSecondDriver(int vehicleType) {
		Conductor conductor = null;
		
		boolean loopFlag = true;
		boolean validateLicense = false;
		
		while(loopFlag) {
			System.out.println("Inserte los datos del segundo conductor");
			conductor = createConductor();
			
			try {
				validateDriverLicense(conductor.getTipoLicencia(), vehicleType);
				validateLicense = true;
			} catch(DriverLicenseMismatchVehicleException e) {
				System.out.println(e.getMessage());
			}
			
			if(!validateLicense) {
				conductor = null;
			}
			
			if(conductor != null) {
				loopFlag = false;
			} else if(!userInputBooleanLoop("¿Desea volver a intentarlo?")){
				conductor = null;
				loopFlag = false;
			}
		}
		
		return conductor;
		
	}
	
	private static Conductor createSecondDriverHandler(int vehicleType) {
		Conductor conductor = null;
		boolean loopFlag2 = true;
		while(loopFlag2) {
			boolean flagSecondDriver = userInputBooleanLoop("El titular tambien sera conductor?");
			
			if(flagSecondDriver) {
				loopFlag2 = false;
			} else {
				conductor = createSecondDriver(vehicleType);
				if(conductor != null) {
					System.out.println(conductor.toString());
					loopFlag2 = false;
				} else {
					System.out.println("No se creo el segundo conductor");
				}
			}
		}
		
		return conductor;
	}
	
	private static Vehicle createVehicleCar(String[] vehicleData) {
		Car car = new Car(vehicleData[0], vehicleData[1], vehicleData[2]);
		
		boolean loopFlag = true;
		System.out.println("Procedera a añadir las ruedas del coche.");
		while(loopFlag) {
			List<Wheel> ruedas = createTwoSameWheelsPack("delantera izquierda", "delantera derecha");
			List<Wheel> ruedas2 = null;
			
			if(userInputBooleanLoop("Desea que el resto de las ruedas sean iguales?:")) {
				ruedas2 = ruedas;
			} else {
				ruedas2 = createTwoSameWheelsPack("trasera izquierda", "trasera derecha");
			}

			try {
				car.addWheels(ruedas, ruedas2);
				loopFlag = false;
			} catch(Exception e) {
				System.out.println(e.getMessage());
			}
			
			if(loopFlag) System.out.println("Intentelo otra vez");
		}
		
		return car;
	}
	
	private static Vehicle createVehicleTruck(String[] vehicleData) {
		Truck truck = new Truck(vehicleData[0], vehicleData[1], vehicleData[2]);
		
		boolean loopFlag = true;
		System.out.println("Procedera a añadir las ruedas del camion.");
		while(loopFlag) {
			List<Wheel> ruedas = createTwoSameWheelsPack("delantera izquierda", "delantera derecha");
			List<Wheel> ruedas2 = null;
			List<Wheel> ruedas3 = null;
			
			if(userInputBooleanLoop("Desea que el resto de las ruedas sean iguales?:")) {
				ruedas2 = ruedas;
				ruedas3 = ruedas;
			} else {
				System.out.println("Creando ruedas centrales");
				ruedas2 = createTwoSameWheelsPack("centro izquierda", "centro derecha");
				
				if(userInputBooleanLoop("Desea que el resto de las ruedas sean iguales?:")) {
					ruedas3 = ruedas2;
				} else {
					ruedas3 = createTwoSameWheelsPack("trasera izquierda", "trasera derecha"); 
				}
			}

			try {
				truck.addWheels(ruedas, ruedas2, ruedas3);
				loopFlag = false;
			} catch(Exception e) {
				System.out.println(e.getMessage());
			}
			
			if(loopFlag) System.out.println("Intentelo otra vez");
		}
		
		return truck;
	}
	
	private static Vehicle createVehicleBike(String[] vehicleData) {
		Bike bike = new Bike(vehicleData[0], vehicleData[1], vehicleData[2]);
		
		boolean loopFlag = true;
		System.out.println("Procedera a añadir las ruedas de la moto.");
		while(loopFlag) {
			List<Wheel> ruedas = createTwoSameWheelsPack("delantera", "trasera");
			
			try {
				bike.addWheels(ruedas);
				loopFlag = false;
			} catch(Exception e) {
				System.out.println(e.getMessage());
			}
			
			if(loopFlag) System.out.println("Intentelo otra vez");
		}
		
		return bike;
	}
	
	// Crear Wheel
	private static Wheel createWheel(String wheelPosition) {
		System.out.println("Ingrese los datos para rueda " + wheelPosition);
		
		String[] aux = userInputWheelData();

		Wheel wheel = new Wheel(aux[0], Double.parseDouble(aux[1]));
		
		return wheel;
	}
	
	private static List<Wheel> createTwoSameWheelsPack(String wheelPosition, String wheelPosition2) {
		List<Wheel> twoWheels = new ArrayList<Wheel>();
		
		Wheel leftWheel = createWheel(wheelPosition);
		
		System.out.println("La rueda " + wheelPosition2 + " ha de ser igual a la anterior.\nCopiando datos.");
		Wheel rightWheel = leftWheel;
		
		twoWheels.add(leftWheel);
		twoWheels.add(rightWheel);
		
		return twoWheels;
		
	}
	
	// devuelve un string de dos posicions con la marca y el diametro
	private static String[] userInputWheelData() {		
		String brand = userInputTextLoop("\nIngresa la marca de la rueda:\n  => ", 16, false, null);		
		
		boolean validateDiameter = true;
		Double diam = 0.0;
		
		while(validateDiameter) {
			String diameter = userInputTextLoop("\nIngresa el diametro de la rueda:\n  => ", 16, false, null);
			
			try {
				diam = Double.parseDouble(diameter);
				
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
		
		String[] toReturn = {brand, diam.toString()};
		
		return toReturn; 
	}

	// devuelve un string de tres posiciones con la matricula, la marca y el color	
	private static String[] userInputVehicleData() {
		
		String plate = userInputTextLoop("\nIngresa la matricula del vehiculo:\\n  Formato: 1234ABC o 1234AB\\n  => ", 7, false, "^[1-9]{1,4}[A-Z]{2,3}$");
		
		String brand = userInputTextLoop("\nIngresa la marca del vehiculo:\n  => ", 16, false, null);
		
		String color = userInputTextLoop("\nIngresa el color del vehiculo:\n  => ", 16, false, null);
		
		String[] toReturn = {plate, brand, color};
		
		return toReturn;
	}
	
	private static String[] askUserDataConductor() {
		String[] toReturn = new String[7];
		toReturn[0] = userInputTextLoop("Ingresa el nombre: (*)\n  =>", 14, false, null);
		toReturn[1] = userInputTextLoop("Ingresa el segundo nombre: ()\n  =>", 14, true, null);
		toReturn[2] = userInputTextLoop("Ingresa el primer apellido: (*)\n   =>", 14, false, null);
		toReturn[3] = userInputTextLoop("Ingresa el segundo apellido: (*)\n   =>", 14, false, null);
		
		// faltaria loopUserInputDate
		toReturn[4] = userInputTextLoop("Ingresa la fecha de nacimiento con formato dd-mm-aaaa: (*)\n  =>", 10, false, "^\\d{2}[-]\\d{2}[-]\\d{4}$");
		
		toReturn[5] = userInputTextLoop("Ingresa el tipo de licencia (solo acepta A, B o C): (*)\n  =>", 1, false, "[ABC]");
		
		toReturn[6] = userInputTextLoop("Ingresa la fecha de caducidad de la licencia: (*)\n  =>", 10, false, "^\\d{2}[-]\\d{2}[-]\\d{4}$");
		
		return toReturn;
	}
	
	private static String[] askUserTitularData() {
		String[] toReturn = new String[9];
		
		String[] conductorData = askUserDataConductor();
		
		for(int i = 0; i < conductorData.length; i++) {
			toReturn[i] = conductorData[i];
		}
		
		toReturn[7] = Boolean.toString(userInputBooleanLoop("Dispone de seguro: (*)"));
		toReturn[8] = Boolean.toString(userInputBooleanLoop("\"Dispone de garage: (*)"));
		
		return toReturn;
	}
	
	private static TitularVehiculo createTitular() {
		String[] data = askUserTitularData();
		
		TitularVehiculo titular = new TitularVehiculo(data[0], data[1], data[2], data[3],
				data[4],data[5],data[6],Boolean.parseBoolean(data[7]),Boolean.parseBoolean(data[8]));
		
		return titular;
	}
	
	private static Conductor createConductor() {
		String[] data = askUserDataConductor();
		
		Conductor conductor = new Conductor(data[0], data[1], data[2], data[3],
				data[4],data[5],data[6]);
		
		return conductor;
		
	}
	
	// PRINTING FUNCTIONS
	private static void printTitle() {
		System.out.println("==============================\n" +
				   "   Taller de Motos y Coches\n" +
				   "==============================\n");
	}
	
	private static void showInputMismatchMessage() {
		System.out.println("\n  [ERROR] No conozco esa opción, vuelva a intentarlo.\n");
	}
	
	
	private static void showInputWrongFormatMessage() {
		System.out.println("\n  [ERROR] El formato del texto o el texto no son correctos.");
	}


}

