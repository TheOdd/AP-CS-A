package lecture14.standard.searching;

import java.util.Arrays;
import java.util.Scanner;

/*
 * Standard Exercise
 * 
 * Searching
 * 
 * You are to build a program that:
 * Makes an array of n random (Math.random) integers in the range of 0 – 4*n
 * Sort the array using java.util.Arrays.sort
 * Search the sorted array for a number (start at zero, and each time the number 
 * doesn’t exist in the array, increment by one until you come up with a number that exists)
 * Implement both a linear search and a binary search; make sure both produce the same
 * answer (index where the value is found). Remember there could be duplicates in your array.
 * Measure and compare the time taken by each algorithm using System.nanoTime()
 * 
 * Your program should execute and report results for n = 10, 100, 1000, 10000, 100000, and 1000000
 * Watch for the difference in “big O” performance in the results!
*/

public class Searching {
	public static void main(String[] args) {
		// Get n
		Scanner input = new Scanner(System.in);
		int n;
		do
			n = input.nextInt();
		while (n <= 0);
		input.close();
		
		// Create n random integers in range 0 - 4n
		int[] nums = new int[n];
		for (int i = 0; i < n; i++)
			nums[i] = (int)(Math.random() * ((4 * n) + 1));
		
		// Sort the array
		Arrays.sort(nums);
		
		// Compute and compare timings of both algorithms on random integers within range
		for (int target = (int)(Math.random() * ((4 * n) + 1));; target = (int)(Math.random() * ((4 * n) + 1))) {
			long startTime = System.nanoTime();
			int index = searchBinary(nums, target);
			if (index == -1)
				continue;
			
			System.out.println("Binary search algorithm: " + (System.nanoTime() - startTime) / 1000000.0 + " ms");
			startTime = System.nanoTime();
			index = searchLinear(nums, target);
			System.out.println("Linear search algorithm: " + (System.nanoTime() - startTime) / 1000000.0 + " ms");
			break;
		}
	}
	
	static int searchBinary(int[] nums, int target) {
		int n = nums.length;
		int left = 0;
		int right = n;
		int i;
		
		while (left != right && right - left != 1) {
			i = (int)((right + left) / 2);
			if (nums[i] == target)
				return i;
			else if (nums[i] > target)
				right = i;
			else if (nums[i] < target)
				left = i;
		}
		
		// Does not exist in array
		return -1;
	}
	
	static int searchLinear(int[] nums, int target) {		
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == target)
				return i;
		}
		
		// Does not exist in array
		return -1;
	}
}
