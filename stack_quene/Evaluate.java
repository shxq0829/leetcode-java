import edu.princeton.cs.algs4.*;
public class Evaluate {
    public static int evalRPN(String[] tokens) {
        int ret = 0;
        Stack<Integer> num = new Stack<Integer>();
        for (int i = 0; i < tokens.length; i++) {
        	if (isOperator(tokens[i])) {
        		int b = num.pop();
        		int a = num.pop();
        		num.push(calc(a, b, tokens[i]));
        	} else {
        		num.push(Integer.valueOf(tokens[i]));
        	}
        }
        ret = num.pop();
        return ret;
    }

	private static boolean isOperator(String str) {
		if (str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/"))
			return true;
		return false;
	}

	private static int calc(int a, int b, String operator) {
		char op = operator.charAt(0);
		switch (op) {
		case '+': return a + b;
		case '-': return a - b;
		case '*': return a * b;
		case '/': return a / b;
		}
		return 0;
	}
  
  public static void main(String[] args) {
    StdOut.println(evalRPN(args));
  }
}
