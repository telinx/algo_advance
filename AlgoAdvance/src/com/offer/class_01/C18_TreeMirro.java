package com.offer.class_01;

/**
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 */
public class C18_TreeMirro {
    public static class Node {
        int data;
        Node left;
        Node right;
    }


    public static void mirro(Node head){
        if(head == null){
            return;
        }
        Node temp = head.right;
        head.right = head.left;
        head.left = temp;
        mirro(head.left);
        mirro(head.right);
    }

}
