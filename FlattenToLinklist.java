import edu.princeton.cs.algs4.*;
import common.TreeNode;
public class FlattenToLinklist {
  // public static class TreeNode {
  //   private int val;
  //   private TreeNode left;
  //   private TreeNode right;
  //   TreeNode(int x) {
  //     this.val = x;
  //     left = null;
  //     right = null;
  //   }
  // }
    private static TreeNode flattenTree(TreeNode root) {
            if (root == null) {
                return null;
            }
            TreeNode tail = root;
            TreeNode right = root.right;
            if (root.left != null) {
                tail = flattenTree(root.left);
                root.right = root.left;
                tail.right = right;
                root.left = null;
            }
            if (right != null) {
                tail = flattenTree(right);
            }
            return tail;
        }

   public static void flatten(TreeNode root) {
            flattenTree(root);
        }
   public static void main(String[] args) {
     TreeNode tn1 = new TreeNode(1);
     TreeNode tn2 = new TreeNode(2);
     TreeNode tn3 = new TreeNode(3);
     TreeNode tn4 = new TreeNode(4);
     TreeNode tn5 = new TreeNode(5);
     TreeNode tn6 = new TreeNode(6);
     tn1.left = tn2;
     tn1.right = tn5;
     tn2.left = tn3;
     tn2.right = tn4;
     tn5.left = null;
     tn5.right = tn6;
     flatten(tn1);
     while (tn1 != null) {
       StdOut.println(tn1.val);
       tn1 = tn1.right;
     }
  }
}
