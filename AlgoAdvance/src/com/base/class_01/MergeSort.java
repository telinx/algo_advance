package com.base.class_01;

import java.util.Arrays;
/**
 * 核心思想
 * 1.递归
 *      边界end > begin
 * 2.有序数组合并
 *      先两两比较合并
 *      剩于的合并
 *      
 * ！！！注意长度是last -start + 1
 * @author yucang
 *
 */
public class MergeSort {
    
    public static void mergeSort(Integer[] arr, int begin, int end) {
        if(end <= begin) {
            return;
        }
        int mid = (end - begin)/2 + begin;
        mergeSort(arr, begin, mid);
        mergeSort(arr, mid + 1, end);
        merge(arr, begin, end, mid);
    }
    
    public static void merge(Integer[] arr, int begin, int end, int mid) {
        // 这里一定要注意 是last - begin + 1
        Integer[] tempArr = new Integer[end - begin + 1];
        int index = 0;
        int beginIndex = begin;
        int endIndex = mid + 1;
        while(beginIndex <= mid && endIndex <= end) {
            if(arr[beginIndex] < arr[endIndex]) {
                tempArr[index++] = arr[beginIndex++];
            }else {
                tempArr[index++] = arr[endIndex++];
            }
        }
        while(beginIndex <= mid) {
            tempArr[index++] = arr[beginIndex++];
        }
        while(endIndex <= end) {
            tempArr[index++] = arr[endIndex++];
        }
        for(int i = 0; i < tempArr.length; i++) {
            arr[begin + i] = tempArr[i];
        }
    }
    
    public static void main(String[] args) {
        Integer[] arr = new Integer[] {
            10, 1, 2, 3, 4, 12, 8, 1, 9
        };
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
