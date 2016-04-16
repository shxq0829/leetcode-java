import edu.princeton.cs.algs4.*;
public class StrStr {
	public static int strStr(String needle,String haystack) {
		for(int i = 0; ; ++i) {
			for (int j = 0; ; ++j) {
				if (j == needle.length()) {
					return i;
				}
				if (i + j == haystack.length()) {
					return -1;
				}
				if (needle.charAt(j) != haystack.charAt(i + j)) {
					break;
				}
			}
		}
	}
	public static void main(String[] args) {
		StdOut.println("haystack is: ");
		String haystack = StdIn.readString();
		StdOut.println("needle is: ");
		String needle = StdIn.readString();
		int position = strStr(needle,haystack);
		StdOut.println("position is " + position);
	}
}