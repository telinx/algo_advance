package com.base.class_03;

import java.util.Stack;

public class C2_GetMinStack {
    
    private Stack<Integer> dataStack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();
    
    public void push(int item) {
        if(this.isEmpty()) {
            minStack.push(item);
        }else {            
            minStack.push(minStack.peek() < item ? minStack.peek() : item);
        }
        dataStack.push(item);
    }
    
    public int pop() {
        if(this.isEmpty()) {
            // throw exception
        }
        minStack.pop();
        return dataStack.pop();
    }
    
    public int getMin() {
        if(this.isEmpty()) {
            // throw exception
        }
        return minStack.peek();
    }
    
    public boolean isEmpty() {
        return this.dataStack.isEmpty();
    }
    

}
