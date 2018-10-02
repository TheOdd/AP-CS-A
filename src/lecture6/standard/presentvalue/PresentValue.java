package lecture6.standard.presentvalue;

import java.util.Scanner;

/*
 * Standard
 * 
 * Write a method fv that computes the amount of money you will have if
 * you invest C dollars today at the compound interest rate of r per period,
 * in T periods. The formula for the future value is given by C*(1 + r)^T.
 * 
 * Write a method pv that computes the amount of money that would have to
 * be invested now, at the compound interest rate r per period, to obtain
 * a cash flow of C in T periods. The formula for the present value
 * is given by C/(1 + r)^T.
 * 
 * Your program should ask for (a) dollar amount, (b) interest rate,
 * and (c) number of periods (assume years), and then report both
 * answers (assuming dollar amount is the starting amount, and 
 * assuming dollar amount is the goal). Use methods.
 */ 

public class PresentValue {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		double C, r, T;
		
		System.out.println("Please enter the following information:");
		
		System.out.print("Dollar amount: ");
		C = input.nextDouble();
		
		System.out.print("Interest rate: ");
		r = input.nextDouble();
		
		System.out.print("Number of periods in years: ");
		T = input.nextDouble();
		
		double futureVal = fv(C, r, T);
		double presentVal = pv(C, r, T);
		
		System.out.println("FV: $" + String.format("%.2f", futureVal) + "\nPV: $" + String.format("%.2f", presentVal));
		
		input.close();
	}
	
	private static double fv(double C, double r, double T) {
		return C * Math.pow(1 + r, T);
	}
	
	private static double pv(double C, double r, double T) {
		return C / Math.pow(1 + r, T);
	}
}
