package com.base.class_01;

import java.util.Arrays;

/**
 * 基于计数排序
 * 找出最大数 个位.十位...每次计数排序
 * @author yucang
 *
 */
public class BaseSort {

    public static void baseSort(Integer[] arr) {
        int max = getMax(arr);
        int val = 1;
        while(max/val > 0) {
            countSort(arr, val);
            val *= 10;
        }
    }
    
    public static void countSort(Integer[] arr, int val) {
        int[] bucket = new int[10];
        for(int i = 0; i < arr.length; i++) {
            int target = arr[i] / val % 10;
            bucket[target]++;
        }
        for(int i = 1; i < 10; i++) {
            bucket[i] +=bucket[i-1];
        }
        
        Integer[] tempArr = new Integer[arr.length];
        for(int i = arr.length - 1; i >=0; i--) {
            int target = arr[i] / val % 10;
            bucket[target]--;
            tempArr[bucket[target]] = arr[i];
        }
        for(int i = 0; i<tempArr.length; i++ ) {
            arr[i] = tempArr[i];
        } 
    }
    
    public static int getMax(Integer[] arr) {
        int maxIndex = 0;
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] > arr[maxIndex]) {
                maxIndex = i;
            }
        }
        return arr[maxIndex];
    }
    
    public static void main(String[] args) {
        Integer[] arr = new Integer[] {
            10, 1, 22, 3, 4, 121, 82, 1121, 9
        };
        baseSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
