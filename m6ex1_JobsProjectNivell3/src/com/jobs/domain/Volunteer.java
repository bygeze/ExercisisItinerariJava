package com.jobs.domain;

public class Volunteer extends AbsStaffMember {
	protected boolean socialPayment;
	
	protected String description;

	public Volunteer(String name, String address, String phone, String description) throws Exception {
		super(name, address, phone);
		this.socialPayment = false;
		this.description = description;
	}
	
	public Volunteer(String name, String address, String phone, double socialMoney) throws Exception {
		super(name, address, phone);
		this.socialPayment = true;
		this.totalPaid = socialMoney;
	}

	
	@Override
	public void pay() {
		//TODO
		
	}

	public String getName() {
		// TODO Auto-generated method stub
		return this.name;
	}
	
	public boolean hasSocialhelp() {
		return this.socialPayment;
	}


	@Override
	public String toString() {
		// TODO Auto-generated method stub
		if(!this.socialPayment) {
			return "Vol \n"
					+ "  [name="+this.name + ",\n"
					+ "   address="+this.address+",\n"
					+ "   phone="+this.phone+",\n"
					+ "   descripcion="+this.description+"n";
		} else {
			return "Vol \n"
					+ "  [name="+this.name + ",\n"
					+ "   address="+this.address+",\n"
					+ "   phone="+this.phone+",\n"
					+ "   socialPayment="+getTotalPaid()+"]\n";
		}

		//+ "   grossSalaryMonth="+this.grossSalaryMonth+"\n"
		//+ "   netSalaryMonth="+this.netSalaryMonth+"\n"
		//+ "   grossSalaryYear="+getGrossSalaryYear()+"\n"
		//+ "   netSalaryYear="+getNetSalaryYear()+"]";
		//return "Vol [name=" + this.name + ", address="+this.address+", phone="+this.phone+", descripcio=" + this.description + ", totalPaid="+this.totalPaid+"]";
	}


	@Override
	public double getTotalPaid() {
		// TODO Auto-generated method stub
		return this.totalPaid;
	}


	@Override
	public void payTaxes() {
		// TODO Auto-generated method stub
		
	}

}
