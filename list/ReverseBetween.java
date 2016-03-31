import edu.princeton.cs.algs4.*;
public class ReverseBetween {  
    // Divide the list to three parts:   
    // 1)Nodes before m keep still;   
    // 2)Traverse m~n nodes;  
    // 3)Nodes after n keep still.  
    private static class ListNode {
         private int val;
         private ListNode next;
         ListNode (int x ) {
              this.val = x;
              next = null;
         }        
    } 
    public static ListNode reverseBetween(ListNode head, int m, int n) {  
        if (m == n) return head;  
          
        ListNode preHead = new ListNode(0);  
        preHead.next = head;  
          
        // The (m-1) node is the tail of first tail.  
        ListNode firstTail = preHead;  
        int k = m - 1;  
        while (k-- > 0) {  
            firstTail = firstTail.next;  
        }  
          
        // The m-th node is the traversed tail.  
        ListNode secondTail = firstTail.next;  
          
        // Traverse m~n nodes, and get the traversed head.  
        ListNode tmpHead = null;  
        ListNode tmpNext = null;  
        ListNode node = firstTail.next;  
        k = n - m + 1;  
        while (k-- > 0) {  
            tmpHead = node;  
            node = node.next;  
              
            tmpHead.next = tmpNext;  
            tmpNext = tmpHead;  
        }  
          
        // Connect three parts.  
        firstTail.next = tmpHead;  
        secondTail.next = node;  
          
        return preHead.next;  
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
         ListNode ret = reverseBetween(l1,2,4);
         for (ListNode l = ret;l != null;l = l.next) 
               StdOut.print(l.val + " -> ");    
         StdOut.println("null"); 
    }
}  