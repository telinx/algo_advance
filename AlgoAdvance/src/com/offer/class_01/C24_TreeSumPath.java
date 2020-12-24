package com.offer.class_01;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 输入一颗二叉树的跟节点和一个整数，
 * 打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * (注意: 在返回值的list中，数组长度大的数组靠前)
 *
 *
 */
public class C24_TreeSumPath {

    public static class Node {
        int data;
        Node left;
        Node right;
    }

    public static ArrayList<ArrayList<Integer>> FindPath(Node head, int target) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        preTraverse(head, 0,target, stack, list);
        return list;
    }

    public static void preTraverse (Node head, int sum, int target, Stack<Integer> stack, ArrayList<ArrayList<Integer>> list) {
        if(head == null){
            return;
        }
        System.out.println(head.data);
        stack.push(head.data);
        sum += head.data;

        if(head.left == null && head.right == null && sum == target) {
            ArrayList<Integer> res = new ArrayList<>();
            res.addAll(stack);
            list.add(res);
        }

        preTraverse(head.left, sum, target, stack, list);
        preTraverse(head.right, sum, target, stack, list);
        sum -= stack.pop();

    }


}
