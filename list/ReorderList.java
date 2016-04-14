import edu.princeton.cs.algs4.*;
public class ReorderList {
    private static class ListNode {
         int val;
         ListNode next;
         ListNode(int x) {
              val = x;
              next = null;
         }
    }
    public static ListNode reorderlist(ListNode head) {
         if(head == null || head.next == null ) return null;
         ListNode slow = head, fast = head;
         while (fast.next != null) {
              fast = fast.next;
              if(fast.next != null) fast= fast.next;
              else break;
              slow = slow.next;
         }
         ListNode head1 = head , head2 = slow.next;
         slow.next = null;
         //反转后半部分
         ListNode cur = head2,post = cur.next;
         cur.next = null;
         while(post != null) {
              ListNode tmp = post.next;
              post.next = cur;
              cur = post;
              post = tmp;
         }
         head2 = cur;
         
         //合并两部分链表
         ListNode node1 = head1, node2 = head2;
         while(node2 != null) {
              ListNode tmp1 = node1.next;
              ListNode tmp2 = node2.next;
              node1.next = node2;
              node2.next = tmp1;
              node1 = tmp1;
              node2 = tmp2;
         }
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
         ListNode ret = reorderlist(l1);
         for (ListNode l = ret;l != null;l = l.next) 
               StdOut.print(l.val + " -> ");    
         StdOut.println("null"); 
    }
}