package com.advence.class_03;
/**
 * 给你一些数，创建一棵大根堆二叉树
 * 思路:单调栈
 * 记录一个数的left[i] = leftMaxIndex, right = rightMaxIndex
 * 根据数组长度创建Node
 * 
 * leftMaxIndex rightMaxIndex均为空为根节点
 * leftMaxIndex rightMaxIndex均不为空，设为Min(leftMaxIndex, rightMaxIndex)的左子树
 * leftMaxIndex rightMaxIndex只有一个不为null，设为其左子树
 * @author yucang
 * 
 */
public class SingleStackMaxTree {

}
