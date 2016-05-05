import edu.princeton.cs.algs4.*;
public class IsBalanced {
  public static class TreeNode {
    private int val;
    private TreeNode left;
    private TreeNode right;
    TreeNode(int x) {
      this.val = x;
      left = null;
      right = null;
    }
  }
  public static boolean isbalanced(TreeNode root) {
    if(root == null) return true;
    if(root.left == null && root.right == null) return true;
    if(Math.abs(depth(root.left) - depth(root.right)) > 1) return false;
    return isbalanced(root.left) && isbalanced(root.right);
  }
  public static int depth(TreeNode root) {
    if(root == null) return 0;
    return Math.max(depth(root.left),depth(root.right)) +1;
  }
  public static void main(String[] args) {
    TreeNode tn1 = new TreeNode(1);
    TreeNode tn2 = new TreeNode(2);
    TreeNode tn3 = new TreeNode(3);
    TreeNode tn4 = new TreeNode(4);
    TreeNode tn5 = new TreeNode(5);
    tn1.left = tn2;
    tn1.right = tn4;
    tn2.left = null;
    tn2.right = tn3;
    tn4.left = null;
    tn4.right = tn5;
    StdOut.println(isbalanced(tn1));
  }
}
