package com.advence.class_05;

/**
 * 求一棵二叉树的最远距离
 * 还是老套路
 * 黑盒 得到左右数据
 * 左右数据比较得到返回
 * 
 * 三种情况
 * 最远距离在左子树
 * 最远距离在右子树
 * 最远距离路过root，也就是 左高 + 右高 + 1
 * @author yucang
 * 
 */
public class GetMaxSubLongTree {
    
    public static class ReturnData{
        int maxDistance;
        int height;
        public ReturnData(int maxDistance, int height) {
            super();
            this.maxDistance = maxDistance;
            this.height = height;
        }
    }
    
    public static class Node{
        public int data;
        public Node left;
        public Node right;
        
        public Node(int data) {
            super();
            this.data = data;
        }
    }
    
    public static ReturnData process(Node root) {
        if(root == null) {
            return new ReturnData(0, 0);
        }
        ReturnData leftData = process(root.left);
        ReturnData rightData = process(root.right);
        
        int leftMaxDistance = leftData.maxDistance;
        int rightMaxDistance = rightData.maxDistance;
        int includeHeadMaxDistance = leftData.height + 1 + rightData.height;
        
        int maxDistance = Math.max(Math.max(leftMaxDistance, rightMaxDistance), includeHeadMaxDistance);
        int maxHeight = Math.max(leftData.height, rightData.height) + 1;
        
        return new ReturnData(maxDistance, maxHeight);
        
    }
    
}
