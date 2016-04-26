import edu.princeton.cs.algs4.*;
import java.util.*;
public class Anagrams {
    public static List<String> anagrams(String[] strs) {
        if (strs.length < 1) return null;
        List<String> ans = new ArrayList<String>();
        String[] strs2 = new String[strs.length];
        for (int i = 0; i < strs.length; i++) {
            char[] chs = strs[i].toCharArray();
            Arrays.sort(chs);
            strs2[i] = String.valueOf(chs);
        }
        
        boolean[] flags = new boolean[strs.length];
        Arrays.fill(flags, false);
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i < strs2.length; i++) {
            if (map.containsKey(strs2[i])) {
                int last = map.put(strs2[i], i);
                flags[last] = true;
                flags[i] = true;
            } else {
                map.put(strs2[i], i);
            }
        }
        
        for (int i = 0; i < strs.length; i++) {
            if (flags[i]) {
                ans.add(strs[i]);
            }
        }
        
        return ans;
    }
    public static void main(String[] args) {
        List<String> ret = new ArrayList<String>();
        ret = anagrams(args);
        for (String tmp:ret ) {
             StdOut.println(tmp);   
        }
    }
}