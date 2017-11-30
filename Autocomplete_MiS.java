
/**
@mseskar
@11/29/17 (cutting it close lol)
a program to implement autocomplete for a given set of N terms,
where a term is a query string and an associated nonnegative weight.
That is, given a prefix, find all queries that start with the given prefix,
in descending order of weight.
*/
import java.io.*;
import java.util.*;
import java.lang.*;

public class Autocomplete_MiS {
    private Term[] a;

    public Autocomplete_MiS(Term[] terms) {
        if(terms == null || !checkNull(terms))
            throw new NullPointerException("Input array null or array items are null");

        this.a = terms;
        Merge.sort(a);
    }

    private static boolean checkNull(Term[] a) {
        for(int i = 0; i < a.length; i++)
            if(a[i] == null)
                return false;
        return true;
    }

    public Term[] allMatches(String prefix) {
        if(prefix == null)
            throw new NullPointerException("Prefix is null");

        int num = numberOfMatches(prefix);
        Term[] matches = new Term[num];
        int first = first(a, prefix);
        int last = last(a, prefix);

        for(int i = first, k = 0; i <= last; i++, k++)
            matches[k] = a[i];
        Merge.sort(matches, Term.byReverseWeightOrder());
        return matches;
    }

    public int numberOfMatches(String prefix) {
        if(prefix == null)
            throw new NullPointerException("Prefix is null");

        int first = first(a, prefix);
        int last = last(a, prefix);
        return last - first + 1;
    }
/*
Binary search to find first reference of prefix, and last reference to save time. As suggested by the Princeton guy
*/
    private int first(Term[] a, String prefix) {
        return BinarySearch.firstIndexOf(a, new Term(prefix, 0), Term.byPrefixOrder(prefix.length()));
    }

    private int last(Term[] a, String prefix) {
        return BinarySearch.lastIndexOf(a, new Term(prefix, 0), Term.byPrefixOrder(prefix.length()));
    }

    public static void main(String[] args) {
        File f = new File(args[0]);
        Scanner in = null;
        try {
            in = new Scanner(f);
        } catch(FileNotFoundException e) {
            System.err.println("FileNotFoundException: " + e.getMessage());
        }

        int n = in.nextInt();
        Term[] terms = new Term[n];
        for(int i = 0; i < terms.length; i++) {
            long weight = in.nextLong();
            String q = in.nextLine();
            String query = q.trim();
            terms[i] = new Term(query, weight);
        }
        in.close();

        Scanner user = new Scanner(System.in);
        int k = Integer.parseInt(args[1]);
        Autocomplete_MiS autocomplete = new Autocomplete_MiS(terms);
        while (user.hasNextLine()) {
            String prefix = user.nextLine();
            Term[] results = autocomplete.allMatches(prefix);
            for (int i = 0; i < Math.min(k, results.length); i++)
                System.out.println(results[i]);
        }
        user.close();
    }
}
