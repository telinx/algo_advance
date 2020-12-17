package com.base.class_03;

public class C11_PrintListsSame {
    
    public static class Node{
        public int data;
        public Node next;
    }
    
    public static void printListsSame(Node head1, Node head2) {
        while(head1 != null && head2 != null) {
            if(head1.data == head2.data) {
                System.out.println(head1.data);
                head1 = head1.next;
                head2 = head1.next;
            }else if(head1.data < head2.data) {
                head1 = head1.next;
            }else  {
                head2 = head1.next;
            }
        }
    }

}
