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
          
        //��һ��ɨ�裺��ÿ�������и��ƣ��Ѹ��Ƴ������½�����ԭ���֮��  
        RandomListNode node = head;  
        while (node != null) {  
            RandomListNode newnode = new RandomListNode(node.label);  
            newnode.next = node.next;  
            node.next = newnode;  
            node = newnode.next;  
        }  
          
        //�ڶ���ɨ�裺����ԭ����random�����½���random��ֵ  
        node = head;  
        while (node != null) {  
            if (node.random != null) node.next.random = node.random.next;  
            node = node.next.next;  
        }  
          
        RandomListNode newhead = head.next;  
          
        //������ɨ�裺���½���ԭ�����в�ֳ���  
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