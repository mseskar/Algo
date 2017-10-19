
/**
 * Node class
 mseskar
 10/10/17
 */
public class Node {
	private String item; // The item represented by the node
	private Node next; // The next node in the queue

	/**
	 * The item in the node
	 */
	Node(String item, Node n) {
		setItem(item);
		setNext(n);
	}

	/**
	 *The item to set the item to
	 */
	public void setItem(String item) {
		this.item = item;
	}

	/**
	 * Node to set the next node as
	 */
	public void setNext(Node next) {
		this.next = next;
	}

	/**
	 * Return item in the node
	 */
	public String getItem() {
		return item;
	}

	/**
	 * return next node
     */
	public Node getNext() {
		return next;
	}

	/**
	 * Return whether or not this node has a next node
	 */
	public boolean hasNext() {
		return next != null;
	}
}
