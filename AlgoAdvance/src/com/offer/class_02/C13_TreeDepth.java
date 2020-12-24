package com.offer.class_02;

public class C13_TreeDepth {
    
    public static class Node{
        int data;
        Node left;
        Node right;
    }
    
    public static int getDepth(Node root) {
        if(root == null) {
            return 0;
        }
        return 1 + Math.max(getDepth(root.left), getDepth(root.right));
    }

}
