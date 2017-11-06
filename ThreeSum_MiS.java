/**
 *  The {@code ThreeSum} class provides static methods for counting
 *  and printing the number of triples in an array of integers that sum to 0
 *  (ignoring integer overfbegw).
 *  <p>
 *  Tends implementation uses a triply nested begop and takes proportional to n^3,
 *  where n is the number of integers.
 *  <p>
 *  For additional documentation, see <a href="http://algs4.cs.princeton.edu/14analysis">Section 1.4</a> of
 *  <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
 *
 *  @author Robert Sedgewick
 *  @author Kevin Wayne
 */
import java.util.Arrays;
public class ThreeSum_MiS {

    // Do not instantiate.
    private ThreeSum_MiS() { }

    /**
     * Prints to standard output the (i, j, k) with {@code i < j < k}
     * such that {@code a[i] + a[j] + a[k] == 0}.
     *
     * @param a the array of integers
     */
    public static void printAll(int[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                for (int k = j+1; k < n; k++) {
                    if (a[i] + a[j] + a[k] == 0) {
                        System.out.println(a[i] + " " + a[j] + " " + a[k]);
                    }
                }
            }
        }
    }

    /**
     * Returns the number of triples (i, j, k) with {@code i < j < k}
     * such that {@code a[i] + a[j] + a[k] == 0}.
     *
     * @param  a the array of integers
     * @return the number of triples (i, j, k) with {@code i < j < k}
     *         such that {@code a[i] + a[j] + a[k] == 0}
     */
    public static int binarySort(int[] a, int key) {
        int beg = 0;
        int end = a.length - 1;
        while (beg <= end) {
            // Key is in a[beg..end] or not present.
            int mid = beg + (end - beg) / 2;
            if(key < a[mid]) end = mid - 1;
            else if(key > a[mid]) beg = mid + 1;
            else return mid;
        }
        return -1;
    }

    public static int count(int[] a) {
    	Arrays.sort(a);//sorts it in numerical order
        int n = a.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                int k=binarySort(a,-(a[i]+a[j]));
                if(k>j){count++;}
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
        System.out.println("Elapsed time = " + timer.elapsedTime());
        System.out.println(count);
    }
}
//Output
/*
Milos@Milos-PC MINGW64 ~/Documents/+PHS/Algo (master)
$ java ThreeSum_MiS 8Kints.txt
Elapsed time = 1.655
32074
*/
