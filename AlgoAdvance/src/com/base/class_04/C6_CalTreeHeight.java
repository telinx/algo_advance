package com.base.class_04;

import java.util.LinkedList;
import java.util.Queue;

public class C6_CalTreeHeight {

    public static class Node{
        int data;
        Node left;
        Node right;
        
        public Node(int data) {
            this.data = data;
        }
        
    }
    
    public static int deep1(Node head) {
        if(head == null) {
            return 0;
        }
        return 1 + Math.max(deep1(head.left), deep1(head.left));
    }
    
    public static int deep2(Node head, int height) {
        if(head == null) {
            return height;
        }
        int left = deep2(head.left, 1 + height);
        int right = deep2(head.right, 1 + height);
        return Math.max(left, right);
    }
    
    /**
     * 核心思想 poll的个数等于上层压入个数就+1
     * @param head
     * @return
     */
    public static int heightByLevelTraversal(Node head) {
        if(head == null) {
            return 0;
        }
        int level = 0;
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(head);
        while(!queue.isEmpty()) {
           int cur = 0;
           int len = queue.size();
           while(cur < len) {
               Node curNode = queue.poll();
               cur++;
               if(curNode.left != null) {
                   queue.add(curNode.left);
               }
               if(curNode.right != null) {
                   queue.add(curNode.right);
               }
           }
           level++;
        }
        return level;
    }
    
}
