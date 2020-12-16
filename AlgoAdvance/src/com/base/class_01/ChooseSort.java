package com.base.class_01;

import java.util.Arrays;

/**
 * 核心思想
 * 每次挑最小下标的左边然后交换
 * @author yucang
 *
 */
public class ChooseSort {
    
    public static void chooseSort(Integer[] arr) {
        int length = arr.length;
        for(int i = 0; i < length; i++) {
            int min = i;
            for(int j = i + 1; j < length; j++) {
                if(arr[min] > arr[j]) {
                    min = j;
                }
            }
            SortUtils.swap(arr, i, min);
        }
    }

    
    public static void main(String[] args) {
        Integer[] arr = new Integer[] {
            10, 1, 2, 3, 4, 12, 8, 1, 9
        };
        chooseSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
