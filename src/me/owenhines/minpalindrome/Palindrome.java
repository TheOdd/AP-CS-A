package me.owenhines.minpalindrome;

/*
 * Challenge++
 * 
 * Write a program that takes any string from the user, and then 
 * determines the fewest number of characters that need to be added to the string to 
 * make it a palindrome.
 */

import java.util.Objects;
import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // Get user's input of word to use
        String word = input.nextLine();
        
        
        
        input.close();
    }
    
    // Helper method for checking if a string is a palindrome
    private static boolean isPalindrome(String w) {
        return Objects.equals(new StringBuilder(w).reverse().toString(), w);
    }
}
