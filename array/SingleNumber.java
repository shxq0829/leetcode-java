import edu.princeton.cs.algs4.*;
public class SingleNumber {
    public static int singleNumberfromtwo(int[] nums) {
        int x = 0;
        for(int i=0;i< nums.length;++i) {
             x ^= nums[i];
        }
        return x;
    }
    public static int singleNumberfromthree(int[] nums) {
         int[] bit = new int[32];
         int res = 0;
         for(int i = 0 ;i<bit.length; ++i) bit[i] = 0;
         for(int i = 0;i < bit.length; ++i) {
              for(int j=0;j < nums.length;++j) {
               bit[i] += (nums[j]>>i)&1;
          }              
              res |= bit[i]%3<<i;
         }
         return res;
         
    }
    public static int singleNumberfromthree2(int[] nums) {
        int one=0, two=0, three=0;  
        for(int i=0; i<nums.length; i++){  
            two |= one&nums[i];  
            one^=nums[i];  
            //cout<<one<<endl;  
            three=one&two;  
            one&= ~three;  
            two&= ~three;  
        }  
        return one;  
         
    }
    public static void main(String[] args) {
        int[] nums = new int[]{3,2,1,2,3};
        int[] nums2 = new int[]{3,2,1,2,3,3,2};
        StdOut.println("singleNumber is " + singleNumberfromtwo(nums));
        StdOut.println("singleNumber is " + singleNumberfromthree(nums2));
        StdOut.println("singleNumber is " + singleNumberfromthree2(nums2));
    }
}