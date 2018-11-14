package lecture17.standard.substrings;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String s = input.nextLine();
		input.close();
		Substrings sub = new Substrings(s);
		HashMap<String, Integer> m = sub.uniqueSubstringOccurances(3);
		System.out.println(m);
	}
}
