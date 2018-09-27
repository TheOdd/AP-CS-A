package lecture3.plusplus.nqueens;

/*
 * Challenge++
 * 
 * For 1 <= n <= 30 (taken from user) output every valid configuration of 
 * n queens on a chess board of dimensions n x n such that no two queens
 * are in each others’ movement range. Output your solutions, one to a line,
 * as a list of (zero-based) numbers where each number is the row in which the
 * queen in that column is placed (e.g. “0 2 1” indicates queens at coordinates
 * [0,0], [1,2], and [2,1] on a 3x3 board... which isn’t a valid solution,
 * because the second and third queen can reach one another)
 */

import java.util.Scanner;

public class NQueens {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		// Get input
		System.out.println("This program will output all possible configurations of n queens on an n x n chess board.");
		int n;
		do {
			System.out.println("Please enter integer n. 1 <= n <= 30");
			n = input.nextInt();
		} while (n < 1 || n > 30);

		// Storing configurations as base n integers.
		// All possible configurations (valid and invalid) can be represented
		// as all of the base n numbers from 0 to n^n - 1 inclusive (in decimal).
		// Each digit represents the 0-based row index for each column.
		// i.e: 02413 represents the following board:
		// |Q| | | | |
		// | | | |Q| |
		// | |Q| | | |
		// | | | | |Q|
		// | | |Q| | |
		
		int minNum = 0;
		int maxNum = 0;
		
		for (int i = 0; i < n; i++) {
			minNum += (int)Math.pow(n, i) * (n - 1 - i);
			maxNum += (int)Math.pow(n, i) * (i);
		}
		
		for (int i = minNum; i <= maxNum; i++) {
			System.out.println(padLeft(Integer.toString(i, n), n) + " " + i);
		}

		input.close();
	}

	private static String padLeft(String s, int n) {
		return String.format("%1$" + n + "s", s).replace(" ", "0");
	}
	
	private static boolean validConfig(int config) {
		return true;
	}
	
}
