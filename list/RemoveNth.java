import edu.princeton.cs.algs4.*;
public class RemoveNth {
    private static class ListNode {
         private int val;
         private ListNode next;
         ListNode (int x ) {
              this.val = x;
              next = null;
         }        
    } 
    public static ListNode remove_nth (ListNode head,int n) {
         if(head == null || n == 0) return head;
         ListNode p = head,q = head;
         for(int k = 0;k < n;++k) {
              q = q.next;
         }
         while (q.next != null) {
              p = p.next;
              q = q.next;
         }
         p.next = p.next.next;
         return head;
    }
  
    public static void main(String[] args) {
         ListNode l1 = new ListNode(1);
         ListNode l2 = new ListNode(2);
         ListNode l3 = new ListNode(3);
         ListNode l4 = new ListNode(4);       
         ListNode l5 = new ListNode(5);
         l1.next = l2;
         l2.next = l3;
         l3.next = l4;
         l4.next = l5;
         l5.next = null;        
         ListNode ret = remove_nth(l1,2);
         for (ListNode l = ret;l != null;l = l.next) 
               StdOut.print(l.val + " -> ");    
         StdOut.println("null"); 
    }    
}