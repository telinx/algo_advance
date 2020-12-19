package com.base.class_07;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

//https://blog.csdn.net/weixin_41362649/article/details/94634770。
/**
 * 一个数据流中，随时可以取得中位数
 * 
 * 思路
 * 创建一个大根堆 一个小根堆
 * 大根堆 存 比大根堆堆顶小 比小根堆小的值
 * 堆均衡调整
 * 
 * ！！！觉得有点问题
 * 应该是
 * 1. 比大根堆小的进大根堆
 * 2. 除此之外进小根堆
 * 3. 堆平衡调整
 * 
 * @author yucang
 *
 */
public class C6_Medium {
    
    public static void adjust(Queue<Integer> maxQueue, Queue<Integer> minQueue) {
        if(maxQueue.size() - minQueue.size() >= 2) {
            minQueue.add(maxQueue.poll());
        }
        if(minQueue.size() - maxQueue.size() >= 2) {
            maxQueue.add(minQueue.poll());
        }
    }
    
    public static class Compartor1 implements Comparator<Integer>{
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1 - o2;
        }
    }
    
    public static class Compartor2 implements Comparator<Integer>{
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    }
    
    public static int processMedium(int[] arr) {
        PriorityQueue<Integer> maxQueue = new PriorityQueue<Integer>(new Compartor2());
        PriorityQueue<Integer> minQueue = new PriorityQueue<Integer>(new Compartor1());
        for(int i = 0; i < arr.length; i++) {
            if( maxQueue.isEmpty() || arr[i] < maxQueue.peek()) {
                maxQueue.add(arr[i]); 
            }else {
                if(minQueue.isEmpty()) {
                    minQueue.add(arr[i]); 
                    continue;
                }
                if(minQueue.peek() <= arr[i]) {
                    minQueue.add(arr[i]); 
                }else {
                    maxQueue.add(arr[i]);
                }
            }
            adjust(maxQueue, minQueue);
        }
        return 0;
    }
    
    public static int getMedian(Queue<Integer> maxQueue, Queue<Integer> minQueue) {
        if(maxQueue.isEmpty() && minQueue.isEmpty()) {
            // exeception
        }
        if(maxQueue.size() == minQueue.size()) {
            return (maxQueue.peek() + minQueue.peek());
        }
        return maxQueue.size() > minQueue.size() ? maxQueue.peek() : minQueue.peek();
        
    }

}
