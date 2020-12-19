package com.base.class_08;

import java.util.Stack;

public class C8_ReverseStack {
    
    public static void reverseStack(Stack<Integer> stack) {
//        int value1 = getStackBottomVal(stack);
//        if(!stack.isEmpty()) {
//            reverseStack(stack);
//        }else {
//            stack.push(value1);
//            return;
//        }
//        stack.push(value1);
        
        if(stack.isEmpty()) {
            return;
        }
        int value1 = getStackBottomVal(stack);
        reverseStack(stack);
        stack.push(value1);
    }
    
    /**
     * 假设 N个数 看成2个数  n-1个 和 1个
     * @param stack
     * @return
     */
    public static int getStackBottomVal(Stack<Integer> stack) {
        int value1 = stack.pop();
        if(stack.isEmpty()) {
            return value1;
        }
        int value2 = getStackBottomVal(stack);
        stack.push(value1);
        return value2;
    }
    
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
//        System.out.println(getStackBottomVal(stack));
        System.out.println(stack);
        reverseStack(stack);
        System.out.println(stack);
    }

}
