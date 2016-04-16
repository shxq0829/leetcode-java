import edu.princeton.cs.algs4.*;
public class IsPal {
	public static boolean ispal(String s) {
		if (s == null || s.length() < 2) {
			return true;
		}
		boolean flag = true;
		char[] ch = s.toCharArray();
		int len = s.length();
		int i = 0, j = len -1;
		while(i < j) {
			if (!((ch[i] <= 'Z' && ch[i] >= 'A')||(ch[i] <= 'z' && ch[i] >= 'a')||(ch[i] <= '9' && ch[i] >= '0'))) {
				i++;
				continue;
			}
			if (!((ch[j] <= 'Z' && ch[j] >= 'A')||(ch[j] <= 'z' && ch[j] >= 'a')||(ch[j] <= '9' && ch[j] >= '0'))) {
				j--;
				continue;
			}
			if (ch[i] <= 'Z' && ch[i] >= 'A') {
				ch[i] += 'a' - 'A';
			}
			if (ch[j] <= 'Z' && ch[j] >= 'A') {
				ch[j] += 'a' - 'A';
			}
			if (ch[i] != ch[j]) {
				flag = false;
				break;
			} else {
				i++;
				j--;
			}		
		}
		return flag;
	}
	public static void main(String[] args) {
		String str = StdIn.readString();
		StdOut.println(ispal(str));
	}
}