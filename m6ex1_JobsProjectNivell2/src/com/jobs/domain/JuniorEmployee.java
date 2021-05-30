package com.jobs.domain;

public class JuniorEmployee extends Employee {

	public JuniorEmployee(String name, String address, String phone, double salaryPerMonth, IPaymentRate paymentRate)
			throws Exception {
		super(name, address, phone, salaryPerMonth, paymentRate);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "Emp Junior [name=" + this.name + ", address="+this.address+", phone="+this.phone+", salaryPerMonth=" + this.salaryPerMonth + ", totalPaid="+this.totalPaid+"]";
	}
	
}
