package com.offer.class_01;

public class C4_PrintList {

    public static class Node {
        public int data;
        public Node next;
    }

    public static void printList(Node head) {
        if(head == null){
            return;
        }
        head = reverse(head);
        while(head != null){
            System.out.println(head.data);
            head = head.next;
        }

    }

    public static Node reverse(Node head) {

        Node preNode = null;
        while(head != null){
            Node next = head.next;
            head.next = preNode;
            preNode = head;
            head = next;
        }
        return  preNode;
    }
}
