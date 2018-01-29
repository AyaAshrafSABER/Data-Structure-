package eg.edu.alexu.csd.datastructure.linkedList.cs02_11;

/**
 * @author HOME KH
 *
 */
public class Node {
	/**
	 *
	 */
	public Node next = null;
	/**
	 *
	 */
	public Node prev = null;
	/**
	 *
	 */
	public Object value;
	/**
	 * @param element
	 */
	public Node(Object element) {
		this.value =element ;
	}
}