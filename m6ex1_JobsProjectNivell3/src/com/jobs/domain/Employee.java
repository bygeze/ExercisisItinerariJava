package com.jobs.domain;

public class Employee extends AbsStaffMember {

	protected double baseSalaryMonth;
	protected double grossSalaryMonth;
	protected double netSalaryMonth;
	protected IPaymentRate paymentRate;
	protected double bonus;

	public Employee(String name, String address, String phone, double baseSalaryMonth,IPaymentRate paymentRate) throws Exception {
		super(name, address, phone);		
		if(grossSalaryMonth<0) throw new Exception();
		if(paymentRate==null) throw new Exception();
				
		this.baseSalaryMonth=baseSalaryMonth;
		this.paymentRate=paymentRate;
		
		this.pay();
		this.payTaxes();
		this.totalPaid = this.netSalaryMonth;
		this.bonus = 0;
	}

	@Override
	public void pay() {
		this.grossSalaryMonth=paymentRate.pay(baseSalaryMonth);
	}
	
	@Override
	public void payTaxes() {
		this.netSalaryMonth=paymentRate.payTaxes(grossSalaryMonth);
	}
	
	public double getGrossSalaryMonth() {
		return this.grossSalaryMonth;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String msg = "Emp \n"
		+ "  [name="+this.name + ",\n"
		+ "   address="+this.address+",\n"
		+ "   phone="+this.phone+",\n"
		+ "   baseSalaryMonth="+this.baseSalaryMonth+",\n"
		+ "   grossSalaryMonth="+this.grossSalaryMonth+",\n"
		+ "   netSalaryMonth="+this.netSalaryMonth+",\n"
		+ "   grossSalaryYear="+getGrossSalaryYear()+",\n"
		+ "   netSalaryYear="+getNetSalaryYear();
		
		if(bonus > 0) {
			msg += ",\n"
					+ "   yearBonus="+this.bonus+"]";
		} else {
			msg+="]";
		}
		
		return msg;
	}

	public double getGrossSalaryYear() {
		// TODO Auto-generated method stub
		return this.grossSalaryMonth * 12;
	}
	
	public double getNetSalaryYear() {
		return this.netSalaryMonth * 12;
	}

	@Override
	public double getTotalPaid() {
		// TODO Auto-generated method stub
		return this.netSalaryMonth;
	}
	
	public void yearBonus(double RATE) {
		this.bonus = this.getNetSalaryYear() * RATE;
	}
	
	public double getBonus() {
		return this.bonus;
	}

}
