package com.base.class_04;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class C1_TreeTravelsal {
    
    public static class Node{
        int data;
        Node left;
        Node right;
    }
    
    public static void preTravelsalByRec(Node head) {
        if(head == null) {
            return;
        }
        System.out.println(head.data);
        preTravelsalByRec(head.left);
        preTravelsalByRec(head.right);
    }
    
    public static void inTravelsalByRec(Node head) {
        if(head == null) {
            return;
        }
        preTravelsalByRec(head.left);
        System.out.println(head.data);
        preTravelsalByRec(head.right);
    }
    
    public static void postTravelsalByRec(Node head) {
        if(head == null) {
            return;
        }
        preTravelsalByRec(head.left);
        System.out.println(head.data);
        preTravelsalByRec(head.right);
    }
    
    
    public static void preTravelsal(Node head) {
       if(head == null) {
           return;
       }
       Stack<Node> stack = new Stack<>();
       stack.push(head);
       while(!stack.isEmpty()) {
           Node node = stack.pop();
           System.out.println(node.data);
           if(node.right != null) {
               stack.push(node.right);
           }
           if(node.left != null) {
               stack.push(node.left);
           }
       }
    }
    
    /**
     * 这段代码老忘记
     * 记住中序只push一次 head作为传递参数，先把head压入，
     * 再head = head.left || head = head.right
     * 相像一下只有一个右子树的结构
     * @param head
     */
    public static void inTravelsal(Node head) {
        if(head == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        while(!stack.isEmpty() || head != null) {
            if(head != null) {
                stack.push(head);
                head = head.left;
            }else {
                head = stack.pop();
                System.out.println(head.data);
                head = head.right;
            }
        }
    }
    
    public static void postTravelsal(Node head) {
        if(head == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        Stack<Node> helpStack = new Stack<>();
        stack.push(head);
        while(!stack.isEmpty()) {
            Node node = stack.pop();
            helpStack.push(head);
            if(node.right != null) {
                stack.push(node.right);
            }
            if(node.left != null) {
                stack.push(node.left);
            }
        }
        while(!helpStack.isEmpty()) {
            System.out.println(helpStack.pop().data);
        }
    }
    
    
    public static void levelTraversal(Node head) {
        if(head == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(head);
        while(!queue.isEmpty()) {
            Node node = queue.poll();
            System.out.println(node.data);
            if(node.left != null) {
                queue.add(node.left);
            }
            if(node.right != null) {
                queue.add(node.right);
            }
        }
    }

}
