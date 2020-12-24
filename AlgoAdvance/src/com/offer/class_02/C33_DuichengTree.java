package com.offer.class_02;
/**
 * 对称的二叉树
 * 题目描述
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。
 * 注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的
 * 
 * 思路 先序遍历 LHR 反过来 RHL 字符串相等则相等
 * @author yucang
 *
 */
public class C33_DuichengTree {
    
    public static class Node {
        int data;
        Node left;
        Node right;
    }
    
    public static void pre(Node head, StringBuffer buffer) {
        if(head == null) {
            buffer.append("#!");
            return;
        }
        buffer.append(head.data + "!");
        pre(head.left, buffer);
        pre(head.right, buffer);
    }
    
    public static void pre1(Node head, StringBuffer buffer) {
        if(head == null) {
            buffer.append("#!");
            return;
        }
        buffer.append(head.data + "!");
        pre(head.right, buffer);
        pre(head.left, buffer);
    }
    
    

}
