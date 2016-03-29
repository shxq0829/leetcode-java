/**********************
  * สýื้2.1.16
  */
import edu.princeton.cs.algs4.*;
public class RotateImage {
    public static void rotate(int[][] A) {
         int n = A.length;
         for (int i = 0;i < n; ++i) {
             for(int j = 0;j < n-i; ++j) {
                  int swap = A[i][j];
                  A[i][j] = A[n-1-j][n-1-i];
                  A[n-1-j][n-1-i] = swap;
             }
         }
         for (int i = 0;i < n/2; ++i) {
             for(int j = 0;j < n; ++j) {
                  int swap = A[i][j];
                  A[i][j] = A[n-1-i][j];
                  A[n-1-i][j] = swap;
             }         
         }
    }
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        rotate(matrix);
        int N = Integer.parseInt(args[0]);
        for(int i = 0 ;i < N; ++i) {
             int m = i / 3;
             int n = i % 3;
             if(n == 2) StdOut.println(matrix[m][n]);
             else 
                 StdOut.print(matrix[m][n] + " ");
        }
    }
}