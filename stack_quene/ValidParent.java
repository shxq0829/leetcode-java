import edu.princeton.cs.algs4.*;
public class ValidParent {
  private static final char LEFT_PAREN = '(';
  private static final char RIGHT_PAREN = ')';
  private static final char LEFT_BRACKET = '[';
  private static final char RIGHT_BRACKET = ']';
  private static final char LEFT_BRACE = '{';
  private static final char RIGHT_BRACE = '}';
  public static boolean isValid(String str) {
    Stack<Character> stack = new Stack<Character>();
    for (int i = 0; i < str.length(); ++i) {
      if(str.charAt(i) == LEFT_PAREN) stack.push(LEFT_PAREN);
      if(str.charAt(i) == LEFT_BRACKET) stack.push(LEFT_BRACKET);
      if(str.charAt(i) == LEFT_BRACE) stack.push(LEFT_BRACE);
      if (str.charAt(i) == RIGHT_PAREN) {
        if(stack.isEmpty()) return false;
        if(stack.pop() != LEFT_PAREN) return false;
      }
      if (str.charAt(i) == RIGHT_BRACKET) {
        if(stack.isEmpty()) return false;
        if(stack.pop() != LEFT_BRACKET) return false;
      }
      if (str.charAt(i) == RIGHT_BRACE) {
        if(stack.isEmpty()) return false;
        if(stack.pop() != LEFT_BRACE) return false;
      }
    }
    return stack.isEmpty();
  }
  public static void main(String[] args) {
    String s = StdIn.readString();
    StdOut.println(isValid(s));
  }
}
