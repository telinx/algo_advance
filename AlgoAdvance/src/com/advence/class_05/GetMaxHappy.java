package com.advence.class_05;

import java.util.List;

/**
 * 求一棵二叉树的最远距离
 * 还是老套路
 * 黑盒 得到子树的happy
 * 比较去的happy  和 不去的happy
 * 2种情况
    去的happy
    不去的happy
 * @author yucang
 * 
 */
public class GetMaxHappy {
    
    public static class ReturnData{
        int maxHappy;
        public ReturnData(int maxHappy) {
            super();
            this.maxHappy = maxHappy;
        }
    }
    
    public static class Node{
        public int happy;
        public List<Node> subs;
        
        public Node(int data) {
            super();
            this.happy = happy;
        }
    }
    
    public static ReturnData process(Node root) {
        if(root.subs == null || root.subs.size() < 1) {
            return new ReturnData(root.happy);
        }
        int goHappy = root.happy;
        
        int unGoHappy = 0;
        for(Node node : root.subs) {
            unGoHappy += process(node).maxHappy;
        }
        return new ReturnData(Math.max(unGoHappy, goHappy));
        
    }
    
    public static int getMaxHappy(Node root) {
        if(root == null) {
            return 0;
        }
        return process(root).maxHappy;
    }
    public static void main(String[] args) {
        
    }
    
}
