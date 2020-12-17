package com.base.class_03;

import com.base.class_03.C11_PrintListsSame.Node;

/**
 * 将单向链表按某值划分左边右边
 * 思路
 * 将链表拆分成3个链表,最后相连即可
 * 小的和小的连在一起
 * 等的和等的连在一起
 * 大的和大的连在一起
 * @author yucang
 *
 */
public class C13_ListSideByValue {

    public static class Node{
        public int data;
        public Node next;
    }
    
    public static Node siseByValue(Node head, int aim) {
        if(head == null) {
            return null;
        }
        Node small = null;
        Node smallHead = null;
        Node equal = null;
        Node equalHead = null;
        Node big = null;
        Node bigHead = null;
        
        while(head != null) {
            if(head.data  < aim) {
                if(small == null) {
                    small = head;
                    smallHead = head;
                }else {
                    small.next = head;
                    small = head;
                }
            }else if(head.data  > aim) {
                if(big == null) {
                    big = head;
                    bigHead = head;
                }else {
                    big.next = head;
                    big = head;
                }
            }else {
                if(equal == null) {
                    equal = head;
                    equalHead = head;
                }else {
                    equal.next = head;
                    equal = head;
                }
            }
            head = head.next;
        }
        
        
        if(equalHead != null) {
            equal.next = big;
        }else {
            equalHead = bigHead;
        }
        
        if(smallHead != null) {
            small.next = equalHead;
        }else {
            smallHead = equalHead;
        }
        return smallHead;
    }
    
}
