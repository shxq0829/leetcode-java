import edu.princeton.cs.algs4.*;
public class Candy {  
    public static int candy(int[] ratings) {  
        int size = ratings.length;  
        if (size == 0) return -1;  
        if (size == 1) return 1;  
          
        int[] cans = new int[size];  
        cans[0] = 1;  
        //正向扫描一遍，如果右边的rating比左边高，那么右边的糖果数就比左边多一个，否则只给一个糖果  
        for (int i = 1; i < size; i++) {  
            if (ratings[i] > ratings[i - 1]) cans[i] = cans[i - 1] + 1;  
            else cans[i] = 1;  
        }  
        //反向扫描一遍，如果左边的rating比右边高，并且左边的糖果数比右边少，那么左边的糖果数应比右边多一  
        for (int i = size - 2; i >= 0; i--) {  
            if (ratings[i] > ratings[i + 1] && cans[i] <= cans[i + 1]) {  
                cans[i] = cans[i + 1] + 1;  
            }  
        }  
          
        int ret = 0;  
        for (int i = 0; i < size; i++) {  
            ret += cans[i];  
        }  
          
        return ret;  
    }  
    public static void main(String[] args){
        int[] rating = new int[]{4,5,4,4,3,2,3};
        int total = candy(rating);
        StdOut.println("The least total is " + total);
    }
}  
