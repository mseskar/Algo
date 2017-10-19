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
        String input = s.nextLine();
        if(input.length()%2 ==0){
            isPalindrome(input);
        }

        else{
            String inputEven = input.substring(0,input.length()/2) + input.substring(input.length()/2+1);
            isPalindrome(inputEven);
        }
    }
    public static String isPalindrome(String input){
            String st2 = input.substring(input.length()/2);//second half of the string for the stack
            String st1 = input.substring(0, input.length()/2);//first half of the string for the queue
            Queue que = new Queue(); //creates the queue with default constructor
            ArrayStackOfStrings stack = new ArrayStackOfStrings(input.length()/2); //stack with half the lenght of the palindrome, second half
            for(int i=0; i<st1.length(); i++){
                String add = st1.substring(i, i+1);
                que.enqueue(add);//enqueue the first part of the String
            }
            for(int i=0; i<st2.length(); i++){
                String add = st2.substring(i, i+1);
                stack.push(add);//push the last part of the second string
            }
            boolean isPalin = true;
            String sString = "";
            String qString = "";
            int count = 0;
            while(isPalin && (que.size() != 0)){
                qString = que.dequeue();
                count++;
                sString = stack.pop();
                if(sString.equals(qString)) {
                    continue;
                }
                else isPalin = false;
            }
            if(isPalin){
                String yes = "It is a palindrome";
                System.out.println(yes);
                return yes;
            }
            else{
            String no = "It is not a palindrome";
            System.out.println(no);
             return no;
         }
        }
    }
//$ java Palindrome_MiS
//Enter a string to see if it is a palindrome:
//potop
//It is a palindrome

//Milos@Milos-PC MINGW64 ~/Documents/+PHS/Algo (master)
//$ java Palindrome_MiS
//Enter a string to see if it is a palindrome:
//poppoa
//It is not a palindrome

//Milos@Milos-PC MINGW64 ~/Documents/+PHS/Algo (master)
//$ java Palindrome_MiS
//Enter a string to see if it is a palindrome:
//poootooop
