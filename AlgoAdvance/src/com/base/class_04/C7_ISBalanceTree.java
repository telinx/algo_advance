package com.base.class_04;

public class C7_ISBalanceTree {

    public static class ReturnData{
        boolean isBalance;
        int height;
        public ReturnData(boolean isBalance, int height) {
            super();
            this.isBalance = isBalance;
            this.height = height;
        }
    }
    
    public static class Node{
        int data;
        Node left;
        Node right;
        
        public Node(int data) {
            this.data = data;
        }
        
    }
    
    
    public static ReturnData isBalance(Node head) {
        if(head == null) {
           return new ReturnData(true, 0) ;
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
            return new ReturnData(false, 0) ;
        }
        return new ReturnData(true, Math.max(leftInfo.height, rightInfo.height) + 1);
    }
    
    
}
