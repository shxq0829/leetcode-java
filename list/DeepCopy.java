import edu.princeton.cs.algs4.*;
public class DeepCopy {  
    private static class RandomListNode {
        int label;
        RandomListNode next,random;
        RandomListNode(int x) {
             this.label = x;            
        }
    }
    public static RandomListNode deepcopy(RandomListNode head) {  
        if (head == null) return null;  
          
        //第一遍扫描：对每个结点进行复制，把复制出来的新结点插在原结点之后  
        RandomListNode node = head;  
        while (node != null) {  
            RandomListNode newnode = new RandomListNode(node.label);  
            newnode.next = node.next;  
            node.next = newnode;  
            node = newnode.next;  
        }  
          
        //第二遍扫描：根据原结点的random，给新结点的random赋值  
        node = head;  
        while (node != null) {  
            if (node.random != null) node.next.random = node.random.next;  
            node = node.next.next;  
        }  
          
        RandomListNode newhead = head.next;  
          
        //第三遍扫描：把新结点从原链表中拆分出来  
        node = head;  
        while (node != null) {  
            RandomListNode newnode = node.next;  
            node.next = newnode.next;  
            if (newnode.next != null) newnode.next = newnode.next.next;  
            node = node.next;  
        }  
          
        return newhead;  
    }  
    public static void main(String[] args) {
         RandomListNode l1 = new RandomListNode(1);
         RandomListNode l2 = new RandomListNode(2);
         RandomListNode l3 = new RandomListNode(3);
         RandomListNode l4 = new RandomListNode(4);       
         RandomListNode l5 = new RandomListNode(5);       
         RandomListNode l6 = new RandomListNode(6);
         l1.next = l2;
         l1.random = l3;
         l2.next = l3;         
         l3.next = l4;
         l4.next = l5;
         l4.random = l6;
         l5.next = l6;
         l5.random = l2;
         l6.next = null;        
         RandomListNode ret = deepcopy(l1);
         for (RandomListNode l = ret;l != null;l = l.next) {
               StdOut.print(l.label + " -> ");   
         }
         StdOut.println("null"); 

         for (RandomListNode l = ret;l != null;l = l.random) {
               StdOut.print(l.label + " -> ");   
         }
         StdOut.println("null");     }
} 