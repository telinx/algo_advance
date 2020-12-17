package com.advence.class_02;

import java.util.LinkedList;

/**
 * 给你一个整型数组，判断其所有子数组中最大值和最小值的差值不超过num
 * （如果满足则称该数组达标）的个数。
 * 要点：
 *
 * 下标0~X之间的 max - min <= aim， X+1刚好违反
 * 那么0， 0~1， 0~2...0~X都是符合max - min <= aim的子数组
 * 因为，在这个区间的值要么小于max, 要么大于min，相互减去 <= aim
 *
 * 思路：
 * 利用两个双端队列，分别存储当前最大值，最小值
 * 设置两个指针L R，L为起始位置，R为右边界
 * 
 * L是做边界 R是有边界
 * maxList minList队头存的是这个范围内最大 和 最小
 * 如果在这个区间内max-min <= aim 里面所有的从L作为起点子数组都是符合的 res += R - L
 *
 * 注意需要移除过期数据
 *
 */
public class FindSmallAimSubArray {

    public static int findSmallAimSubArray(int[] arr, int aim){
        // 队头 -》 队尾 从大到小
        LinkedList<Integer> maxList = new LinkedList<>();
        // 队头 -》 队尾 从小到大
        LinkedList<Integer> minList = new LinkedList<>();
        maxList.add(arr[0]);
        minList.add(arr[0]);
        int L = 0, R = 0;
        int res = 0;
        for(; L < arr.length; L++){
            while (R < arr.length){
                // 队头保持是当前子数组max
                while (!maxList.isEmpty() && arr[maxList.peekLast()] < arr[R]){
                    maxList.pollLast();
                }
                // 队头保持是当前子数组min
                maxList.add(R);
                while (!minList.isEmpty() && arr[minList.peekLast()] > arr[R]){
                    minList.pollLast();
                }
                minList.add(R);
                if(arr[maxList.peekLast()] - arr[minList.peekLast()] >= aim){
                    break;
                }
                R++;
            }
            // 移除过期数据
            if(maxList.peekFirst() == L){
                maxList.pollFirst();
            }
            if(minList.peekFirst() == L){
                minList.pollFirst();
            }
            res += R - L;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1, 5};
        System.out.println(findSmallAimSubArray(arr, 3));//9
    }

}
