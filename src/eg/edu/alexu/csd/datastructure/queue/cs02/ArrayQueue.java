package eg.edu.alexu.csd.datastructure.queue.cs02;

import eg.edu.alexu.csd.datastructure.queue.IArrayBased;
import eg.edu.alexu.csd.datastructure.queue.IQueue;

public class ArrayQueue implements  IQueue,IArrayBased  {
	int maxLength ; 
	Object[] arr;
	/**
	 * @param maxSize
	 */
	public ArrayQueue (int maxSize){
		this.maxLength = maxSize ;	
		this.arr = new Object [maxLength];
	}

	/**
	 * arr to put the Queue in it 
	 */
	/**
	 * this is a pointer to the first element in the queue 
	 */
	int first =0 ;
	/**
	 * this is a pointer to the last element in the queue 
	 */
	int last =0 ;
	/**
	 *counter is used to count the element in the queue and its size
	 */
	int counter = 0 ;

	/**
	* Inserts an item at the queue front.
	*/
	public void enqueue(Object item) {
		// TODO Auto-generated method stub
		if (counter  == maxLength){
			throw new RuntimeException();
		}else {
			if (last == maxLength){
				last = 0 ;
			}
			if(item != null){
			arr[last]= item ;
			   last ++ ;	
			counter ++ ;
			}else {
				return ;
			}
		}
		
	}
	/**
	* Removes the object at the queue rear and returns it.
	*/
	public Object dequeue() {
		// TODO Auto-generated method stub
		Object ret;
		if (this.isEmpty()){
			throw new RuntimeException();
		}else {
			if (first == maxLength){
				first =0;
			}
			ret =arr[first];
			arr[first]= null;
			first ++; 
			counter -- ;
		}
		return ret;
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
