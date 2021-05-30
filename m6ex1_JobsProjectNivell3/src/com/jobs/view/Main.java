package com.jobs.view;

import com.jobs.application.JobsController;


public class Main {
	
	private static JobsController controller=new JobsController();
	
	public static void main(String[] args) throws Exception {
		
		
		controller.createVolunteer("Juan Volunteer", "Dirección molona 4", "614266666");
		controller.createEmployee("Laura Employee", "Dirección molona 3", "625266666", 1200.0);
		controller.createJuniorEmployee("Jose Junior", "Calle Falsa 123", "666777888", 1200.0);
		controller.createMidEmployee("Jose Mid", "Calle Falsa 123", "666777888", 2200.0);
		controller.createSeniorEmployee("Jose Senior", "Calle Falsa 123", "666777888", 3500.0);
		controller.createManagerEmployee("Jose Manager", "Calle Falsa 123", "666777888", 4500.0);
		controller.createBossEmployee("Jose Boss", "Calle Falsa 123", "666777888", 9000.0);
		controller.createVolunteer("Juan Volunteer", "Dirección molona 4", "614266666", 300.0);

		
		controller.payAllEmployeers();
		controller.emitYearBonusToAll(0.10);
		
		String allEmployees=controller.getAllEmployees();
		
		System.out.println("EMPLOYEES: \n" + allEmployees);
		
	}

}

// el ajut s'indica com a social payment'