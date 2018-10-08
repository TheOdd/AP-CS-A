package lecture7.standard.dicerolls;

public class Dice {
	public static int roll(int sides) {
		return (int)(Math.random() * sides + 1);
	}
	
	public static int roll(int amount, int sides) {
		int total = 0;
		for (int i = 0; i < amount; i++)
			total += roll(sides);
		return total;
	}
}
