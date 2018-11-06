package lecture16.standard.linkedlist;

public abstract class LinkedListTools {
	public static <T> LinkedListNode<T> remove(LinkedListNode<T> head, T v) {
		LinkedListNode<T> newHead = null;
		LinkedListNode<T> pointer = head;
		
		do {
			if (pointer.val != v && newHead == null) {
				newHead = new LinkedListNode<T>(pointer.val);
				newHead.next = pointer.next;
			}
			
			if (pointer.next.val == v)
				pointer.next = pointer.next.next;
			
			pointer = pointer.next;
		} while (pointer.next != null);
		
		return newHead;
	}
}