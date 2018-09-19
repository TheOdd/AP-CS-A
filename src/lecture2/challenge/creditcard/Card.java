package lecture2.challenge.creditcard;

/*
 * Card class that has calculates properties of the card
 */

public class Card {
	// Initialize properties of card
	public long number;
	public String MII;
	public int length;
	public int IIN;
	public long accountNum;
	public boolean isValid;
	
	// Constructor that takes card number
	public Card(long c) {
		// Assign properties based on methods
		number = c;
		length = longLength();
		isValid = validate();
		// Only assign MII, IIN, & Account Number if card is valid
		if (isValid) {
			MII = GetMII();
			IIN = GetIIN();
			accountNum = GetAccountNum();
		}
	}
	
	private String GetMII() {
		// First digit of card (from left side)
		int identifier = (int)(number / Math.pow(10, length - 1));
		switch (identifier) {
		case 1:
			return "Airlines";
		case 2:
			return "Airlines & Financial";
		case 3:
			return "American Express";
		case 4:
			return "Visa";
		case 5:
			return "Mastercard";
		case 6:
			return "Discover";
		case 7:
			return "Petroleum";
		case 8:
			return "Health Care & Telecommunications";
		case 9:
			return "Open for Assignment";
		default:
			return null;
		}
	}
	
	private int GetIIN() {
		// First 6 digits of card (from left side)
		return (int)(number / Math.pow(10, length - 6));
	}
	
	private long GetAccountNum() {
		// Digits 7 to second to last digit of card (from left side)
		return (long)(number % Math.pow(10, length - 6) / 10);
	}
	
	// Returns length of card number (# of digits)
	private int longLength() {
		int i = 0;
		for (;;i++) {
			if ((int)(number / Math.pow(10, i)) == 0)
				break;
		}
		return i;
	}
	
	// Luhn Algorithm for validating card
	private boolean validate() {
		// Shortest possible length for card is 13
		if (length < 13)
			return false;
		int sum = 0;
		for (int i = 1; i <= length; i++) {
			int currentDigit = (int)(number % Math.pow(10, i) / Math.pow(10, i - 1));
			// Double every other digit. If the result is over 9, then add its digits (aka subtract 9)
			sum += (i % 2 == 0) ? (2 * currentDigit > 9 ? 2 * currentDigit - 9 : 2 * currentDigit) : currentDigit;
		}
		// Is valid if result is divisible by 10
		return sum % 10 == 0;
	}
}
