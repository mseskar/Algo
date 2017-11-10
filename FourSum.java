public class FourSum{
    public static int count(int[] a) {
        int n = a.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                for (int k = j+1; k < n; k++) {
                    for(int h = k+1; h < n; h++){
                        if (a[i] + a[j] + a[k] + a[h] == 0) {
                            count++;
                        }
                    }
                }
            }
        }
    return count;
    }

/**
 * Reads in a sequence of integers from a file, specified as a command-line argument;
 * counts the number of triples sum to exactly zero; prints out the time to perform
 * the computation.
 *
 * @param args the command-line arguments
 */
    public static void main(String[] args)  {
        In in = new In(args[0]);
        int[] a = in.readAllInts();

        Stopwatch timer = new Stopwatch();
        int count = count(a);
        StdOut.println("elapsed time = " + timer.elapsedTime());
        StdOut.println(count);
    }
}
