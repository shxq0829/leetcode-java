import edu.princeton.cs.algs4.*;
public class AddTwoNum {  
    private static class ListNode {
         private int val;
         private ListNode next;
         ListNode (int x ) {
              this.val = x;
              next = null;
         }        
    } 
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {  
        if (l1 == null) return l2;  
        if (l2 == null) return l1;  
          
        //把相加后的结果存放于链表1，pre1是用于最后有进位时在其后new新结点  
        ListNode ret = l1;  
        ListNode pre1 = new ListNode(0);  
        pre1.next = l1;  
          
        int flag = 0;  
        while (l1 != null && l2 != null) {  
            l1.val = l1.val + l2.val + flag;  
            flag = l1.val / 10;  
            l1.val = l1.val % 10;  
            pre1 = l1;  
            l1 = l1.next;  
            l2 = l2.next;  
        }  
          
        //如果链表2有剩余，接到链表1的后面  
        if (l2 != null) {  
            pre1.next = l2;  
            l1 = l2;  
        }  
          
        while (l1 != null) {  
            l1.val += flag;  
            flag = l1.val / 10;  
            l1.val = l1.val % 10;  
            pre1 = l1;  
            l1 = l1.next;  
        }  
          
        if (flag > 0) {  
            ListNode node = new ListNode(1);  
            pre1.next = node;  
        }  
          
        return ret;  
    }
    public static void main(String[] args) {
         ListNode l1 = new ListNode(2);
         ListNode l11 = new ListNode(4);
         ListNode l111 = new ListNode(3);
         ListNode l2 = new ListNode(5);
         ListNode l22 = new ListNode(6);
         ListNode l222 =new ListNode(4);
         l1.next = l11;
         l11.next = l111;
         l111.next = null;
         l2.next = l22;
         l22.next = l222;
         l222.next = null;
        
         ListNode ret = addTwoNumbers(l1,l2);
         StdOut.println(ret.val + " -> " +ret.next.val+" -> "+ret.next.next.val);
    }
} 