package com.base.class_01;

import java.util.Arrays;

public class BucketSort {

    public static void bucketSort(Integer[] arr) {
        int max = getMax(arr);
        int[] bucket = new int[max + 1];
        for(Integer cur : arr) {
            bucket[cur]++;
        }
        int index = 0;
        for(int i = 0; i < bucket.length; i++) {
            while(bucket[i] > 0) {
                arr[index++] = i;
                bucket[i]--;
            }
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
            10, 1, 2, 3, 4, 12, 8, 1, 9
        };
        bucketSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
