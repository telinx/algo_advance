package com.offer.class_01;


/**
 * 输入某二叉树的前序遍历和中序遍历的结果，
 * 请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,2,7,1,5,3,8,6}，
 * 则重建二叉树并返回。
 */
public class C5_RebuildTree {

    public static class Node {
        public int data;
        public Node left;
        public Node right;

        public Node(int data){
            this.data = data;
        }

    }


    public static Node reConstructBinaryTree(int [] pre, int [] in) {
        Node head = new Node(pre[0]);
        return rebuild(pre, 0, pre.length, in, 0, in.length);
    }

    public static Node rebuild(int [] pre, int i, int j, int [] in, int m, int n) {
        int headValue = pre[i];
        int headIndex = findHeadIndex(in, headValue, m, n);
        if(headIndex < 0){
            return null;
        }
        Node head = new Node(pre[i]);
        int leftNodes = headValue - m, rightNodes = n - headValue;
        if(headIndex == 0){
            head.left = null;
        }else{
            head.left = rebuild(pre, i + 1, i + leftNodes, in, m, m + leftNodes - 1);
        }
        if(headIndex == 0){
            head.right = null;
        }else{
            head.right = rebuild(pre, i + leftNodes + 1, j, in, n - rightNodes + 1, n);
        }

        return null;
    }

    public static int findHeadIndex(int[] in, int headValue, int m, int n){
        int res = -1;
        for(int i = m; i < n; i++){
            if(in[i] == headValue){
                res = i;
                break;
            }
        }
        return  res;
    }

}
