package eg.edu.alexu.csd.datastructure.queue.cs02;

import java.util.LinkedList;

import eg.edu.alexu.csd.datastructure.queue.ILinkedBased;
import eg.edu.alexu.csd.datastructure.queue.IQueue;

/**
 * @author HOME KH
 *
 */
public class LinkedListQueue implements IQueue , ILinkedBased{
	/**
	 * 
	 */
	LinkedList<Object> s = new LinkedList<Object> ();
	int counter = 0 ;
	
	/**
	* Inserts an item at the queue front.
	*/
	public void enqueue(Object item) {
		// TODO Auto-generated method stub
		s.addFirst(item);
		counter ++ ;

			return ;

	}
	
	/**
	* Removes the object at the queue rear and returns it.
	*/
	public Object dequeue() {
		// TODO Auto-generated method stub
		if (!(s.isEmpty())){
		Object get = s.removeLast();
		counter-- ;
		return get;
		}else {
			throw new RuntimeException();
			}
	}
	
	/**
	* Tests if this queue is empty.
	*/
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if (counter == 0){
			return true ;
		}
		return false;
	}
	
	/**
	* Returns the number of elements in the queue
	*/
	public int size() {
		// TODO Auto-generated method stub
		return counter;
	}

}
