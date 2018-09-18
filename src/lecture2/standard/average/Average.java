package lecture2.standard.average;

/* Standard
 * 
 * Have the user type in integers, and continue to do so until the number 
 * entered is 0. Then, print the sum of all the integers typed and the 
 * mean (arithmetic average)
*/

import java.util.Scanner;

public class Average {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		// Start count at 0 to account for final 0 input
		int count = 0;
		double total = 0;
		
		// Continuously handle input
		while (true) {
			// Only take integers
			int curInt = input.nextInt();
			if (curInt == 0)
				break;
			total += curInt;
			count++;
		}
		
		// Handle divide by zero edge case
		double result = (count == 0) ? 0 : (total / count);
		
		System.out.println("The average is " + result);
		
		input.close();
	}
}
