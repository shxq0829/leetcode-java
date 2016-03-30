/*
 * 环形路线上有N个加油站，每个加油站有汽油gas[i]，从
 * 每个加油站到下一站消耗汽油cost[i]，问从哪个加油站
 * 出发能够回到起始点，如果都不能则返回-1（注意，解是唯一的）。
 * 时间复杂度O(n),
 */
import edu.princeton.cs.algs4.*;
public class GasStation {
    public static int judgeComplete (int[] gas,int[] cost) {
         int sum = 0;
         int total = 0;
         int j = -1;
         for(int i = 0;i < gas.length;++i) {
              sum +=gas[i] - cost[i];
              total += gas[i] - cost[i];
              if (sum < 0) {
                   j = i;
                   sum = 0;
              }
         }
         return total>0?j+1:-1;
    }
    public static void main(String[] args) {
        int[] gas = new int[]{5,4,3,6,2,1,7,8,9};
        int[] cost = new int[]{6,2,3,4,5,6,7,8,1};
        int judge = judgeComplete(gas, cost);
        if(-1 == judge)  StdOut.println("Can't complete!!");
        else StdOut.println("Can complete from " + judge);
    }
}