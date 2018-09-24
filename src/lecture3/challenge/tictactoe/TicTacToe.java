package lecture3.challenge.tictactoe;

/*
 * Challenge
 * 
 * Write a TicTacToe game! The user can always go first. The user will enter a
 * number 1-9 to choose a square. You will write logic (a crude AI) to play the 
 * computer’s turns (don’t worry, the grade isn’t based on how smart the computer
 * player is). Display the updated grid before every player turn. When the game ends,
 * announce who won, and ask the player if they’d like to play again.
 */

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class TicTacToe {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		// Initialize board with reference numbers
		String[][] b = {{"1", "2", "3"}, {"4", "5", "6"}, {"7", "8", "9"}};
		
		printBoard(b);
		System.out.println("You are playing as X.");
		
		int choice;
		int moveCount = 0;
		
		while (getWinner(b) == null) {
			do {
				System.out.println("Please select a move.");
				choice = input.nextInt();
			} while (choice < 1 || choice > 9 || makeMove(b, choice, "X") == null);
			
			b = makeMove(b, choice, "X");
			
			moveCount++;
			
			if (moveCount >= 5 || getWinner(b) != null)
				break;
			b = moveAI(b);
			
			printBoard(b);
		}
		
		if (moveCount == 5)
			System.out.println("Tie!");
		else
			System.out.println(getWinner(b) + " wins!");
		
		System.out.println("Would you like to play again? (Y/N)");

		boolean playAgain = input.next().equalsIgnoreCase("Y");

		input.close();
		
		if (playAgain)
			main(null);
	}
	
	private static void printBoard(String[][] board) {
		System.out.println(" ––– ––– –––");
		for (String[] row : board) {
			for (String move : row) {
				System.out.print("| " + move + " ");
			}
			System.out.print("|" + '\n' + " ––– ––– –––" + '\n');
		}
	}
	
	private static String[][] makeMove(String[][] board, int move, String player) {
		String[][] boardClone = cloneBoard(board);
		String spotVal = board[(move - 1) / 3][(move - 1) % 3];
		if (!spotVal.equals("X") && !spotVal.equals("O")) {
			boardClone[(move - 1) / 3][(move - 1) % 3] = player;
			return boardClone;
		} else
			return null;
	}
	
	// Computer chooses random tile to play
	private static String[][] moveAI(String[][] board) {
		int move = ThreadLocalRandom.current().nextInt(1, 10);
		for (; makeMove(board, move, "O") == null; move = ThreadLocalRandom.current().nextInt(1, 10)) {}
		return makeMove(board, move, "O");
	}
	
	private static String[][] cloneBoard(String[][] board) {
		String[][] boardClone = board.clone();
		for (int i = 0; i < boardClone.length; i++) {
			boardClone[i] = new String[3];
			for (int k = 0; k < boardClone[i].length; k++)
				boardClone[i][k] = new String(board[i][k]);
		}
		return boardClone;
	}
	
	private static String getWinner(String[][] board) {
		// Check win conditions
		// Check rows
		for (String[] row : board) {
			if (row[0].equals(row[1]) && row[1].equals(row[2]))
				return row[0];
		}
		
		// Check columns
		for (int col = 0; col < 3; col++) {
			if (board[0][col].equals(board[1][col]) && board[1][col].equals(board[2][col]))
				return board[0][col];
		}
		
		// Check diagonals
		if (board[0][0].equals(board[1][1]) && board[1][1].equals(board[2][2]))
			return board[0][0];
		if (board[0][2].equals(board[1][1]) && board[1][1].equals(board[2][0]))
			return board[1][1];
		
		return null;
	}
}
