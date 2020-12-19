package com.base.class_04;

/**
 * 已知一棵完全二叉树， 求其节点的个数
 * 要求： 时间复杂度低于O(N)，空间O(1),  N为这棵树的节点个数
 * 低于O(N)
 * 思路
 * 找到右子树 是否在最高高度上，
 *  是：右子树是满二叉树，   递归左子树
 *  不是，左子树是满二叉树， 递归左子树 右子树
 *  
 *  如果没有空间要求可以使用层序

问题的关键在于右子树的最左节点是否在最后一层

A.如果一个节点的右子树的最左节点到达完全二叉树的最后一层，则左子树为满树，
节点个数 = 左子树的节点数 + 递归求右子树的节点数 + 本节点，

B.如果此节点的右子树的最左节点没有到完全二叉树的最后一层，则右子树为满树，
节点个数 = 右子树的节点数 + 递归求左子树的节点 + 本节点。

 满二叉树的数量 = 2^ - 1
 * @author yucang
 *
 */
public class C9_CountNodes {

    public static class Node{
        int data;
        Node left;
        Node right;
        
        public Node(int data) {
            this.data = data;
        }
        
    }
    
    public static int nodeNum(Node head) {
        if(head == null) {
            return 0;
        }
        return bs(head, 1, mostLevel(head, 1));
    }
    
    public static int bs(Node head, int level, int height) {
        if(level == height) {
            return 1;
        }
        // 
        if(mostLevel(head.right, level + 1) == height) {  
            // 左边树是满二叉树  满二叉树个数 = 2^ - 1，而左边为2^ - 1 + 1
            return (1 << (height - level)) + bs(head.right, level + 1, height);
        }else {
            // 右边树是满二叉树
            return (1 << (height - level - 1)) + bs(head.left, level + 1, height);
        }
    }
    
    public static int mostLevel(Node head, int level) {
        while(head.left != null) {
            head = head.left;
            level++;
        }
        return level - 1;
    }
    
}
