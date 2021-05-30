package com.jobs.application;

import com.jobs.domain.*;
import com.jobs.persistence.EmployeeRepository;
import com.jobs.excepcions.*;

public class JobsController {

	private EmployeeRepository repository = new EmployeeRepository();
	
	public JobsController(){
		
	}
	
	
	// BOSS EMPLOYEE / CREATE
	public void createBossEmployee(String name, String address, String phone, double salaryPerMonth) throws Exception{		
		Employee boss = new BossEmployee(name, address, phone,  salaryPerMonth, PaymentFactory.createPaymentRateBoss());
		if(boss.getTotalPaid() < 8000) throw new SalaryOutOfBoundsException();
		repository.addMember(boss);
	}
	
	// MANAGER EMPLOYEE / CREATE
	public void createManagerEmployee(String name, String address, String phone, double salaryPerMonth) throws Exception{
		Employee manager = new ManagerEmployee(name, address, phone,  salaryPerMonth, PaymentFactory.createPaymentRateManager());
		if(manager.getTotalPaid() < 3000 || manager.getTotalPaid() > 5000) throw new SalaryOutOfBoundsException();
		repository.addMember(manager);
		
	}
	
	// REGULAR EMPLOYEE / CREATE
	public void createEmployee(String name, String address, String phone, double salaryPerMonth) throws Exception{		
		Employee employee = new Employee(name, address, phone,  salaryPerMonth, PaymentFactory.createPaymentRateEmployee());
		if(employee.getTotalPaid() < 900 || employee.getTotalPaid() > 1600) throw new SalaryOutOfBoundsException();
		repository.addMember(employee);
	}
	
	// JUNIOR EMPLOYEE / CREATE
	public void createJuniorEmployee(String name, String address, String phone, double salaryPerMonth) throws Exception {
		Employee junior = new JuniorEmployee(name, address, phone, salaryPerMonth, PaymentFactory.createPaymentRateJuniorEmployee());
		// podria implementar las constantes en las clases y usar algo como getMin and getMax Salary
		if(junior.getTotalPaid() < 900 || junior.getTotalPaid() > 1600) throw new SalaryOutOfBoundsException();
		repository.addMember(junior);
	}
	
	// MID EMPLOYEE / CREATE
	public void createMidEmployee(String name, String address, String phone, double salaryPerMonth) throws Exception {
		Employee mid = new MidEmployee(name, address, phone, salaryPerMonth, PaymentFactory.createPaymentRateMidEmployee());
		// podria implementar las constantes en las clases y usar algo como getMin and getMax Salary
		if(mid.getTotalPaid() < 1800 || mid.getTotalPaid() > 2500) throw new SalaryOutOfBoundsException();
		repository.addMember(mid);
	}
	
	
	// SENIOR EMPLOYEE / CREATE
	public void createSeniorEmployee(String name, String address, String phone, double salaryPerMonth) throws Exception {
		Employee senior = new SeniorEmployee(name, address, phone, salaryPerMonth, PaymentFactory.createPaymentRateSeniorEmployee());
		// podria implementar las constantes en las clases y usar algo como getMin and getMax Salary
		if(senior.getTotalPaid() < 2700 || senior.getTotalPaid() > 4000) throw new SalaryOutOfBoundsException();
		repository.addMember(senior);
	}
	
	
	
	// VOLUNTEER / CREATE
	public void createVolunteer(String name, String address, String phone) throws Exception {
		Volunteer volunteer = new Volunteer(name, address, phone, "No cobra");
		if(volunteer.getTotalPaid() != 0) throw new SalaryOutOfBoundsException();
		repository.addMember(volunteer);
	}

	public void payAllEmployeers() {
		// TODO Auto-generated method stub
		for(int i = 0; i < repository.getAllMembers().size(); i++) {
			repository.getMember(i).pay();
		}
	
	}

	public String getAllEmployees() {
		// TODO Auto-generated method stub
		
		String response = "";
		
		for(int i = 0; i < repository.getAllMembers().size(); i++) {
			response += repository.getMember(i) + "\n";
		}
		
		return response;
	}


	
	
	
}
