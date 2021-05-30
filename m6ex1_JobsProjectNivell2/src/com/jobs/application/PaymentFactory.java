package com.jobs.application;

import com.jobs.domain.IPaymentRate;

public class PaymentFactory {

	
	public static IPaymentRate createPaymentRateBoss(){
		return new IPaymentRate() {	
			@Override
			public double pay(double salaryPerMonth) {
				double RATE = 0.50;
				return salaryPerMonth*(1 + RATE);
			}
		};
	}
	
	public static IPaymentRate createPaymentRateManager(){
		return new IPaymentRate() {	
			@Override
			public double pay(double salaryPerMonth) {
				double RATE = 0.10;
				return salaryPerMonth*(1 + RATE);
			}
		};
	}
	
	public static IPaymentRate createPaymentRateEmployee(){
		return new IPaymentRate() {
			@Override
			public double pay(double salaryPerMonth) {
				double RATE = 0.15;
				return salaryPerMonth*(1-RATE);
			}
		};
	}
	
	public static IPaymentRate createPaymentRateJuniorEmployee(){
		return new IPaymentRate() {
			@Override
			public double pay(double salaryPerMonth) {
				double RATE = 0.15;
				return salaryPerMonth*(1-RATE);
			}
		};
	}
	
	public static IPaymentRate createPaymentRateMidEmployee(){
		return new IPaymentRate() {
			@Override
			public double pay(double salaryPerMonth) {
				double RATE = 0.10;
				return salaryPerMonth*(1-RATE);
			}
		};
	}
	
	public static IPaymentRate createPaymentRateSeniorEmployee(){
		return new IPaymentRate() {
			@Override
			public double pay(double salaryPerMonth) {
				double RATE = 0.05;
				return salaryPerMonth*(1-RATE);
			}
		};
	}
}
