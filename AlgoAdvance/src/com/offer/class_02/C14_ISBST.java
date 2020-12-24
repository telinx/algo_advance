package com.offer.class_02;
/**
 * 平衡二叉树
 * 题目描述
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 * 
 * 平衡二叉树 左右高度差不能超过1
 * @author yucang
 *
 */
public class C14_ISBST {
    public static class Node{
        int data;
        Node left;
        Node right;
    }
    
    public static class ReturnInfo{
        boolean isBST;
        int height;
        public ReturnInfo(boolean isBST, int height) {
            super();
            this.isBST = isBST;
            this.height = height;
        }
    }
    
    public static ReturnInfo process(Node root) {
        if(root == null) {
            return new ReturnInfo(true, 0);
        }
        ReturnInfo leftInfo = process(root.left);
        if(!leftInfo.isBST) {
            return new ReturnInfo(false, 0);
        }
        ReturnInfo rightInfo = process(root.right);
        if(!rightInfo.isBST) {
            return new ReturnInfo(false, 0);
        }
        if(Math.abs(leftInfo.height - rightInfo.height) > 1) {
            return new ReturnInfo(false, 0);
        }
        
        return new ReturnInfo(true, Math.max(leftInfo.height, rightInfo.height) + 1);
    }
}
