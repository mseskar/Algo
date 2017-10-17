import java.util.Scanner;
import java.util.StringTokenizer;
/*
Create a system using a stack and a queue to test whether a given string is a palindrome (i.e., the characters read the same forward or backward).
mseskar
10/17/17
*/
public class Palindrome_MiS{
    public static void main(String [] args){
        Scanner s = new Scanner(System.in);
        System.out.println("Enter a string to see if it is a palindrome: ");
        String num = s.nextLine();
        StringTokenizer st = new StringTokenizer(s, " ");
        ArrayStackOfStrings stack = new ArrayStackOfStrings(num.length()/2); //stack with half the lenght of the palindrome, second half 
    }
}
