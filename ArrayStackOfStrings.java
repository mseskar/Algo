import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 * Implement the ArrayStack ADT using arrays. Look at the API in the class
 * website. Design and implement a client to calculate the following postfix
 * expression: 8 4 -3 * 1 5 + / *
 *
 * @mseskar
 * @10/10/17
 */
public class ArrayStackOfStrings  {
    private String[] items;  // holds the items
    private int n;             // number of items in stack
    //creates new stack of capca
    public ArrayStackOfStrings(int capacity) {
        this.n = 0;
		this.items = new String[capacity];
    }
//is the stack empty?
    public boolean isEmpty() {
        return this.n == 0;
    }
//is the stack full?
    public boolean isFull() {
        return this.n == this.items.length;
    }

    public void push(String item) {
        if (!this.isFull()) {
			items[n] = item;
			n++;
			return;
		}
		System.out.println("Unable to add " + item
				+ " to ArrayStackOfIntegers because it is full.");
		return;
    }

    public String pop() {
        n--;
        		return items[n];
    }

}
