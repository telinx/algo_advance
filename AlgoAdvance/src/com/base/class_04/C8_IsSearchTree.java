package com.base.class_04;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 判断一棵树是否是搜索二叉树、 判断一棵树是否是完全二叉树
 * 思路
 * 搜索二叉树 中序遍历一定是有序的
 * 完全二叉树 层序遍历
 *  1.不允许有右子树无左子树
 *  2.一旦出现右节点没有了以后的都是叶子节点，
 * @author yucang
 *
 */
public class C8_IsSearchTree {

    public static class Node{
        int data;
        Node left;
        Node right;
        
        public Node(int data) {
            this.data = data;
        }
    }
    
    public static boolean isSearchTree(Node head) {
        if(head == null) {
            return true;
        }
        Stack<Node> stack = new Stack<>();
        int pre = Integer.MIN_VALUE;
        while(!stack.isEmpty() || head != null) {
            if(head != null) {
                stack.push(head);
                head = head.left;
            }else {
                head = stack.pop();
                System.out.println(head.data);
                if(head.data < pre) {
                    return false;
                }
                head = head.right;
            }
        }
        return true;
    }
    
    public static boolean isManTree(Node head) {
        if(head == null) {
            return true;
        }
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(head);
        boolean leaf = false;
        while(!queue.isEmpty()) {
            Node cur = queue.poll();
            System.out.println(cur.data);
            
            if((leaf && (cur.left != null ||  cur.right != null)) || (cur.left == null ||  cur.right != null)){
            return false;
            }
            if(cur.left != null) {
                queue.add(cur.left);
            }
            if(cur.right != null) {
                queue.add(cur.right);
            }
            if(cur.right == null) {
                leaf = true;
            }
        }
        
        return true;
    }
    
}
