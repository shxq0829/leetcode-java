import edu.princeton.cs.algs4.*;
public class HasCycle {
    private static class ListNode {
         int val;
         ListNode next;
         ListNode(int x) {
              this.val = x;
         }
    }
    public static boolean hascycle(ListNode head) {
         ListNode slow = head,fast = head;
         int cnt1 = 0;
         while(fast != null && fast.next != null) {
              slow = slow.next;
              fast = fast.next.next;
              cnt1++;
              if(slow == fast) {
                   StdOut.println("cnt1= " + cnt1);
                   return true;
              }
         }
         return false;         
    }
    public static void main(String[] args) {
         ListNode l1 = new ListNode(1);
         ListNode l2 = new ListNode(2);
         ListNode l3 = new ListNode(3);
         ListNode l4 = new ListNode(4);       
         ListNode l5 = new ListNode(5);       
         ListNode l6 = new ListNode(5);       
         ListNode l7 = new ListNode(5);       
         ListNode l8 = new ListNode(5);       
         ListNode l9 = new ListNode(5);
         l1.next = l2;
         l2.next = l3;
         l3.next = l4;
         l4.next = l5;
         l5.next = l6;        
         l6.next = l7;
         l7.next = l8;
         l8.next = l9;
         l9.next = l3;
         boolean ret = hascycle(l1);
         StdOut.println(ret); 
    }    
}