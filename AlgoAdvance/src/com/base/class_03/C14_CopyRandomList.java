package com.base.class_03;

import java.util.HashMap;
import java.util.Map;
/**
 * 思路1:使用map
 * 思路2: 由node1 -> node2 合成 node1 -> node1` -> node2 -> node2`
 *       然后先复制random后复制next
 * @author yucang
 *
 */
public class C14_CopyRandomList {
    
    public static class Node{
        int data;
        Node next;
        Node random;
        
        public Node(int data) {
            this.data = data;
        }
    }
    
    public static Node copy(Node head) {
        if(head == null) {
           return null; 
        }
        Map<Node, Node> map = new HashMap<Node, Node>();
        Node cur = head;
        while(cur != null) {
            map.put(cur, new Node(head.data));
            cur = head.next;
        }    
        cur = head;
        while(cur != null) {
            map.get(cur).random = map.get(cur.random); 
            map.get(cur).next = map.get(cur.next);
            cur = cur.next;
        } 
        return null;
    }
    
    public static Node copy2(Node head) {
        if(head == null) {
           return null; 
        }
        Node cur = head;
        while(cur != null) {
            Node next = cur.next;
            Node newNode = new Node(cur.data);
            cur.next = newNode;
            newNode.next = next;
            cur = next;
        } 
        cur = head;
        Node head1 = null;
        while(cur != null) {
            Node next = cur.next.next;
            head1 = cur.next;
            head1 = cur.random !=null ? cur.random.next : null;
            cur = next;
        } 
        
        Node newHead = cur.next;
        while(cur != null) {
           Node next = cur.next.next;
           head1 = cur.next;
           head1 = cur.next !=null ? cur.next.next : null;
           cur.next = next;
           cur = next;
        } 
        
        return newHead;
    }

}
