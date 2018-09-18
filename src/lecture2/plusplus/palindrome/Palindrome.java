package lecture2.plusplus.palindrome;

import java.util.Objects;
import java.util.Scanner;

// Test case: 1234gabcbag6789
// Desired output: 8

/*
 * Challenge++
 * 
 * Write a program that takes any string from the user, and then 
 * determines the fewest number of characters that need to be inserted 
 * anywhere in the string to make it a palindrome.
 */

public class Palindrome {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		// Get user's input of word to use
		String word = input.nextLine();

		// Print result
		System.out.println(minCharacters(word));

		input.close();
	}

	// Helper method for checking if a string is a palindrome
	private static boolean isPalindrome(String w) {
		return Objects.equals(new StringBuilder(w).reverse().toString(), w);
	}

	// Main method for calculating minimum number of characters to be added
	private static int minCharacters(String w) {
		// Placeholder to keep Eclipse happy
		return 0;
	}
}
