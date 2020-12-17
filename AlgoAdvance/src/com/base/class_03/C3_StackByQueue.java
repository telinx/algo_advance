package com.base.class_03;

import java.util.LinkedList;
import java.util.Queue;

public class C3_StackByQueue {
    
    private Queue<Integer> dataList;
    private Queue<Integer> helpList;
    
    public C3_StackByQueue() {
        this.dataList = new LinkedList<Integer>();
        this.helpList = new LinkedList<Integer>();
    }
    
    public void push(int item) {
        this.dataList.add(item);
    }
    
    public int pop() {
        if(this.isEmpty()) {
            throw new RuntimeException();
        }
        while(dataList.size() > 1) {
            helpList.add(dataList.poll());
        }
        int value = dataList.poll();
        this.swap();
        return value;
    }
    
    public int peek() {
        if(this.isEmpty()) {
            throw new RuntimeException();
        }
        int value = pop();
        this.push(value);
        return value;
    }
    
    private void swap() {
        Queue<Integer> tempList = this.dataList;
        this.dataList = this.helpList;
        this.helpList = tempList;
    }
    
    public boolean isEmpty() {
        return dataList.isEmpty();
    }

}
