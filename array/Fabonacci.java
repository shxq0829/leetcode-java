import edu.princeton.cs.algs4.*;
public class Fabonacci {
    public static int climbStairs (int n) {
         int prev = 0;
         int cur = 1;
         for (int i =1; i <= n ;++i) {
              int tmp = cur;
              cur += prev;
              prev = tmp;
         }
         return cur;
    }
    /*
     * 递归法，缺点太慢。
     */
    public static int climbStairs2(int n) {
         if(n == 1) return 1;
         if(n == 2) return 2;
         return climbStairs2(n-1) + climbStairs2(n-2);
    }
    /*
     * 动态规划法填表，提高效率
     */
    public static int climbStairs3(int n) {
         int[] res = new int[n +1];
         res[0] = 1;
         res[1] = 1;
         for (int i = 2;i <= n;++i) {
              res[i] = res[i-1] + res[i-2];
         }
         return res[n];
    }    
    /*
     * 数学公式法
     */
    public static double climbStairs_math(int n) {
         double s = Math.sqrt(5);
         return Math.floor((Math.pow((1.0+s)/2,n+1) - Math.pow((1.0-s)/2,n+1))/s + 0.5);
    }
    public static void main(String[] args) {
         int N = Integer.parseInt(args[0]);
         StdOut.println("climbStairs2 " + N + " steps has " + climbStairs2(N) + " method!!");
         StdOut.println("climbStairs " + N + " steps has " + climbStairs(N) + " method!!");
         StdOut.println("climbStairs3 " + N + " steps has " + climbStairs3(N) + " method!!");
         StdOut.println("climbStairs_math " + N + " steps has " + climbStairs_math(N) + " method!!");
    }
}