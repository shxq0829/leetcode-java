import edu.princeton.cs.algs4.*;
public class SwapPairs {
    private static class ListNode {
         private int val;
         private ListNode next;
         ListNode (int x ) {
              this.val = x;
              next = null;
         }        
    } 
    public static ListNode swappairs (ListNode head) {
         if(head == null || head.next == null) return head;
         ListNode dummy = new ListNode(0);
         dummy.next = head;
         for(ListNode pre = dummy,cur = pre.next,next = cur.next;next != null;pre = cur,cur = cur.next,next=cur!=null?cur.next:null) {
              pre.next = next;
              cur.next = next.next;
              next.next = cur;
         }
         
         return dummy.next;
    }
  
    public static void main(String[] args) {
         ListNode l1 = new ListNode(1);
         ListNode l2 = new ListNode(2);
         ListNode l3 = new ListNode(3);
         ListNode l4 = new ListNode(4);       
         ListNode l5 = new ListNode(5);       
         ListNode l6 = new ListNode(6);
         l1.next = l2;
         l2.next = l3;
         l3.next = l4;
         l4.next = l5;
         l5.next = l6;
         l6.next = null;        
         ListNode ret = swappairs(l1);
         for (ListNode l = ret;l != null;l = l.next) 
               StdOut.print(l.val + " -> ");    
         StdOut.println("null"); 
    }    
}