package com.base.class_03;

/**
 * 数组实现队列
 * @author yucang
 *
 */
public class C1_ListByArray {
    
    private int[] arr;
    private int capacity;
    private int size;
    private int head;
    private int tail;
    public C1_ListByArray(int capacity) {
        super();
        this.capacity = capacity;
        this.arr = new int[capacity];
        this.size = 0;
        this.head =  0;
        this.tail =  0;
    }
    
    public boolean add(int value) {
        if(this.isFull()) {
            System.out.println("Full");
            return false;
        }
        this.head = this.head % this.capacity;
        this.arr[this.head++] = value;
        this.size++;
        return true;
    }
    
    public int poll() {
        if(this.isEmpty()) {
            throw new RuntimeException("is empty");
        }
        this.tail = this.tail % this.capacity;
        int value = this.arr[this.tail++];
        return value;
    }
    
    public boolean isEmpty() {
        return this.size == 0;
    }
    
    public boolean isFull() {
        return this.size == this.capacity;
    }
    
    
    
    
}
