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
public class ArrayStackOfIntegers implements Iterable {
    private Integer[] items;  // holds the items
    private int n;             // number of items in stack
    //creates new stack of capca
    public ArrayStackOfIntegers(int capacity) {
        this.n = 0;
		this.items = new Integer[capacity];
    }
//is the stack empty?
    public boolean isEmpty() {
        return this.n == 0;
    }
//is the stack full?
    public boolean isFull() {
        return this.n == this.items.length;
    }

    public void push(Integer item) {
        if (!this.isFull()) {
			items[n] = item;
			n++;
			return;
		}
		System.out.println("Unable to add " + item.toString()
				+ " to ArrayStackOfIntegers because it is full.");
		return;
    }

    public Integer pop() {
        n--;
        		return items[n];
    }

    public Iterator iterator() {
        return new ReverseArrayIterator();
    }
//mseskar
//10/10/17
    private class ReverseArrayIterator implements Iterator<Integer> {
        int pos;
        		public ReverseArrayIterator() {
        			pos = n - 1;
        		}

        		public boolean hasNext() {
        			return pos != -1;
        		}
                @Override
        		public Integer next() {
        			pos--;
        			return items[pos + 1];
        		}

                public void remove(){

                }
    }
}
