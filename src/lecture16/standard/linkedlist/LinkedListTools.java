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
}
