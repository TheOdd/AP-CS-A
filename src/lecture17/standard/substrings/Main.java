package lecture17.standard.substrings;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a string: ");
		String s = input.nextLine();
		System.out.print("Enter a substring length: ");
		int length = input.nextInt();
		while (length <= 0) {
			System.out.println("Please enter a valid length.");
			System.out.print("Enter a substring length: ");
			length = input.nextInt();
		}
		input.close();
		Substrings sub = new Substrings(s);
		HashMap<String, Integer> subs = sub.uniqueSubstringOccurrences(length);
		System.out.println("Unique substring count: " + subs.size());
		System.out.println("Substring occurrences: " + subs);
	}
}
