package eg.edu.alexu.csd.datastructure.linkedList.cs02_11;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import eg.edu.alexu.csd.datastructure.linkedList.ILinkedList;

/**
 * @author HOME KH
 *
 */
public class JUnit {
	/**
	 *
	 */
	ILinkedList testSingle = new SingleLinkedList();
	/**
	 *
	 */
	ILinkedList testDouble = new DoubleList();

	/**
	 *
	 */
	@Test
	public void testingInsertion() {
		SingleLinkedList testSingle = new SingleLinkedList();
		DoubleList testDouble = new DoubleList();
		testSingle.add(0, 'a');
		testSingle.add(1, 'b');
		testSingle.add(2, 'c');
		testSingle.add(3, 'd');
		assertEquals('a', testSingle.get(0));
		assertEquals('b', testSingle.get(1));
		assertEquals('c', testSingle.get(2));
		assertEquals('d', testSingle.get(3));

		testDouble.add(0, 'a');
		testDouble.add(1, 'b');
		testDouble.add(2, 'c');
		testDouble.add(3, 'd');
		assertEquals('a', testDouble.get(0));
		assertEquals('b', testDouble.get(1));
		assertEquals('c', testDouble.get(2));
		assertEquals('d', testDouble.get(3));
	}

	/**
	 *
	 */
	@Test
	public void testAddingInTheMiddle() {
		SingleLinkedList testSingle = new SingleLinkedList();
		DoubleList testDouble = new DoubleList();
		testSingle.add(0, 100);
		testSingle.add(1, 200);
		testSingle.add(2, 300);
		testSingle.add(3, 400);

		testSingle.add(2, 250);
		assertEquals(250, testSingle.get(2));

		testDouble.add(0, 100);
		testDouble.add(1, 200);
		testDouble.add(2, 300);
		testDouble.add(3, 400);

		testDouble.add(2, 250);
		assertEquals(250, testDouble.get(2));

	}

	/**
	 *
	 */
	@Test
	public void testingSetMethod() {
		SingleLinkedList testSingle = new SingleLinkedList();
		DoubleList testDouble = new DoubleList();
		testSingle.add(0, 'a');
		testSingle.add(1, 'b');
		testSingle.add(2, 'c');
		testSingle.add(3, 'd');
		testSingle.set(0, 'z');
		assertEquals('z', testSingle.get(0));
		testDouble.add(0, 'a');
		testDouble.add(1, 'b');
		testDouble.add(2, 'c');
		testDouble.add(3, 'd');
		testDouble.set(0, 'z');
		assertEquals('z', testDouble.get(0));
	}

	/**
	 *
	 */
	@Test
	public void testSubLists() {
		SingleLinkedList testSingle = new SingleLinkedList();
		DoubleList testDouble = new DoubleList();

		testSingle.add(0, "pick");
		testSingle.add(1, "a");
		testSingle.add(2, "sublist");
		testSingle.add(3, "from");
		testSingle.add(4, "here");
		testSingle.add(5, "inclusive");
		testSingle.add(6, "to");
		testSingle.add(7, "here");
		testSingle.add(8, "no");
		testSingle.add(9, "more");
		ILinkedList sublist = new SingleLinkedList();
		sublist = testSingle.sublist(4, 7);
		assertEquals("here",sublist.get(0));
		assertEquals("inclusive",sublist.get(1));
		assertEquals("to",sublist.get(2));
		assertEquals("here",sublist.get(3));
		assertEquals(4, sublist.size());

		testDouble.add(0, "pick");
		testDouble.add(1, "a");
		testDouble.add(2, "sublist");
		testDouble.add(3, "from");
		testDouble.add(4, "here");
		testDouble.add(5, "inclusive");
		testDouble.add(6, "to");
		testDouble.add(7, "here");
		testDouble.add(8, "no");
		testDouble.add(9, "more");
		ILinkedList sublist2 = new SingleLinkedList();
		sublist2 = testDouble.sublist(4, 7);
		assertEquals("here",sublist2.get(0));
		assertEquals("inclusive",sublist2.get(1));
		assertEquals("to",sublist2.get(2));
		assertEquals("here",sublist2.get(3));
		assertEquals(4, sublist2.size());
	}

	/**
	 *
	 */
	@Test
	public void testingRemoving() {
		SingleLinkedList testSingle = new SingleLinkedList();
		DoubleList testDouble = new DoubleList();
		testSingle.add(0, 'a');
		testSingle.add(1, 'b');
		testSingle.add(2, 'c');
		testSingle.add(3, 'd');
		assertEquals(4, testSingle.size());
		assertEquals('c', testSingle.get(2));
		testSingle.remove(2);
		assertNotEquals('c', testSingle.get(2));
		assertEquals('d', testSingle.get(2));
		assertEquals(3, testSingle.size());
		testDouble.add(0, 'a');
		testDouble.add(1, 'b');
		testDouble.add(2, 'c');
		testDouble.add(3, 'd');
		assertEquals(4, testDouble.size());
		assertEquals('c', testDouble.get(2));
		testDouble.remove(2);
		assertNotEquals('c', testDouble.get(2));
		assertEquals('d', testDouble.get(2));
		assertEquals(3, testDouble.size());
	}

	/**
	 *
	 */
	@Test
	public void testContains() {
		SingleLinkedList testSingle = new SingleLinkedList();
		DoubleList testDouble = new DoubleList();
		testSingle.add(0, 1997);
		testSingle.add(1, 2000);
		testSingle.add(2, 2011);
		testSingle.add(3, 2017);
		assertTrue(testSingle.contains(2011));
		assertFalse(testSingle.contains(2012));

		testDouble.add(0, 1997);
		testDouble.add(1, 2000);
		testDouble.add(2, 2011);
		testDouble.add(3, 2017);
		assertTrue(testDouble.contains(2011));
		assertFalse(testDouble.contains(2012));

	}

	/**
	 *
	 */
	@Test
	public void testClearing() {
		SingleLinkedList testSingle = new SingleLinkedList();
		DoubleList testDouble = new DoubleList();
		testSingle.add(0, 'a');
		testSingle.add(1, 'b');
		testSingle.add(2, 'c');
		testSingle.add(3, 'd');
		assertFalse(testSingle.isEmpty());
		testSingle.clear();
		assertTrue(testSingle.isEmpty());
		testDouble.add(0, 'a');
		testDouble.add(1, 'b');
		testDouble.add(2, 'c');
		testDouble.add(3, 'd');
		assertFalse(testDouble.isEmpty());
		testDouble.clear();
		assertTrue(testDouble.isEmpty());

	}

}