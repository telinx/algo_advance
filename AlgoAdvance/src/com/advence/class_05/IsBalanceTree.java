package com.advence.class_05;
/**
 * 都是老套路 
 * 分析可能性
 * 交给黑盒
 * 得到黑盒数据处理返回
 * @author yucang
 *
 */
public class IsBalanceTree {
    
    public static class Node{
        public int data;
        public Node left;
        public Node right;
        
        public Node(int data) {
            super();
            this.data = data;
        }
    }
    
    public static class ReturnData{
        
        public boolean isBalance;
        public int height;
        public ReturnData(boolean isBalance, int height) {
            super();
            this.isBalance = isBalance;
            this.height = height;
        }
        
    }
    
    public static ReturnData isBalance(Node head) {
        
        if(head == null) {
            return new ReturnData(true, 0);
        }
        
        ReturnData leftInfo = isBalance(head.left);
        
        if(!leftInfo.isBalance) {
            return new ReturnData(false, 0);
        }
        
        ReturnData rightInfo = isBalance(head.right);
        if(!rightInfo.isBalance) {
            return new ReturnData(false, 0);
        }
        
        if(Math.abs(leftInfo.height - rightInfo.height) > 1) {
            return new ReturnData(false, 0);
        }
        
        return new ReturnData(true, Math.max(leftInfo.height, rightInfo.height) + 1);
    }

}
