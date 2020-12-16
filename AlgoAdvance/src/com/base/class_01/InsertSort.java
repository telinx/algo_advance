package com.base.class_01;

import java.util.Arrays;
/**
 * 核心思想
 * 和纸牌一样，大的往后挪，然后把小的放进去
 * @author yucang
 *
 */
public class InsertSort {
    
    public static void insertSort(Integer[] arr) {
        int length = arr.length;
        for(int i = 1; i < length; i++) {
            int value = arr[i];
            int j = i;
            while(j > 0 && arr[j - 1] > arr[j]) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = value;
        }
    }
    
    public static void main(String[] args) {
        Integer[] arr = new Integer[] {
            10, 1, 2, 3, 4, 12, 8, 1, 9
        };
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
