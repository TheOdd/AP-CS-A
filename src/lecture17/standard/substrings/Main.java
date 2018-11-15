package lecture17.standard.substrings;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a string: ");
		String s = input.nextLine();
		Substrings sub = new Substrings(s);
		System.out.print("Enter a substring length: ");
		int length = input.nextInt();
		HashMap<String, Integer> subs;
		while (true) {
			try {
				subs = sub.uniqueSubstringOccurrences(length);
				break;
			} catch (IllegalArgumentException e) {
				System.out.println("Please enter a valid length.");
				System.out.print("Enter a substring length: ");
				length = input.nextInt();
			}
		}
		input.close();
		System.out.println("Unique substring count: " + subs.size());
		System.out.println("Substring occurrences: " + subs);
	}
}
