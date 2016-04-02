import edu.princeton.cs.algs4.*;
public class Partition {

    
    public static ListNode partition(ListNode head, int x) {
         ListNode lessHead = new ListNode(0);
         ListNode higherHead = new ListNode(0);
         ListNode node = head, less = lessHead,higher = higherHead;
         while (node != null) {
             ListNode next = node.next;
             if(node.val < x) {
                  less.next = node;
                  less = less.next;
                  less.next = null;
             } else {
                  higher.next = node;
                  higher = higher.next;
                  higher.next = null;
             }
             node = next;
         }
         less.next = higherHead.next;        
         return lessHead.next;
    }

    public static void main(String[] args) {
         ListNode l1 = new ListNode(1);
         ListNode l2 = new ListNode(4);
         ListNode l3 = new ListNode(3);
         ListNode l4 = new ListNode(2);       
         ListNode l5 = new ListNode(5);       
         ListNode l6 = new ListNode(2);
         l1.next = l2;
         l2.next = l3;
         l3.next = l4;
         l4.next = l5;
         l5.next = l6; 
         l6.next = null;
         ListNode ret = partition(l1,3);
         for(ListNode l = ret;l != null ;l = l.next) 
             StdOut.print(l.val + " -> ");
         StdOut.println("null");
    }
}