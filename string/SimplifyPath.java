import edu.princeton.cs.algs4.*;
import java.util.*;

public class SimplifyPath {
    public static String simplifyPath(String path) {
        LinkedList<String> queue = new LinkedList<String>();
        String[] names = path.split("/");

        for (int i = 0; i < names.length; i++) {
            if ("".equals(names[i]) || ".".equals(names[i])) continue;

            if ("..".equals(names[i])) {
                if (!queue.isEmpty()) {
                    queue.pollLast();
                }
            } else {
                queue.add(names[i]);
            }
        }

        StringBuilder newPath = new StringBuilder();
        while (!queue.isEmpty()) {
            newPath.append("/");
            newPath.append(queue.pollFirst());
        }

        if (newPath.length() == 0) return "/";

        return newPath.toString();
    }
    public static void main(String[] args) {
      String ret = simplifyPath(args[0]);
      StdOut.println(ret);
    }
}
