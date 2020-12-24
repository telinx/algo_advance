package com.offer.class_02;
/**
 * 二叉树的下一个结点
 * 给定一个二叉树和其中的一个结点，
 * 请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 * @author yucang
 * 分析情况
 * 1.有右子树
 * 2.无右子树
 *  是父亲节点的左孩子
 *  是父亲节点的右孩子
 */
public class C32_FindInOrderNext {
    public static class Node{
        int data;
        Node left;
        Node right;
        Node parent;
    }
    
    public static Node findInOrderNext(Node node) {
        if(node.left != null) {
            Node cur = node.left;
            while(cur != null) {
                cur = cur.right;
            }
            return cur;
        }else {
            Node parent = node.parent;
            Node cur = node;
            while(parent != null && parent.left != cur) {
                parent = parent.parent;
                cur = parent;
            }
            return parent;
        }
    }
}
