package com.advence.class_06;

import java.util.HashMap;

/**
 * 核心思想
 * 一个HashMap 一个 双向链表
 * HashMap存储Node
 * 双端链表，头增尾删
 *  head为当前时间最长时间使用的
 *  tail为当前时间最近时间使用的
 *  
 *  比如,容量为3
 *      insert{A: 1}，head = {A: 1}
 *      insert{B: 2}，head = {A: 1} <-> {B: 2}
 *      insert{C: 3}，head = {A: 1} <-> {B: 2} <-> {C: 3}
 *      get{B: 2},获取{B: 2}左右Node，他们直接相连，再将tail指向{B: 2}，即{A: 1} <-> {{C: 3} <-> {B: 2}
 *      insert{D: 4}，此时需要移{A: 1}， head = {B: 2} <-> {C: 3}<-> {D: 4}
 *      
 *  编写步骤
 *  1.编写interface 
 *      IDoubleLinkedList:add moveToTail removeHead remove
 *      ICache: set get remove
 *  2.编写Node, DoubleLinkedList
 *  3.测试
 *  
 *  代码总结：
 *  1.双端队列需要主要操作的是否是head 或者 tail
 *  2.代码还是增删改查  
 *      map:get set remove
 *      list: add removeHead moveToTail remove 
 * @author yucang
 *
 */
interface IDoubleLinkedList<K, V>{
    void add(Node<K, V> node);
    void moveToTail(Node<K, V> node);
    K removeHead();
    void remove(Node<K, V> node);
}

interface ICache<K, V>{
    void set(Node<K, V> node);
    V get(K key);
    void remove(K key);
}

class Node<K, V>{
    K key;
    V value;
    Node<K, V> pre;
    Node<K, V> next;
    public Node(K key, V value) {
        super();
        this.key = key;
        this.value = value;
        this.pre = null;
        this.next = null;
    }
}

public class LRU {
    
    public static class Cache<K, V> implements ICache<K, V>{
        HashMap<K, Node<K, V>> map = new HashMap<>();
        DoubleLinkedList<K, V> doubleLinkedList = new DoubleLinkedList<>();
        int capacity;
        
        public Cache(int capacity) {
            this.capacity = capacity;
        }
        
        @Override
        public void set(Node<K, V> node) {
            if(map.containsKey(node.key)) {
                map.get(node.key).value = node.value;
                this.doubleLinkedList.moveToTail(node);
            }else {
                if(this.capacity == this.map.size()) {
                    this.map.remove(this.doubleLinkedList.head);
                    this.doubleLinkedList.removeHead();
                }
                map.put(node.key, node);
                this.doubleLinkedList.add(node);
            }
        }

        @Override
        public V get(K key) {
            if(map.get(key) == null) {
                return null;
            }
            this.doubleLinkedList.moveToTail(map.get(key));
            return map.get(key).value;
        }

        @Override
        public void remove(K key) {
            if(map.get(key) == null) {
                return;
            }
            this.doubleLinkedList.remove(map.get(key));
            this.map.remove(key);
        }
        
    }
    
    
    public static class DoubleLinkedList<K, V> implements IDoubleLinkedList<K, V>{
        
        Node<K, V> head;
        Node<K, V> tail;
        
        public DoubleLinkedList() {
            this.head = null;
            this.tail = null;
        }

        @Override
        public void add(Node<K, V> node) {
            if(node == null) {
                return;
            }
            if(head == null) {
                this.head = node;
                this.tail = node;
            }else {
                this.tail.next = node;
                node.pre = this.tail.next;
                this.tail = node;
            }
        }

        @Override
        public void moveToTail(Node<K, V> node) {
            if(node == this.tail) {
                return;
            }
            
            if(this.head == node) {
                Node<K, V> nextNode = node.next;
                nextNode.pre = null;
                this.head = nextNode;
                
                node.next = null;
                this.tail.next = node;
                node.pre = this.tail;
                this.tail = node;
            }else {
                Node<K, V> preNode = node.pre;
                Node<K, V> nextNode = node.next;
                
                preNode.next = nextNode;
                nextNode.pre = preNode;
                
                node.next = null;
                this.tail.next = node;
                node.pre = this.tail;
                this.tail = node;
            }
        }

        @Override
        public K removeHead() {
            if(this.head == null) {
                return null;
            }
            
            K key = this.head.key;
            if(this.head == this.tail) {
              this.head = null;
              this.tail = null;
            }else{
                this.head = this.head.next;
                this.head.pre = null;
            }
            return key;
        }

        @Override
        public void remove(Node<K, V> node) {
            if(this.head == null || this.tail == null) {
                return;
            }
            if(this.head == node) {
                this.head = this.head.next;
                if(this.head != null) {
                    this.head.pre = null;
                }
            }else if(this.tail == node) {
                this.tail = this.tail.pre;
                if(this.head != null) {
                    this.head.next = null;
                }
            }else {
                Node<K, V> preNode = node.pre;
                Node<K, V> nextNode = node.next;
                
                preNode.next = nextNode;
                nextNode.pre = preNode;
            }
        }
        
    }
    
}


