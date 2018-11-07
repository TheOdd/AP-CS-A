package lecture16.standard.linkedlist;

public abstract class LinkedListTools {
	public static <T> LinkedListNode<T> remove(LinkedListNode<T> head, T v) {
		if (head == null)
			return null;
		LinkedListNode<T> newHead = null;
		LinkedListNode<T> pointer = head;
		
		do {
			if (pointer.val != v) {
				newHead = pointer;
				break;
			} else
				pointer = pointer.next;
		} while (pointer.next != null);
		
		while (pointer.next != null) {
			if (pointer.next.val == v)
				pointer.next = pointer.next.next;
			
			pointer = pointer.next;
		}
		
		return newHead;
	}
	
	public static <T> LinkedListNode<T> reverse(LinkedListNode<T> head) {
		if (head == null)
			return null;
		LinkedListNode<T> next = null;
		LinkedListNode<T> temp = null;
		
		while (head.next != null) {
			temp = head.next;
			head.next = next;
			next = head;
			head = temp;
		}
		
		head.next = next;
		
		return head;
	}
	
	public static <T> LinkedListNode<T> arrayToLinkedList(T[] arr) {
		if (arr.length == 0)
			return null;
		
		LinkedListNode<T> head = new LinkedListNode<T>(arr[0]);
		LinkedListNode<T> pointer = head;
		
		for (int i = 1; i < arr.length; i++) {
			pointer.next = new LinkedListNode<T>(arr[i]);
			pointer = pointer.next;
		}
		
		return head;
	}
	
	public static LinkedListNode<Integer> add(LinkedListNode<Integer> head1, LinkedListNode<Integer> head2) {
		if (head1 == null || head2 == null)
			return null;
		
		if (head1.length() < head2.length()) {
			LinkedListNode<Integer> temp = head1;
			head1 = head2;
			head2 = temp;
		}
		
		head1 = reverse(head1);
		head2 = reverse(head2);
		
		LinkedListNode<Integer> result = head1;
		LinkedListNode<Integer> tail1 = null;
		
		int carry = 0;
		int added;
		
		do {
			added = (head1.val + head2.val + carry) % 10;
			carry = (head1.val + head2.val + carry) / 10;
			
			head1.val = added;
			
			if (head1.next == null)
				tail1 = head1;
			
			head1 = head1.next;
			head2 = head2.next;
		} while (head2 != null);
		
		while (carry != 0) {
			if (head1 == null) {
				tail1.next = new LinkedListNode<Integer>(0);
				head1 = tail1.next; 
			}
			
			added = (head1.val + carry) % 10;
			carry = (head1.val + carry) / 10;
			head1.val = added;
			
			if (carry != 0) {
				head1.next = new LinkedListNode<Integer>(0);
				head1 = head1.next;
			}
		}
		
		return reverse(result);
	}
}
