package eg.edu.alexu.csd.datastructure.linkedList.cs02_11;

import eg.edu.alexu.csd.datastructure.linkedList.ILinkedList;

/**
 * @author HOME KH
 *
 */
public class DoubleList implements ILinkedList {

	/**
	 *
	 */
	public Node head = null;
	/**
	 *
	 */
	public int size = 0;

	/**
	 * Inserts a specified element at the specified sposition in the list.
	 */
	public void add(int index, Object element) {
		Node node = new Node(element);
		if ((head == null && index != 0) || index < 0 || index > size) {
			throw null;
		}
		if (index == 0) {
			node.next = head;
			node.prev = null;
			head = node;
		} else {
			Node current = head;
			for (int i = 0; i < index - 1; i++) {
				current = current.next;
			}
			node.value = element;
			if (current.next != null) {
				Node temp = current.next;
				current.next = node;
				node.next = temp;
				temp.prev = node;
				node.prev = current;
			} else {
				current.next = node;
				node.next = null;
				node.prev = current;
			}
		}
		size++;
	}

	/** Inserts the specified element at the end of the list. */
	public void add(Object element) {
		Node node = new Node(element);
		if (head == null) {
			node.value = element;
			head = node;
			node.next = null;
			node.prev = null;
		} else {
			Node current = head;
			while (current.next != null) {
				current = current.next;
			}
			node.value = element;
			node.next = null;
			node.prev = current;
			current.next = node;
		}
		size++;
	}

	/** Returns the element at the specified position in this list. */
	public Object get(int index) {
		if (head == null || index < 0 || index >=size) {
			throw null;
		}
		Node current = head;
		for (int i = 0; i < index; i++) {
			current = current.next;
		}
		return current.value;
	}

	/**
	 * Replaces the element at the specified position in this list with the
	 * specified element.
	 */public void set(int index, Object element) {
		 if (head == null || index < 0 || index >= size) {
			 throw null;
		 }
		 Node current = head;
		 for (int i = 0; i < index; i++) {
			 current = current.next;
		 }
		 current.value = element;
	 }

	 /** Removes all of the elements from this list. */
	 public void clear() {
		 head = null;
		 size = 0;

	 }

	 /** Returns true if this list contains no elements. */
	 public boolean isEmpty() {
		 return head == null;
	 }

	 /** Removes the element at the specified position in this list. */
	 public void remove(int index) {
		 if (head == null || index < 0 || index >=size) {
			 throw null;
		 } else {
			 int counter;
			 if (head != null) {
				 if (index == 0) {
					 head = head.next;

				 } else {
					 Node i = head;
					 Node j = i.next;
					 for (counter = 0; counter < index- 1 && i != null; counter++) {
						 i = i.next;
						 j = j.next;
					 }
					 i.next = j.next;
					 j.next = null;
				 }
			 }
			 size--;
		 }
	 }

	 /** Returns the number of elements in this list. */
	 public int size() {
		 return size;
	 }

	 /**
	  * Returns a view of the portion of this list between the specified
	  * fromIndex and toIndex, inclusively.
	  */
	 public ILinkedList sublist(int fromIndex, int toIndex) {
		 DoubleList sublist = new DoubleList();
		 if (fromIndex < 0 || toIndex > size || fromIndex > size) {
			 return sublist;
		 }
		 Node n = head;
		 for (int i = 0; i < fromIndex; i++) {
			 n = n.next;
		 }
		 for (int i = fromIndex; i <= toIndex; i++) {
			 sublist.add(n.value);
			 n = n.next;
		 }
		 return sublist;
	 }

	 /**
	  * Returns true if this list contains an element with the same value as the
	  * specified element.
	  */
	 public boolean contains(Object o) {
		 Node current = head;
		 while (current != null) {
			 if (current.value.equals(o))
				 return true;
			 current = current.next;
		 }
		 return false;
	 }
}