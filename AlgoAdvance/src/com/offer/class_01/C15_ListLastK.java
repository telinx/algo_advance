package com.offer.class_01;

/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 * 倒过来，正数也可以
 * 通常解法
 * 用两个指针 p1 先走k步，p2一起走 ，p1走到头，p2也就到了倒数k步
 */
public class C15_ListLastK {


    public static class Node {
        int data;
        Node next;
    }

    public static Node getKNode(Node head, int k) {
        Node p1 = head;
        Node p2 = head;
        for(int i = 0; i<k; i++){
            p1 = p1.next;
            if(i < k && p1 == null){
                // throw
            }
        }
        while(p1 != null){
            p1 = p1.next;
            p2 = p2.next;
        }

        return p2;
    }

}
