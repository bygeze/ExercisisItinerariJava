package com.jobs.application;

import com.jobs.domain.IPaymentRate;

public class PaymentFactory {	
	public static IPaymentRate createPaymentRateBoss(){
		return new IPaymentRate() {	
			@Override
			public double pay(double baseSalaryMonth) {
				double RATE = 1 + 0.50;
				return baseSalaryMonth*(RATE);
			}
			public double payTaxes(double grossSalaryMonth) {
				double IRPF = 1 - 0.32;
				return grossSalaryMonth * IRPF;
			}
		};
	}
	
	public static IPaymentRate createPaymentRateManager(){
		return new IPaymentRate() {	
			@Override
			public double pay(double salaryPerMonth) {
				double RATE = 1 + 0.10;
				return salaryPerMonth* RATE;
			}

			@Override
			public double payTaxes(double grossSalaryMonth) {
				// TODO Auto-generated method stub
				double IRPF = 1 + 0.26;
				return grossSalaryMonth * IRPF;
			}
		};
	}
	
	public static IPaymentRate createPaymentRateEmployee(){
		return new IPaymentRate() {
			@Override
			public double pay(double salaryPerMonth) {
				double RATE = 1-0.15;
				return salaryPerMonth*RATE;
			}

			@Override
			public double payTaxes(double grossSalaryMonth) {
				// TODO Auto-generated method stub
				double IRPF = 1-0.02;
				return grossSalaryMonth * IRPF;
			}
		};
	}
	
	public static IPaymentRate createPaymentRateJuniorEmployee(){
		return new IPaymentRate() {
			@Override
			public double pay(double salaryPerMonth) {
				double RATE = 1-0.15;
				return salaryPerMonth*RATE;
			}

			@Override
			public double payTaxes(double grossSalaryMonth) {
				// TODO Auto-generated method stub
				double IRPF = 1-0.02;
				return grossSalaryMonth * IRPF;
			}
		};
	}
	
	public static IPaymentRate createPaymentRateMidEmployee(){
		return new IPaymentRate() {
			@Override
			public double pay(double salaryPerMonth) {
				double RATE = 1-0.10;
				return salaryPerMonth*RATE;
			}

			@Override
			public double payTaxes(double grossSalaryMonth) {
				// TODO Auto-generated method stub
				double IRPF = 1-0.15;
				return grossSalaryMonth * IRPF;
			}
		};
	}
	
	public static IPaymentRate createPaymentRateSeniorEmployee(){
		return new IPaymentRate() {
			@Override
			public double pay(double salaryPerMonth) {
				double RATE = 1-0.05;
				return salaryPerMonth*RATE;
			}

			@Override
			public double payTaxes(double grossSalaryMonth) {
				// TODO Auto-generated method stub
				double IRPF = 1-0.24;
				return grossSalaryMonth * IRPF;
			}
		};
	}
}
