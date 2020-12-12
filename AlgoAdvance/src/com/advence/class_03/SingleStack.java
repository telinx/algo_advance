package com.advence.class_03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * 给你一个数组，找出数组中每个数左边离它最近的比它大的数和右边离它最近的比它大的数。
 * 总结：
 * 栈底到栈顶 从大到小
 * 进入的比 栈顶大 小就压入，
 * 进入的比 栈顶大 小就弹出，取出左右值
 * 
 * 处理还在栈内的，剩余的右最大全为null
 * @author yucang
 *
 */
public class SingleStack {
    
    public static class Node{
      
        public ArrayList<Integer> indexs;
        public Integer value;
        public Node(Integer index, Integer value) {
            this.indexs = indexs == null ? new ArrayList<Integer>() : indexs;
            this.indexs.add(index);
            this.value = value;
        }
        @Override
        public String toString() {
            return "Node [indexs=" + indexs + ", value=" + value + "]";
        }
        
    }
    
    public static void SingleStack(Integer[] array) {
        Stack<Node> stack = new Stack<>();
        Integer rightMax = null;
        Integer leftMax = null;
        Node top;
        for(int i = 0; i < array.length; i++) {
            if(stack.isEmpty()) {
                stack.push(new Node(i, array[i]));
            }else {
                int cur = array[i];
                top = stack.peek();
                if(top.value > cur) {
                    stack.push(new Node(i, array[i]));
                }else if(top.value == cur) {
                    top.indexs.add(i);
                }else if(top.value < cur) {
                    if(cur == 110) {
                        System.out.println();
                    }
                    while(!stack.isEmpty() &&  stack.peek().value < cur) {
                        top = stack.pop();
                        leftMax = stack.isEmpty() ? null : stack.peek().value;
                        rightMax = cur;
                        System.out.println("value = " + top.value  + ", max left = " + leftMax + ", right max = " + rightMax);
                        if(top.indexs.size() > 1) {
                            top.indexs.remove(top.indexs.size() - 1);
                            stack.push(top);
                        }
                    }
                    stack.push(new Node(i, array[i]));
                }
            }
        }
        
        System.out.println(stack.toString());
        //处理还在栈内的值，这些值的rightMax = 0
        rightMax = null;
        while(!stack.isEmpty()) {
            top = stack.pop();
            leftMax = stack.isEmpty() ? null : stack.peek().value;
            System.out.println("value = " + top.value  + ", max left = " + leftMax + ", right max = " + rightMax);
            if(top.indexs.size() > 1) {
                top.indexs.remove(top.indexs.size() - 1);
                stack.push(top);
            }
        }
    }
    
    public static void main(String[] args) {
        Integer[] array = new Integer[] {
            10, 2, 3, 4, 5, 5, 110, 55, 8, 99      
        };
        System.out.println(Arrays.toString(array));
        SingleStack(array);
    }

}
