package com.jobs.domain;

public class MidEmployee extends Employee {
	public MidEmployee(String name, String address, String phone, double salaryPerMonth, IPaymentRate paymentRate)
			throws Exception {
		super(name, address, phone, salaryPerMonth, paymentRate);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		String msg =  "Emp Mid \n"
		+ "  [name="+this.name + ",\n"
		+ "   address="+this.address+",\n"
		+ "   phone="+this.phone+",\n"
		+ "   baseSalaryMonth="+this.baseSalaryMonth+",\n"
		+ "   grossSalaryMonth="+this.grossSalaryMonth+"\n"
		+ "   netSalaryMonth="+this.netSalaryMonth+"\n"
		+ "   grossSalaryYear="+getGrossSalaryYear()+"\n"
		+ "   netSalaryYear="+getNetSalaryYear();
		
		if(bonus > 0) {
			msg += ",\n"
					+ "   yearBonus="+this.bonus+"]";
		} else {
			msg+="]";
		}
		
		return msg;
	}
}