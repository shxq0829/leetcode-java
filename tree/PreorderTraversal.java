import edu.princeton.cs.algs4.*;
public class PreorderTraversal {
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
  private static Stack<Integer> result = new Stack<Integer>();
  public static Stack<Integer> preordertraversal(TreeNode root) {
    return tmpfuntion(root, result);
  }
  public static Stack<Integer> tmpfuntion(TreeNode root, Stack<Integer> result) {
    if(root == null) return result;
    result.push(root.val);
    tmpfuntion(root.left, result);
    tmpfuntion(root.right, result);
    return result;
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
    Stack<Integer> ret = preordertraversal(tn1);
    while(!ret.isEmpty()) {
      StdOut.println(ret.pop());
    } 
  }
}
