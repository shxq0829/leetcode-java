import edu.princeton.cs.algs4.*;
public class LongestPalStr {  
    public static String longestPalindrome(String s) {  
        int len = s.length();  
        if (s == null || len == 1){  
            return s;  
        }   
          
        String ret = "";  
        int mid = len / 2;  
        int i = 0;  
        while (true) {  
            //遍历到s两端时，如果以mid+i或mid-i为中心的最长回文都不比当前最优解长，遍历结束  
            if (2*(len-(mid+i)) < ret.length() && 2*(mid-i+1) < ret.length()) {  
                break;  
            }  
            String str1 = palindrome1(s, mid+i);  
            String str2 = palindrome2(s, mid+i);  
            String str3 = palindrome1(s, mid-i);  
            String str4 = palindrome2(s, mid-i);  
            if (str1.length() > ret.length()) {  
                ret = str1;  
            }  
            if (str2.length() > ret.length()) {  
                ret = str2;  
            }  
            if (str3.length() > ret.length()) {  
                ret = str3;  
            }  
            if (str4.length() > ret.length()) {  
                ret = str4;  
            }  
            i++;  
        }  
          
        return ret;  
    }  
      
    //找出s中以index为中心的aba型的回文子串  
    public static String palindrome1(String s, int index) {  
        String ret = "";  
        int i = index, j = index;  
        while (i>=0 && j<s.length()) {  
            if (s.charAt(i) != s.charAt(j)) {  
                break;  
            }  
            ret = s.substring(i, j+1);  
            i--;  
            j++;  
        }  
        return ret;  
    }  
      
    //找出s中以index和index+1为中心的abba型回文子串  
    public static String palindrome2(String s, int index) {  
        String ret = "";  
        int i = index, j = index+1;  
        while (i>=0 && j<s.length()) {  
            if (s.charAt(i) != s.charAt(j)) {  
                break;  
            }  
            ret = s.substring(i, j+1);  
            i--;  
            j++;  
        }  
        return ret;  
    }  
    public static void main(String[] args) {
         String str = StdIn.readString();
         String ret = longestPalindrome(str);
         StdOut.println("longestPalindrome = " + ret);
    }
}  