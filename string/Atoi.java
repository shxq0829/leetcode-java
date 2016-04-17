import edu.princeton.cs.algs4.*;
public class Atoi {
	public static int atoi(String str) {
		int num = 0;
		int sign = 1;
		int n = str.length();
		int i = 0;
		while(str.charAt(i) == ' ' && i < n ) i++;
		if (str.charAt(i) == '+') {
			i++;
		} else {
			i++;
			sign = -1;
		}
		for (; i < n; ++i) {
			if (str.charAt(i) > '9' || str.charAt(i) < '0') {
				break;
			}
			if (num > Integer.MAX_VALUE/10 || (num == Integer.MAX_VALUE/10 && (str.charAt(i) - '0' > Integer.MAX_VALUE%10))) {
				return sign == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
			}
			num = num * 10 + str.charAt(i) - '0';
		}
		return num;
	}
	public static void main(String[] args) {
		StdOut.println(args[0] + " = " + atoi(args[0]));
	}
}