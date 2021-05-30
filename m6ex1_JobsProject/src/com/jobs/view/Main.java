package com.jobs.view;

import com.jobs.application.JobsController;


public class Main {

	
	
	private static JobsController controller=new JobsController();
	
	public static void main(String[] args) throws Exception {
		

		
		controller.createBossEmployee("Pepe Boss", "Dirección molona", "666666666", 100.0);
		controller.createEmployee("Pedro Employee", "Dirección molona 2", "665266666", 40.0);
		controller.createEmployee("Laura Employee", "Dirección molona 3", "625266666", 45.0);
		controller.createVolunteer("Juan Volunteer", "Dirección molona 4", "614266666");
		controller.createManagerEmployee("Pedro Employee", "Dirección molona 2", "665226666", 80.0);
		
		
		controller.payAllEmployeers();
		
		String allEmployees=controller.getAllEmployees();
		
		System.out.println("EMPLOYEES: \n" + allEmployees);
		
	}

}


// PASO 1: Ejecutar el programa
// PASO 2: Comentar las lineas de createBossEmployee, createEmployee, porque asi se ejecuta al menos.
// PASO 3: Noto que crearVoluntario no hace nada porque no se imprime ningun voluntario
// PASO 4: Reviso el controlador, veo que en ningun momento se a�ade al repositorio, asi que lo programo.
// PASO 5: Rayarme pila porque el repositorio no estaba inicializado
// PASO 6: Ahora a�ado el voluntario para empezar, refactorize los campos en el controlador y lo a�ado a la db
		// Le creo el el atributo description
		// le sobresescribo el metodo to string

// PASO 7: Creo que el metodo getAllEmployes

// PASO 8: Me costo un poco entender lo de la interfaz de IPaymentRate pero al final lo pille
// le hice un peque�o tweak a�adiendo constantes

