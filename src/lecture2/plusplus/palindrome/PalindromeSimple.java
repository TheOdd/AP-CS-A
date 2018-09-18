package lecture2.plusplus.palindrome;

/*
 * Challenge++ (Simplified)
 * 
 * Write a program that takes any string from the user, and then 
 * determines the fewest number of characters that need to be added 
 * to the *END* of the string to make it a palindrome.
 */

import java.util.Objects;
import java.util.Scanner;

public class PalindromeSimple {
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
	
	// Main method for calculating minimum number of characters to be added to end
	private static int minCharacters(String w) {
		// Check if it's already a palindrome
		if (isPalindrome(w))
			return 0;
		int count = 0; // char array index & end count
		String added = ""; // string to be appended to original each loop
		char[] w_chars = w.toCharArray();
		// Check if concatenation of 'added' and original string is palindrome before each loop
		while (!isPalindrome(w + added)) {
			added = w_chars[count] + added; // adds next character to beginning of 'added' variable
			count++;
		}
		return count;
	}
}
