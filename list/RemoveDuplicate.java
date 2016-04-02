import edu.princeton.cs.algs4.*;
public class RemoveDuplicate {
    private static class ListNode {
         private int val;
         private ListNode next;
         ListNode (int x ) {
              this.val = x;
              next = null;
         }        
    } 
    /*
     * 递归版本
     */
    public static ListNode removeduplicate (ListNode head) {
        if (head == null) return head;
        ListNode dummy = new ListNode(head.val + 1);
        dummy.next = head;
        recur(dummy,head);        
        return dummy.next;
    }
    public static void recur (ListNode pre,ListNode cur) {
        if(cur == null) return;
        if(pre.val == cur.val) {
             pre.next = cur.next;
             recur(pre,pre.next);
        } else {
             recur(pre.next,cur.next);
        }
    }
    /*
     * 迭代版本
     */
    public static ListNode removeduplicate2(ListNode head) {
         if(head == null) return null;
         ListNode pre = head,cur = head.next;//pre = head 相当于引用，一个变另一个变
         while(cur != null) {
             if(pre.val == cur.val) pre.next = cur.next;
             else pre = cur;
             cur = pre.next;
         }
         return head;
    }
    public static void main(String[] args) {
         ListNode l1 = new ListNode(1);
         ListNode l2 = new ListNode(1);
         ListNode l3 = new ListNode(3);
         ListNode l4 = new ListNode(4);       
         ListNode l5 = new ListNode(4);
         l1.next = l2;
         l2.next = l3;
         l3.next = l4;
         l4.next = l5;
         l5.next = null;        
         ListNode ret = removeduplicate2(l1);
         for (ListNode l = ret;l != null;l = l.next) 
               StdOut.print(l.val + " -> ");    
         StdOut.println("null"); 
    }    
}