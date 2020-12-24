package com.offer.class_01;

/**
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 */
public class C17_SubTree {
    public static class Node {
        int data;
        Node left;
        Node right;
    }

    public static boolean isSubTree(Node root1, Node root2) {
        if(root1 == null){
            return root1 == root2;
        }
        if(root1 == root2){
            return isSubTree(root1.left, root2.left) &&  isSubTree(root1.right, root2.right);
        }else{
            return isSubTree(root1.left, root2) || isSubTree(root1.right, root2);
        }
    }
}
