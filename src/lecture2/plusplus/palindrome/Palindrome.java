package lecture2.plusplus.palindrome;

import java.util.Scanner;

// Test case: 1234gabcbag6789
// Desired output: 8
// Test case: abcdab
// Desired output: 3

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

		// Calculate and print result
		System.out.println(word.length() - lcs(word).length());

		input.close();
	}
	
	// Method for longest common substring (not necessarily consecutive characters)
	private static String lcs(String w) {
		// idk
		return "";
	}
}
