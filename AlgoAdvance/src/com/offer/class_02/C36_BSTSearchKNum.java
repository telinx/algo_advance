package com.offer.class_02;

/**
 * 二叉搜索树的第k个结点
 * 给定一棵二叉搜索树，请找出其中的第k小的结点。
 * 例如， （5，3，7，2，4，6，8） 中，按结点数值大小顺序第三小结点的值为4。
 *
 * BST中序是 有序排列
 */
public class C36_BSTSearchKNum {

    public static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data = data;
        }

    }


    static int count = 0;

    static Node res = null;

    public static void findK(Node root, int k){
        if(k <= 1){
            return;
        }
        count = k;
    }

    public static void inTraverse(Node root){
        if(root == null){
            return;
        }
        inTraverse(root.left);
        System.out.println(root.data);
        count--;
        if(count == 0){
            res = root;
            return;
        }

        inTraverse(root.right);
    }
}
