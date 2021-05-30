package com.jobs.domain;

public class Volunteer extends AbsStaffMember {
	
	protected String description;

	public Volunteer(String name, String address, String phone, String description) throws Exception {
		super(name, address, phone);
		this.description = description;
		
		//TODO
	}

	
	@Override
	public void pay() {
		//TODO
		
	}


	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return this.name;
	}


	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Vol [name=" + this.name + ", address="+this.address+", phone="+this.phone+", descripcio=" + this.description + ", totalPaid="+this.totalPaid+"]";
	}

}
