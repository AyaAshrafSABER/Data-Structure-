package eg.edu.alexu.csd.datastructure.linkedList.cs02_11;

import eg.edu.alexu.csd.datastructure.linkedList.ILinkedList;

/**
 * @author HOME KH
 *
 */
public class SingleLinkedList implements ILinkedList {
	/**
	 */
	public Node head = null;
	/**
	 */
	int size = 0;

	/**
	 * Inserts a specified element at the specified sposition in the list.
	 */
	public void add(int index, Object element) {
		if ((head == null && index != 0) || index < 0 || index > size) {
			throw null;
		}
		int counter;
		Node node = new Node(element);
		Node i = head;
		if (index == 0) {
			node.next = head;
			head = node;

		} else {
			for (counter = 0; counter < index - 1 && i != null; counter++) {
				i = i.next;
			}
			if (counter == index - 1) {
				node.next = i.next;
				i.next = node;
			}
		}
		size++;
	}

	/** Inserts the specified element at the end of the list. */
	public void add(Object element) {
		Node node = new Node(element);
		if (head == null) {
			head = node;
		} else {
			Node i = head;
			int counter = 0;
			while (i != null) {
				counter++;
				i = i.next;
			}
			i = head;
			for (int j = 0; j < counter - 1; j++) {
				i = i.next;
			}
			node.next = i.next;
			i.next = node;
		}
		size++;
	}

	/** Returns the element at the specified position in this list. */
	public Object get(int index) {
		if (head == null || index < 0 || index >= size) {
			throw null;
		}

		Node i = head;
		int counter = 0;
		while (counter < index) {
			i = i.next;
			counter++;
		}
		return i.value;
	}

	/**
	 * Replaces the element at the specified position in this list with the
	 * specified element.
	 */
	public void set(int index, Object element) {
		if (head == null || index < 0 || index >= size) {
			throw null;
		}

		Node i = head;
		for (int j = 0; j < index; j++) {
			i = i.next;
		}
		i.value = element;
	}

	/** Removes all of the elements from this list. */
	public void clear() {
		head = null;
		size = 0;
	}

	/** Returns true if this list contains no elements. */
	public boolean isEmpty() {
		if (head == null) {
			return true;
		}
		return false;
	}

	/** Removes the element at the specified position in this list. */
	public void remove(int index) {
		if (head == null || index < 0 || index >= size) {
			throw null;
		} else {
			int counter;
			if (index == 0) {
				head = head.next;

			} else {
				Node i = head;
				Node j = i.next;
				for (counter = 0; counter < index - 1 && i != null; counter++) {
					i = i.next;
					j = j.next;
				}
				i.next = j.next;
				j.next = null;
			}
		}
		size--;
	}

	/** Returns the number of elements in this list. */
	public int size() {
		if (head == null) {
			return 0;
		} else {
			Node i = head;
			int counter = 0;
			while (i != null) {
				counter++;
				i = i.next;
			}
			return counter;
		}
	}

	/**
	 * Returns a view of the portion of this list between the specified
	 * fromIndex and toIndex, inclusively.
	 */
	public ILinkedList sublist(int fromIndex, int toIndex) {
		SingleLinkedList sublist = new SingleLinkedList();
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
		if (head == null) {
			return false;
		} else {
			Node i = head;
			int flag = 0;
			while (i != null && flag == 0) {
				if (o.equals(i.value)) {
					flag = 1;
				} else {
					i = i.next;
				}
			}
			if (flag == 1) {
				return true;
			} else {
				return false;
			}
		}
	}
}