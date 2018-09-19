package lecture2.challenge.creditcard;

/* Challenge
 * 
 * We’re going to process credit card numbers. Take the entire 16-digit 
 * number as a single input from the user. Use the Luhn Algorithm
 * to prove that it’s a valid number, and then if it is, decipher
 * the number to report (a) the type of credit card, (b) the code of the
 * issuing bank, and (c) the account number. 
 */

import java.util.Scanner;

public class CheckCard {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		// Get card number from input
		Card card = new Card(input.nextLong());
		
		// Check if card is valid
		if (!card.isValid) {
			System.out.println("Card is not valid.");
			System.exit(0);
		}
		
		// Print card information
		System.out.println("Card type: " + card.MII);
		System.out.println("Bank code: " + card.IIN);
		System.out.println("Account Number: " + card.accountNum);
		
		input.close();
	}
}