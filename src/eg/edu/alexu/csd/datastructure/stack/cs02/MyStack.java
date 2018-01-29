package eg.edu.alexu.csd.datastructure.stack.cs02;

import eg.edu.alexu.csd.datastructure.linkedList.cs02_11.SingleLinkedList;
import eg.edu.alexu.csd.datastructure.stack.IStack;

public class MyStack implements IStack{
	SingleLinkedList s = new SingleLinkedList ();
	int size =0 ;

	/**
	* Inserts a specified element at the specified position in the list.
	* @param index zero-based index
	* @param element object to insert
	*/
	public void add(int index, Object element) {
	     if (index >size && index <0){
			throw new RuntimeException();
		}else {
			s.add(size-index,element);
		}
	     size ++;		
	}

	/**
	* Removes the element at the top of stack and returns that element.
	* @return top of stack element, or through exception if empty
	*/
	public Object pop() {
		if (size >0){
			Object find = s.head.value;
			s.remove(0);
			size --;
			return find ;

		}else{
			throw new RuntimeException();
		}
	}
	/**
	* Get the element at the top of stack without removing it from stack.
	* @return top of stack element, or through exception if empty
	*/
	public Object peek() {
		if (size >0){
		Object find = s.head.value;
		return find;
		}else{
			throw new RuntimeException();
		}
	}

	/**
	* Pushes an item onto the top of this stack.
	* @param object to insert
	*/
	public void push(Object element) {
		s.add(0,element);
		size ++;
	}
	
	/**
	* Tests if this stack is empty
	* @return true if stack empty
	*/
	public boolean isEmpty() {
		if (s.head==null ){
			return true ;
		}
		return false;
	}
	
	/**
	* Returns the number of elements in the stack.
	* @return number of elements in the stack
	*/
	public int size() {
		if (s.head==null){
			return 0;
		}
		return size ;
	}

	
}
