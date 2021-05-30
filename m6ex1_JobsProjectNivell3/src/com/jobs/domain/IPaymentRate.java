package com.jobs.domain;

public interface IPaymentRate {
	public double pay(double baseSalaryMonth);
	public double payTaxes(double grossSalaryMonth);
}
