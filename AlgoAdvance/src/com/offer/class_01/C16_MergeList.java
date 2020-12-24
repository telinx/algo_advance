package com.offer.class_01;

/**
 * 输入两个单调递增的链表，输出两个链表合成后的链表，
 * 当然我们需要合成后的链表满足单调不减规则。
 */
public class C16_MergeList {

    public static class Node {
        int data;
        Node next;
    }

    public static Node merge(Node head1, Node head2){
        Node newHead = head1.data < head2.data ? head1 : head2;
        Node p1 = newHead == head1 ? head1.next : head1;
        Node p2 = newHead == head2 ? head2.next : head1;

        Node cur = newHead;
        while(p1 != null && p2 != null){
           if(p1.data < p2.data){
               cur.next = p1;
               p1 = p1.next;
           } else{
               cur.next = p2;
               p2 = p2.next;
           }
            cur = cur.next;
        }
        while(p1 != null) {
            cur.next = p1;
            p1 = p1.next;
            cur = cur.next;
        }
        while(p2 != null) {
            cur.next = p2;
            p2 = p2.next;
            cur = cur.next;
        }

        return newHead;
    }
}
