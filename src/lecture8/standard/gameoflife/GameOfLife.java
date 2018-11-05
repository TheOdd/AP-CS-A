package lecture8.standard.gameoflife;

import java.util.Scanner;

/*
 * Optional Exercise
 * 
 * Try implementing Game of Life on a boolean matrix from section 2.4.20
 * 
 * Rules:
 * 
 * A dead cell with exactly three live neighbors becomes live.
 * A live cell with exactly one live neighbor becomes dead.
 * A live cell with more than three live neighbors becomes dead.
 */

public class GameOfLife {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Please input the size of the board (n x n)");
		Board b = new Board(input.nextInt());
		
		System.out.println("Please input the number of generations to go through.");
		int t = input.nextInt();
		
		System.out.print("\n");
		
		input.nextLine();
		
		for (int current = 1; current <= t; current++) {
			System.out.println("Generation " + current + "\n");
			System.out.print(b);
			for (int i = 0; i < (2 * b.getSize() - 1); i++)
				System.out.print('–');
			System.out.println("\n");
			b.update();
			input.nextLine();
		}
		
		input.close();
	}
}
