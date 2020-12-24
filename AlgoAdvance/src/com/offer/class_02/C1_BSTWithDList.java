package com.offer.class_02;
/**
 * 二叉搜索树与双向链表
 * @author yucang
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 * 
 * 思路
 * 1.先找头节点
 * 2.从根节点开始 赋值pre next，采用前序思维
 */
public class C1_BSTWithDList {
    
    public static class Node {
        int data;
        Node left;
        Node right;
        Node pre;
        Node next;
    }
    
    public static Node treeWithDList(Node root) {
        if(root == null) {
            return null;
        }
        Node head = root.left;
        while(head.left != null) {
            head = head.left;
        }
        process(root);
        return root;
    }
    
    public static void process(Node root) {
        if(root == null) {
            return;
        }
        Node pre = root.left;
        Node next = root.right;
        
        while(pre != null) {
            pre = pre.right;
        }
        
        while(next != null) {
            next = next.left;
        }
        root.pre = pre;
        if(pre != null) {
            pre.next = root;
        }
        root.next = next;
        if(next != null) {
            next.pre = root;
        }
        
        process(root.left);
        process(root.right);
    }

}
