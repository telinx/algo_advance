package com.base.class_03;

public class C8_ReverseList {
    
    public static class Node {
        public int data;
        public Node next;
    }
    
    public static class DNode {
        public int data;
        public DNode next;
        public DNode pre;
    }
    
    public static void reverse1(Node head) {
        Node pre = null;
        while(head != null) {
            Node next = head.next;
            head.next = pre;
            head = next;
            pre = head;
        }
        // pre is need
    }
    
    public static void reverse2(DNode head) {
        DNode pre = null;
        while(head != null) {
            DNode next = head.next;
            head.next = pre;
            head.pre = next;
            head = next;
            pre = head;
        }
    }
    
}
