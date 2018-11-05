package lecture16.standard.linkedlist;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int n = input.nextInt();
		
		input.close();
		
		LinkedList<Integer> list = new LinkedList<Integer>((int)(Math.random() * 10));
		LinkedList<Integer> listCopy = list;
		
		for (int i = 1; i < n; i++) {
			// Random int 0-9
			int random = (int)(Math.random() * 10);
			
			listCopy.next = new LinkedList<Integer>(random);
			listCopy = listCopy.next;
		}
		
		// list is now the head of an n-long LinkedList, with each node containing a random integer from 0-9.
		// listCopy is no longer needed, as it just references the tail node of list
		
		System.out.println(list);
	}
}
