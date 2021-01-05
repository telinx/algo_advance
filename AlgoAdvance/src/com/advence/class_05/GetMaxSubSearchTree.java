package com.advence.class_05;

/**
 * 求一棵二叉树的最大搜索二叉子树的结点个数
 * 最大搜索二叉子树指的是二叉树中，是以搜索二叉树且节点个数最多的
 * 这类题目都有个大前提，假设对于以树中的任意节点为头节点的子树，
 * 我们都能求得其是最大搜索二叉树的节点个数，那么答案一定在其中
 * 
 * BST概念：
 * 若任意节点的左子树不空，则左子树上所有节点的值均小于它的根节点的值；
 * 若任意节点的右子树不空，则右子树上所有节点的值均大于它的根节点的值；
 * 任意节点的左、右子树也分别为二叉查找树；
 * 
 * 思路：提取分析出 可能性
 * 1.BigST在左子树中
 * 2.BigST在右子树中
 * 3.本身就是个BigST
 * 
 * 要区分这三种情况，需要收集信息
 * =子树中是否存在最大搜索二叉树
 * =子树的头节点
 * =子树的最大值结点
 * =子树的最小值节点
 * 
 * 因此我们就可以开始我们的高度套路了：
 * 1.将要从子树收集的信息封装成一个returnData,代表处理完这一棵子树要向上级返回的信息
 * 
 * 2.假设我利用子过程收集了子树的信息，接下来根据子树的信息和分析问题时列出的情况加工出
 * 当前这个树要为上级提供的所有信息，并返回给上级（整合信息）
 * 
 * 3.确定base case，子过程到子树为空时，停
 * 
 * 重点是分析出可行性
 * 
 * @author yucang
 * 
 */
public class GetMaxSubSearchTree {
    
    public static class ReturnData{
        int size;
        Node head;
        int max;
        int min;
        public ReturnData(int size, Node head, int max, int min) {
            super();
            this.size = size;
            this.head = head;
            this.max = max;
            this.min = min;
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
            return new ReturnData(0, null, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }
        
        //黑盒处理
        ReturnData leftInfo = process(root.left);
        ReturnData rightInfo = process(root.right);
        
        int leftSize = leftInfo.size;
        int rightSize = rightInfo.size;
        
        int selfSize = 0;
        if(leftInfo.head == root.left && rightInfo.head == root.right &&
           leftInfo.max < root.data && rightInfo.min > root.data) {
            selfSize = leftSize + rightSize + 1;
        }
        
        int maxSize = Math.max(Math.max(rightSize, leftSize), selfSize);
        Node maxHead;
        if(selfSize > rightSize && selfSize > leftSize) {
            maxHead = root;
        }else{
            maxHead = leftSize > rightSize ? leftInfo.head : rightInfo.head;
        }        int max = Math.max(Math.max(leftInfo.max, rightInfo.max), root.data);

        int min = Math.max(Math.min(leftInfo.min, rightInfo.min), root.data);
        
        return new ReturnData(maxSize, maxHead, max, min);
    }
    
}
