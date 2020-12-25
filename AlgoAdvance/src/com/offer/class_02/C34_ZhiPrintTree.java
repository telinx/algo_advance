package com.offer.class_02;

import java.util.Stack;

/**
 * 请实现一个函数按照之字形打印二叉树，
 * 即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，
 * 第三行按照从左到右的顺序打印，其他行以此类推。
 *
 * 思路
 * https://www.cnblogs.com/hapjin/p/5838030.html
 * 新建两个stack，一个存奇数行，一个存偶数行
 */

public class C34_ZhiPrintTree {

    public static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    public static void zhiPrintTree(Node root){
        if(root == null){
            return;
        }
        Stack<Node> oddStack = new Stack<>();
        Stack<Node> evenStack = new Stack<>();
        oddStack.add(root);
        int lineNum = 1;
        while(!oddStack.isEmpty() || !evenStack.isEmpty()){
            if(lineNum % 2 == 1){
                while(!oddStack.isEmpty()){
                    Node cur = oddStack.pop();
                    System.out.println(cur.data);
                    if(cur.left != null){
                        evenStack.add(cur.left);
                    }
                    if(cur.right != null){
                        evenStack.add(cur.right);
                    }
                }
            }else{
                while(!evenStack.isEmpty()){
                    Node cur = evenStack.pop();
                    System.out.println(cur.data);
                    if(cur.right != null){
                        oddStack.add(cur.right);
                    }
                    if(cur.left != null){
                        oddStack.add(cur.left);
                    }

                }
            }
            lineNum++;
        }

    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.left.left.left = new Node(8);
        zhiPrintTree(root);
    }
}
