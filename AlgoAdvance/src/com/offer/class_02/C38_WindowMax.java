package com.offer.class_02;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 滑动窗口的最大值
 * 题目描述
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，
 * 那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}；
 * 针对数组{2,3,4,2,6,2,5,1}的滑动窗口
 * 有以下6个： {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}，
 * {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}，
 * {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 *
 * 单调栈问题
 *
 */
public class C38_WindowMax {

    public static int[] getWindowMax(int[] arr, int k){
        int windowLen = arr.length - k +1;
        int[] resArr = new int[windowLen];
        Queue<Integer> queue = new LinkedList<>();
        int index = 0;

        for(int i = 0; i < arr.length; i++){
            if(queue.isEmpty()){
                queue.add(i);
                break;
            }
            while(!queue.isEmpty() && arr[queue.peek()] < arr[i]){
                queue.poll();
            }
            queue.add(arr[i]);
            if(queue.peek() <= i - k){
                queue.poll();
            }
            if(i > k -1){
                resArr[index++] = arr[queue.peek()];
            }

        }
        return resArr;
    }
}
