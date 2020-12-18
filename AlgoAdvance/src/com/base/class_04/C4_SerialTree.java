package com.base.class_04;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class C4_SerialTree {
    public static class Node{
        int data;
        Node left;
        Node right;
        
        public Node(int data) {
            this.data = data;
        }
        
    }
    
    static String res = "";
    public static void serialTree(Node head) {
        if(head == null) {
            appendTree( "#,");
            return;
        }
        appendTree(head.data + ",");
        serialTree(head.left);
        serialTree(head.right);
    }
    
    public static void appendTree(String val) {
        res += val;
    }
    
    public static Node noSerialTree(String str) {
        if("#,".equals(str)) {
            return null;
        }
        Queue<String> queue = new LinkedList<String>();
        String[] arr = str.split(",");
        for(String a : arr) {
            queue.add(a);
        }
        return null;
    }
    
   
    public static Node reverse(Queue<String> queue) {
        String cur = queue.poll();
        if("#".equals(cur)) {
            return null;
        }
        Node head = new Node(Integer.parseInt(cur));
        head.left = reverse(queue);
        head.right = reverse(queue);
        return head;
    }
    
    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        head.right.right = new Node(7);
        serialTree(head);
        System.out.println(res);
        System.out.println(Arrays.toString(res.split(",")));
        
        System.out.println(levelSerial(head));
    }
    
    public static String levelSerial(Node head) {
        if(head == null) {
            return "#,";
        }
        String res = "";
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        res += head.data + ",";
        while(!queue.isEmpty()) {
            Node cur = queue.poll();
            if(null != cur.left) {
                res += cur.left.data + ",";
                queue.add(cur.left);
            }else {
                res += "#,";
            }
            if(null != cur.right) {
                res += cur.right.data + ",";
                queue.add(cur.right);
            }else {
                res += "#,";
            }
        }
        return res;
    }
    
    public static Node deLevelSerial(String res) {
        if("#," == res) {
            return null;
        }
        String[] arr = res.split(",");
        int index = 0;
        Queue<Node> queue = new LinkedList<>();
        Node head = new Node(Integer.parseInt(arr[index]));
        queue.add(head);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            cur.left = generateNode(arr[index++]);
            cur.right = generateNode(arr[index++]);
            if(cur.left != null) {
                queue.add(cur.left);
            }
            
            if(cur.right != null) {
                queue.add(cur.right);
            }
        }
        return head;
    }
    
    public static Node generateNode(String str) {
        if("#".endsWith(str)) {
            return null;
        }
        return new Node(Integer.parseInt(str));
    }

}
