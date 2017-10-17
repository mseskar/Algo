/**
 * Implement the Queue ADT using linked lists
 *
 * @mseskar
 10/13/17
 */
public class Queue {
	private Node[] a;
	private static int count;

//default
	public Queue() {
		this.a = new Node[0];
	}

//overwrite with specific Node
	public Queue(Node[] arr) {
		this.a = arr;
	}

//enqueue the String s, add to the end of the queue
	public void enqueue(String s) {
		Node[] copy = new Node[a.length + 1];
		for (int i = 0; i < a.length; i++) {
			copy[i] = a[i];
		}
		Node n = new Node(s, null);
		copy[copy.length - 1] = n;
		if (a.length != 0)
			copy[copy.length - 2].setNext(n);
		a = copy;
	}

//remove first element from queue, return first element from linked list
	public String dequeue() {
		String s = a[0].getItem();
		Node[] copy = new Node[a.length - 1];
		for (int i = 1; i < a.length; i++) {
			copy[i - 1] = a[i];
		}
		a = copy;
		return s;
	}

//size of queue
	public int size() {
		return a.length;
	}

//returns true if the queue is empty
	public boolean isEmpty()
	{
		return a==null || a.length==0;
	}
}
