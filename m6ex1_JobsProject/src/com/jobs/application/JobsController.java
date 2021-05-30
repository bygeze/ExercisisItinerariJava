package com.jobs.application;

import com.jobs.domain.Employee;
import com.jobs.domain.AbsStaffMember;
import com.jobs.domain.Volunteer;
import com.jobs.persistence.EmployeeRepository;

public class JobsController {

	private EmployeeRepository repository = new EmployeeRepository();
	
	public JobsController(){
		
	}
	
	public void createBossEmployee(String name, String address, String phone, double salaryPerMonth) throws Exception{		
		Employee boss = new Employee(name, address, phone,  salaryPerMonth, PaymentFactory.createPaymentRateBoss());
		repository.addMember(boss);
	}
	
	public void createManagerEmployee(String name, String address, String phone, double salaryPerMonth) throws Exception{
		Employee manager = new Employee(name, address, phone,  salaryPerMonth, PaymentFactory.createPaymentRateManager());
		repository.addMember(manager);
		
	}
	
	public void createEmployee(String name, String address, String phone, double salaryPerMonth) throws Exception{		
		Employee employee = new Employee(name, address, phone,  salaryPerMonth, PaymentFactory.createPaymentRateEmployee());
		repository.addMember(employee);
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

	public void createVolunteer(String name, String address, String phone) throws Exception {
		Volunteer volunteer = new Volunteer(name, address, phone, "No cobra");
		
		repository.addMember(volunteer);
		
	}
	
	
	
}
