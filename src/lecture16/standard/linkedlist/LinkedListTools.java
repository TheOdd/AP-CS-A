package lecture16.standard.linkedlist;

public abstract class LinkedListTools {
	public static <T> LinkedListNode<T> remove(LinkedListNode<T> node, T v) {
		LinkedListNode<T> head = null;
		LinkedListNode<T> pointer = node;
		
		do {
			if (pointer.val != v && head == null) {
				head = new LinkedListNode<T>(pointer.val);
				head.next = pointer.next;
			}
			
			if (pointer.next.val == v)
				pointer.next = pointer.next.next;
			
			pointer = pointer.next;
		} while (pointer.next != null);
		
		return head;
	}
}
