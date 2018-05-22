/*************************************************************************
 * @mseskar
 * 5/1/18
 *
 * Your first task is to create a data type to model the ring buffer.
 *
 *************************************************************************/
public class RingBuffer{
    private double[] rb;
    private int size = 0;
    private int first = 0;
    private int last = 0;
    private int capacity=0;

    public RingBuffer(int capacity) // create an empty ring buffer, with given max capacity
    {
        rb = new double[capacity];
        capacity=this.capacity;
    }

    public int size() // return number of items currently in the buffer
    {
        return size;
    }

    public boolean isEmpty() // is the buffer empty (size equals zero)?
    {
        return size==0;
    }

    public boolean isFull() // is the buffer full  (size equals capacity)?
    {
    	return size==capacity;
    }

    public void enqueue(double x) // add item x to the end
    {
        if (size<rb.length)
        {
            size++;
        }
        rb[last] = x;
        last = (last+1) % rb.length;
    }

    public double dequeue() // delete and return item from the front
    {
        double item = rb[first];
        rb[first] = 0;
        size--;
        first = (first+1) % rb.length;
        return item;
    }

    public double peek() // return (but do not delete) item from the front
    {
    	return rb[first];
    }
}
