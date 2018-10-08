package lecture7.standard.dicerolls;

/*
 * Standard
 * 
 * Write a Dice library (class) for D&D. Include at minimum (a) a static method to roll a die of n
 * sides and (b) a second static method that takes as parameters the number of
 * 4-, 6-, 8-, 10-, 12- and 20-sided dice to roll and returns the sum. Feel free to add other methods as 
 * you see useful (e.g. if you’re a White Wolf or Shadowrun fan, you might write a method that 
 * accepts a number of 10-sided dice to roll and the minimum passing value, and determines how many
 * successes were rolled). Write a program (i.e. more than just Dice.java) that at least trivially
 * uses your Dice library.
*/

import java.util.Scanner;

public class Game {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Please input the number of dice you want to roll.");
		int amount = input.nextInt();
		
		System.out.println("Please input the number of sides each dice will have.");
		int sides = input.nextInt();
		
		System.out.println("Please input how much health the monster has.");
		int health = input.nextInt();
		
		int totalDamage = Dice.roll(amount, sides);
		System.out.print("You dealt " + totalDamage + " damage, ");
		System.out.println((totalDamage >= health) ? "slaying the monster!" : "leaving the monster with " + (health - totalDamage) + " health!");
		
		input.close();
	}
}
