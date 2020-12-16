package com.advence.class_06;

import java.util.Random;

/**
 * 跳表 https://blog.csdn.net/pcwl1206/article/details/83512600
 * 
 * 二维数据
 * Node节点主要是包含个数组,数组内容都是下一个节点的引用或者null
 * 
 * 查找：
 *  1.从p开始从上至下，同时从左至右，找到level = 0时的目标上一个位置
 *  2.判断目标下一个位置的值是否等于目标
 *  
 * 插入：
 *  1.随机出level，新建newNode
 *  2.创建Node[] update = new Node[level],全部赋值head
 *  3.从p开始从level至下，同时从左至右，找到level = 0时的目标上一个位置, update[i] = p
 *  4.遍历update[i]，设置newNode.next[i] = update[i.next[i];  update[i.next[i] = newNode
 *  
 * 删除：
 *  1.创建Node[] update = new Node[level]
 *  2.从p开始从上至下，同时从左至右，找到level = 0时的目标上一个位置, update[i] = p
 *  3.遍历update， update[i].next[i] = update[i].next[i].next[i]
 *  
 *  总结：
 *  无论增删查都是 先找到找一个节点的数组集合
 *  查找和删除都是从 跳表最大的level开始，插入是从随机出的level开始
 * @author yucang
 *
 */
interface ISkipList{
    void insert(int value);
    SkipList.Node find(int value);
    void remove(int value);
    void display();
}

public class SkipList implements ISkipList {
    
    public static final int MAX_LEVEL = 16;
    private Node head = new Node();
    private int level = 1;
    private static Random random = new Random();

    public static class Node{
        public int value;
        public int maxLevel;
        public Node[] next = new Node[MAX_LEVEL];  // 这段代码很重要，别忘了
        public Node() {
        }
        public Node(int value, int maxLevel) {
            super();
            this.value = value;
            this.maxLevel = maxLevel;
        }
    }
    
    @Override
    public Node find(int value) {
        Node p = this.head;
        for(int i = (level - 1); i >= 0; i--) {
            while(p.next != null && p.next[i] != null  && p.next[i].value < value) {
                p = p.next[i];
            }
        }
        if(p.next != null && p.next[0] != null && p.next[0].value == value) {
            return p.next[0];
        }
        return null;
    }

    @Override
    public void insert(int value) {
        int randomLevel = randomLevel();
        Node newNode = new Node(value, randomLevel);
        Node[] update = new Node[level - 1];
        
        for(int i = 0; i < randomLevel; i++) {
            update[i] = this.head;
        }
        
        Node p = this.head;
        for(int i = (level - 1); i >= 0; i--) {
            while(p.next != null && p.next[i] != null && p.next[i].value < value) {
                p = p.next[i];
            }
            // 这行代码 注意
            update[i] = p;
        }
        for(int i = 0; i < level; i++) {
            newNode.next[i] = update[i].next[i];
            update[i].next[i] = newNode;
        }
        if(randomLevel > this.level) {
            this.level = randomLevel;
        }
        
    }

    @Override
    public void remove(int value) {
        Node p = this.head;
        Node[] update = new Node[this.level];
        for(int i = (level - 1); i >=0; i--) {
            while(p.next != null && p.next[i] != null && p.next[i].value < value) {
                p = p.next[i];
            }
            update[i] = p;
        }
        if(p.next != null && p.next[0] != null && p.next[0].value == value) {
            for(int i = 0; i < level; i++) {
                if(update[i].next != null && update[i].next[i] != null && update[i].next[i].value == value) {
                    update[i].next[i] = update[i].next[i].next[i];
                }
            }
        }
    }

    @Override
    public void display() {
        Node p = this.head;
        while(p.next != null && p.next[0] != null) {
            p = p.next[0];
            System.out.println(p.value);
        }
    }
    
    
    public static int randomLevel() {
        int level = 1;
        for(int i = 0; i < 16; i++) {
            if(level >= MAX_LEVEL) {
                level = MAX_LEVEL;
                break;
            }
            if(random.nextInt() % 2 == 0) {
                level++;
            }
        }
        return level;
    }

   
    
    
}
