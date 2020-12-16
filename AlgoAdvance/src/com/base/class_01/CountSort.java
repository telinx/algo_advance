package com.base.class_01;

import java.util.Arrays;
/**
 * 计数排序的核心思想
 * 算出该数的下标
 * @author yucang
 *
 */
public class CountSort {
    
    public static void countSort(Integer[] arr) {
        int[] bucket = new int[10];
        for(int i = 0; i < arr.length; i++) {
            bucket[arr[i]]++;
        }
        for(int i = 1; i < 10; i++) {
            bucket[i] +=bucket[i-1];
        }
        
        Integer[] tempArr = new Integer[arr.length];
        for(int i = arr.length - 1; i >=0; i--) {
            bucket[arr[i]]--;
            tempArr[bucket[arr[i]]] = arr[i];
        }
        for(int i = 0; i<tempArr.length; i++ ) {
            arr[i] = tempArr[i];
        } 
    }
    

    public static void main(String[] args) {
        Integer[] arr = new Integer[] {
             1, 2, 3, 4,  8, 1, 9
        };
        countSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    
}
