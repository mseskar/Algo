import java.util.Arrays;

//import edu.princeton.cs.algs4.In;
//import edu.princeton.cs.algs4.Stopwatch;


/******************************************************************************
 *  Compilation:  javac TwoSum.java
 *  Execution:    java TwoSum input.txt
 *  Dependencies: StdOut.java In.java Stopwatch.java
 *  Data files:   http://algs4.cs.princeton.edu/14analysis/1Kints.txt
 *                http://algs4.cs.princeton.edu/14analysis/2Kints.txt
 *                http://algs4.cs.princeton.edu/14analysis/4Kints.txt
 *                http://algs4.cs.princeton.edu/14analysis/8Kints.txt
 *                http://algs4.cs.princeton.edu/14analysis/16Kints.txt
 *                http://algs4.cs.princeton.edu/14analysis/32Kints.txt
 *                http://algs4.cs.princeton.edu/14analysis/1Mints.txt
 *
 *  A program with n^2 running time. Reads n integers
 *  and counts the number of pairs that sum to exactly 0.
 *
 *
 *  Limitations
 *  -----------
 *     - we ignore integer overflow
 *
 *
 *  % java TwoSum 2Kints.txt
 *  2
 *
 *  % java TwoSum 1Kints.txt
 *  1
 *
 *  % java TwoSum 2Kints.txt
 *  2
 *
 *  % java TwoSum 4Kints.txt
 *  3
 *
 *  % java TwoSum 8Kints.txt
 *  19
 *
 *  % java TwoSum 16Kints.txt
 *  66
 *
 *  % java TwoSum 32Kints.txt
 *  273
 *
 ******************************************************************************/
public class TwoSum_MiS {

    // print distinct pairs (i, j) such that a[i] + a[j] = 0
    public static void printAll(int[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if (a[i] + a[j] == 0) {
                    StdOut.println(a[i] + " " + a[j]);
                }
            }
        }
    }

    public static int binarySearch(int[] a, int key) {
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
    	Arrays.sort(a);
        int n = a.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if(a[i]>0)
            {
            	if(binarySearch(a,-a[i]) >= 0)
            	{
            		count++;
            	}
            }
        }
        return count;
    }

    public static void main(String[] args)  {
        In in = new In(args[0]);
        int[] a = in.readAllInts();
        Stopwatch timer = new Stopwatch();
        int count = count(a);
        StdOut.println("Elapsed time = " + timer.elapsedTime());
        StdOut.println(count);
    }
}
//Output
/*
Milos@Milos-PC MINGW64 ~/Documents/+PHS/Algo (master)
$ java TwoSum_MiS 8Kints.txt
Elapsed time = 0.005
19
*/
