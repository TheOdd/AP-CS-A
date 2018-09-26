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
		
		
		
		input.close();
	}
}
