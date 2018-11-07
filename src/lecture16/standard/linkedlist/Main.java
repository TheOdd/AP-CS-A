package lecture16.standard.linkedlist;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int n;
		
		do {
			System.out.println("Please input any positive integer.");
			n = input.nextInt();
		} while (n <= 0);
		
		input.close();
		
		LinkedListNode<Integer> list = new LinkedListNode<Integer>((int)(Math.random() * 10));
		LinkedListNode<Integer> pointer = list;
		
		for (int i = 1; i < n; i++) {
			// Random int 0-9
			int random = (int)(Math.random() * 10);
			
			pointer.next = new LinkedListNode<Integer>(random);
			pointer = pointer.next;
		}
		
		// list is now the head of an n-long LinkedList, with each node containing a random integer from 0-9.
		// pointer is no longer needed, as it just references the tail node of list
		
		System.out.println("Randomly generated list: " + list);
		
		System.out.println("Reversed list: " + LinkedListTools.reverse(list));
		
		Integer[] arr1 = {2, 9, 7, 4, 3, 8, 2, 9, 7, 3, 8, 6, 3, 2, 1, 3, 5};
		Integer[] arr2 = {2, 8, 1, 4, 3, 2, 9, 3, 4, 8, 1, 3, 5, 2};
		
		LinkedListNode<Integer> head1 = LinkedListTools.arrayToLinkedList(arr1);
		LinkedListNode<Integer> head2 = LinkedListTools.arrayToLinkedList(arr2);
		
		System.out.println("First number in addition operation: " + head1);
		System.out.println("Second number in addition operation: " + head2);
		
		System.out.println("Sum: " + LinkedListTools.add(head1, head2));
	}
}
