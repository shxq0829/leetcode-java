import edu.princeton.cs.algs4.*;
public class LengthWord {
  public static int lengthword(String str) {
    char[] c = str.toCharArray();
    int len = 0;
    int i = 0;
    while(i < c.length) {
      if (c[i] != ' ') {
        i++;
        len++;
      } else {
        i++;
        len = 0;
      }
    }
    return len;
  }
  public static void main(String[] args) {
      String str = "hello world la la l";
      StdOut.println("last world length = " + lengthword(str));
  }
}
