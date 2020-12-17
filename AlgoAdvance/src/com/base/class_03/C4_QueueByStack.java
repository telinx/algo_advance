package com.base.class_03;

import java.util.Stack;

public class C4_QueueByStack {
    private Stack<Integer> dataStack1;
    private Stack<Integer> dataStack2;
    
    public C4_QueueByStack() {
        this.dataStack1 = new Stack<>();
        this.dataStack2 = new Stack<>();
    }
    
    
    public void push(Integer item) {
        dataStack1.push(item);
    }
    
    public int peek() {
        if(this.isEmpty()) {
            throw new RuntimeException();
        }
        if(this.dataStack2.isEmpty()) {
            while(!this.dataStack1.isEmpty()) {
                this.dataStack2.push(this.dataStack1.pop());
            }
        }
        return this.dataStack2.peek();
    }
    
    public int pop() {
        if(this.isEmpty()) {
            throw new RuntimeException();
        }
        if(this.dataStack2.isEmpty()) {
            while(!this.dataStack1.isEmpty()) {
                this.dataStack2.push(this.dataStack1.pop());
            }
        }
        return this.dataStack2.pop();
    }
    
    public boolean isEmpty() {
        return this.dataStack1.isEmpty() && this.dataStack2.isEmpty();
    }
    
    
    
    
}
