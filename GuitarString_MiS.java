/*************************************************************************
 * @mseskar
 * 5/1/18
 *
 * Write a program to simulate plucking a guitar string using the Karplus-Strong algorithm. This algorithm played a seminal role in the emergence of physically modeled sound synthesis (where a physical description of a musical instrument is used to synthesize sound electronically) *
 *************************************************************************/
public class GuitarString_MiS {

	private final double  DECAY_FACTOR = 0.996;
	private RingBuffer rb;
	private int N;

	public GuitarString_MiS(double frequency)
	{
		N = Math.round((float)(44100/frequency));
		rb = new RingBuffer(N);
		for(int i=0; i<N-1; i++)
		{
			rb.enqueue(0.0);
		}
	}

	public GuitarString_MiS(double[] init)
	{
		N = init.length;
		rb = new RingBuffer(N);
		for(Double values: init)
		{
			rb.enqueue(values);
		}

		System.out.println(rb);
	}

	public void pluck() //act of striking new note, i.e. "plucking string"
	{
		for(int i = 0; i < N; i++)
		{
			rb.enqueue(Math.random() - 0.5);
			rb.dequeue();
		}
    }

	public void tic()//delay factor to effect reverb
	{
	    double first = rb.dequeue();
		double second = rb.peek();
		rb.enqueue(DECAY_FACTOR*0.5*(first+second));
	}

	public double sample()
	{
		return rb.peek();
	}



}
