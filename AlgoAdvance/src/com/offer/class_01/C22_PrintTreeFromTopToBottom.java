package com.offer.class_01;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 * 层序遍历
 */
public class C22_PrintTreeFromTopToBottom {

    public static class Node {
        int data;
        Node left;
        Node right;

    }

    public static void levelPrint(Node head){
        if(head == null){
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        System.out.println(head.data);
        queue.add(head);
        while(!queue.isEmpty()){
            Node cur = queue.poll();
            if(cur.left != null){
                System.out.println(cur.left.data);
                queue.add(head.left);
            }
            if(cur.right != null){
                System.out.println(cur.right.data);
                queue.add(head.right);
            }
        }
    }
}
