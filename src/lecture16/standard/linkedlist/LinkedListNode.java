package lecture16.standard.linkedlist;

public class LinkedListNode<T> {
	public T val = null;
	public LinkedListNode<T> next = null;
	
	LinkedListNode(T v) {
		val = v;
	}
	
	public int length() {
		int len = 1;
		LinkedListNode<T> pointer = this;
		
		for (;pointer.next != null; len++)
			pointer = pointer.next;
		
		return len;
	}
	
	public String toString() {
		LinkedListNode<T> pointer = this;
		StringBuilder s;
		if (val == null)
			s = new StringBuilder("null");
		else
			s = new StringBuilder(this.val.toString());
		
		while (pointer.next != null) {
			pointer = pointer.next;
			s.append(' ' + pointer.val.toString());
		}
		
		return s.toString();
	}
}
