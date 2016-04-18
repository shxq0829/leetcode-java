import edu.princeton.cs.algs4.*;
public class LongComPrefix {
	public String longcomprefix(String[] str) {
		if (str == null) {
			return null;
		}
		if (str.length == null) {
			return "";		
		}
		String s = str[0];
		int len = s.length();
		for (int i = 0;i < len ; ++i) {
			char c = s.charAt(i);
			for (int j = 1;j < str.length ; ++j) {
				if (str[j].length() <= i || c != str[j].charAt(i)) {
					return s.substring(0,i);
				}
			}
		}
		return s;
	}
} 