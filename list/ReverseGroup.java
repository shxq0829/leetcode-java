import edu.princeton.cs.algs4.*;
public class ReverseGroup {
    private static class ListNode {
         private int val;
         private ListNode next;
         ListNode (int x ) {
              this.val = x;
              next = null;
         }        
    } 
    public static ListNode reversegroup (ListNode head,int k) {
         if(head == null || k <2) return head;
         ListNode prehead = new ListNode(0);
         prehead.next = head;
         int cnt = 0;
         ListNode node = head; //迭代结点
         ListNode lasttail = prehead; //上次k个结点反转后的尾结点
         ListNode curtail = head; // 这次要反转的k个结点的尾结点
         ListNode curhead = head; //这次要反转的k个结点头结点
         ListNode posthead = null; //头结点后面一个结点
         while(node != null) {
              cnt ++ ;
              node = node.next;
              if(cnt == k) {
                   ListNode tmp = curtail.next;//?
                   while (tmp != node) {
                        posthead = curhead;
                        curhead = tmp;
                        tmp = tmp.next;
                        curhead.next = posthead;
                   }
                   lasttail.next = curhead;
                   lasttail = curtail;
                   curtail = node;
                   curhead = node;
                   cnt = 0;                 
              }
              lasttail.next = curhead;
         }
         return prehead.next;
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
         ListNode ret = reversegroup(l1,3);
         for (ListNode l = ret;l != null;l = l.next) 
               StdOut.print(l.val + " -> ");    
         StdOut.println("null"); 
    }    
}