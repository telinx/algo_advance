package com.offer.class_01;

/**
 * 输入一个链表，反转链表后，输出新链表的表头。
 */
public class C3_ReverseList {

    public static class Node {
        public int data;
        public Node next;
    }

    public static class DNode extends Node{
        public int data;
        public DNode next;
        public DNode pre;
    }

    public static Node reverseNode(Node head){
        if(head == null){
            return null;
        }
        Node cur = head;
        Node pre = null;
        while(cur != null){
            Node next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
    public static DNode reverseDNode(DNode head){
        if(head == null){
            return null;
        }
        DNode cur = head;
        DNode pre = null;
        while(cur != null){
            DNode next = cur.next;
            cur.next = pre;
            cur.pre = next;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
