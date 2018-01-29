package eg.edu.alexu.csd.datastructure.queue.cs02;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * @author HOME KH
 *
 */
public class TestQueue {

	/**
	 * 
	 */
	int maxSize = 10;

	/**
	 * 
	 */
	LinkedListQueue lin = new LinkedListQueue();

	/**
	 * 
	 */
	ArrayQueue arr = new ArrayQueue(maxSize);
	//@Rule
	//public ExpectedException thrown = ExpectedException.none();

	/**
	 * 
	 */
	@Test
	public void test_Enqueue1() {
		for (int i = 0; i < maxSize; i++) {
			arr.enqueue(i);
		}
		assertEquals(maxSize, arr.size());
		for (int i = 0; i < maxSize; i++) {
			assertEquals(i, arr.dequeue());
		}
		assertTrue(arr.isEmpty());
	//	thrown.expect(RuntimeException.class);
	//	arr.dequeue();
	}

	@Test
	public void testEnqueue_2() {
		for (int i = 0; i < maxSize; i++) {
			lin.enqueue(i);
		}
		assertEquals(maxSize, lin.size());
		for (int i = 0; i < maxSize; i++) {
			assertEquals(i, lin.dequeue());
		}
		assertTrue(arr.isEmpty());
		//thrown.expect(RuntimeException.class);
		//arr.dequeue();
	}

	@Test
	public void testEn_full() {
		arr.enqueue('a');
		arr.enqueue('b');
		arr.enqueue('c');
		arr.enqueue('d');
		arr.enqueue('f');
		arr.enqueue('g');
		arr.enqueue('h');
		arr.enqueue('i');
		arr.enqueue('j');
		arr.enqueue('k');
	//	thrown.expect(RuntimeException.class);
		//arr.enqueue('l');		
	}
	@Test
	public void testEn_De_Circular() {
		arr.enqueue('a');
		arr.enqueue('b');
		arr.enqueue('c');
		arr.enqueue('d');
		arr.enqueue('f');
		arr.enqueue('g');
		arr.enqueue('h');
		arr.enqueue('i');
		arr.enqueue('j');
		arr.enqueue('k');
		assertFalse(arr.isEmpty());
		assertEquals(maxSize, arr.size());
		arr.dequeue();
		arr.dequeue();
		arr.enqueue('l');
		assertNotEquals(maxSize , arr.size());
	}

}
