package lecture17.standard.xml_parsing;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String xml = input.nextLine();
		input.close();
		boolean isValid = ParseXML.isValid(xml);
		System.out.println("Your XML structure is " + (isValid ? "" : "in") + "valid.");
	}
}
