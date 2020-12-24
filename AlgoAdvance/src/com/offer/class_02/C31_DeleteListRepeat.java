package com.offer.class_02;
/**
 * 删除链表中重复的结点
 * 题目描述
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，
 * 重复的结点不保留，返回链表头指针。 
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 * 
 * 思路
 * 新增出一个不允许重复的节点，新增delete标识
 * 老节点只要遇到重复就发生跳跃，同时新节点也发生跳跃
 * @author yucang
 *
 */
public class C31_DeleteListRepeat {
    
    public static class Node {
        int data; 
        Node next;
        public Node(int data) {
            this.data = data;
        }
    }
    
    public static Node deleteListRepeat(Node head) {
        Node node = new Node(Integer.MIN_VALUE);
        Node pre = node;
        Node cur = head;
        pre.next = cur;
        boolean deleteNode = false;
        while(cur != null) {
            if(cur.next != null && cur.next.data == cur.next.next.data) {
                cur.next = cur.next.next;
                deleteNode = true;
            }else if(deleteNode) {
                pre.next = cur.next;
                deleteNode = false;
            }else {
                pre = cur;
                cur = cur.next;
            }
        }
        return node.next;
    }
}
