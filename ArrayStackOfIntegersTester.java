import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Implement the ArrayStack ADT using arrays. Look at the API in the class
 * website. Design and implement a client to calculate the following postfix
 * expression: 8 4 -3 * 1 5 + / *
 *
 * @mseskar
 * @10/11/17
 *
 */
public class ArrayStackOfIntegersTester {
	//throw exception if too many operators
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		sc.close();
		StringTokenizer IntCount = new StringTokenizer(s, " ");
		StringTokenizer Compute = new StringTokenizer(s, " ");
		ArrayStackOfIntegers stack = new ArrayStackOfIntegers(count(IntCount));//determines the amount of Integers in the string, creates a stack of that size
		while (Compute.hasMoreTokens()) {//goes through the whole postfix expression
			String as = Compute.nextToken();
			try {
				stack.push(Integer.parseInt(as));//adds the integers to the stack

			} catch (NumberFormatException e) {//if the character is not an integer
				Integer num1 = 0;
				Integer num2 = 0;
				if (!stack.isEmpty())
					num1 = stack.pop();//obtains the first operand
				else
					throw new Exception("Too many operators");
				if (!stack.isEmpty())
					num2 = stack.pop();//obtains the second operand
				else
					throw new Exception("Too many operators");
				stack.push(compute(num2, as, num1));//adds the result of the operation to the top of the stack
			}
		}
		System.out.println("Result = " + stack.pop());//removes the top of the stack (the result of the operation) and returns it
	}
//operator 1, operator 2, exception if not an operator
	private static Integer compute(Integer num2, String operation, Integer num1) throws Exception {
		switch (operation) {
		case "*"://if operator is multiplication
			return num1 * num2;
		case "+"://if operator is addition
			return (num1 + num2);
		case "-"://if operator is subtraction
			return num2 - num1;
		case "/"://if operator is division
			return num2 / num1;
		default://if operator is not valid
			throw new Exception("That is not a valid operator");
		}

	}

	//String Tokenizer used to count number of integers in postfix expression
	private static int count(StringTokenizer st) {
		int count = 0;
		while (st.hasMoreTokens()) {
			try {//try to see if the symbols in the tokenizer are integers, if not, catch the exception
				Integer.parseInt(st.nextToken());
				count++;
			} catch (NumberFormatException e) {
			}
		}
		return count;//amount of integers in the postfix expression
	}
}

//Output:
//$ java ArrayStackOfIntegersTester
//8 4 -3 * 1 5 + / *
//Result = -16
