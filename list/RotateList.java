import edu.princeton.cs.algs4.*;
public class RotateList {
    private static class ListNode {
         private int val;
         private ListNode next;
         ListNode (int x ) {
              this.val = x;
              next = null;
         }        
    } 
    public static ListNode rotatelist (ListNode head,int k) {
         if(head == null || k == 0) return head;
         int len = 1;
         ListNode p = head;
         while(p.next != null) {
              len++;
              p = p.next;
         }
         k = len - k%len;
         p.next = head;
         for(int step = 0;step < k;step++) {
              p = p.next;
         }
         head = p.next;
         p.next = null;
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
         ListNode ret = rotatelist(l1,2);
         for (ListNode l = ret;l != null;l = l.next) 
               StdOut.print(l.val + " -> ");    
         StdOut.println("null"); 
    }    
}