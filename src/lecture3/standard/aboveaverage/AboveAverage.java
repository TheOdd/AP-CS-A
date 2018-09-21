package lecture3.standard.aboveaverage;

import java.util.Scanner;

/*
 * Standard
 * 
 * 90% of incoming college students rate themselves as above average.
 * Write a program that takes a command-line argument n, 
 * reads in n integers from standard input, and prints
 * the fraction of values that are strictly above the average value.
 */

public class AboveAverage {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		// First input is number of inputs that follow
		System.out.println("Number of integer inputs:");
		int amount = input.nextInt();
		
		// Get integer inputs
		System.out.println("Please enter the " + amount + " integers separated by newlines.");
		// Cast as double for division later
		double average = 0;
		int[] inputs = new int[amount];
		
		// Get n inputs from user
		for (int i = 0; i < amount; i++) {
			int n = input.nextInt();
			inputs[i] = n;
			average += n;
		}
		
		// Divide to get average from total
		average /= amount;
		
		int above = 0;
		// Iterate thru array and count number of elements above average value
		for (int n : inputs) {
			if (n > average)
				above++;
		}
		
		// Print results
		System.out.println("The fraction of inputs that were strictly above the average is " + above + " / " + amount + " or "
				+ String.format("%.2f", (double)above / amount * 100) + "%");
		
		input.close();
	}
}
