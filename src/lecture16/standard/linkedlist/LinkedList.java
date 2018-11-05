package lecture16.standard.linkedlist;

public class LinkedList<T> {
	public T val = null;
	public LinkedList<T> next = null;
	
	LinkedList(T v) {
		val = v;
	}
	
	public void remove(T v) {
		LinkedList<T> pointer = this;
		LinkedList<T> head = null;
		
		do {
			if (pointer.val != v) {
				head = pointer;
				break;
			} else
				pointer = pointer.next;
		} while (pointer.next != null);
		
		while (pointer.next != null) {
			if (pointer.next.val == v)
				pointer.next = pointer.next.next;
			
			pointer = pointer.next;
		}
		
		val = head.val;
		next = head.next;
	}
	
	public int length() {
		int len = 1;
		LinkedList<T> pointer = this;
		
		for (;pointer.next != null; len++)
			pointer = pointer.next;
		
		return len;
	}
	
	public String toString() {
		LinkedList<T> pointer = this;
		StringBuilder s = new StringBuilder(this.val.toString());
		
		while (pointer.next != null) {
			pointer = pointer.next;
			s.append(' ' + pointer.val.toString());
		}
		
		return s.toString();
	}
}
