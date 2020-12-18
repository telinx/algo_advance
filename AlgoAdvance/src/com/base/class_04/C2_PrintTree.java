package com.base.class_04;

public class C2_PrintTree {
    public static class Node{
        int data;
        Node left;
        Node right;
        
        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        };
    }
    public static void inTraver(Node head,int height) {
        if(head == null) {
            return;
        }
        inTraver(head.right, height + 1);
        print(head.data, height);
        inTraver(head.left, height + 1);
    }
    
    private static void print(int data, int height) {
        String a = "";
        for(int i = 0; i < height; i++) {
            a += "\t";
        }
        System.out.println(a + data);
    }
    
    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        head.right.right = new Node(7);
        inTraver(head, 0);
    }

}
