package com.base.class_01;

import java.util.Arrays;

/**
 * 核心思想
 * 两两不越界情况合并
 * 剩余数据合并
 * 注意边界start1 <= (length1 - 1)
 * @author yucang
 *
 */
public class MergeArray {
    
    public static Integer[] merge(Integer[] arr1, Integer[] arr2) {
        int length1 = arr1.length;
        int length2 = arr2.length;
        Integer[] arr = new Integer[length1 + length2];
        int start1 = 0;
        int start2 = 0;
        int index = 0;
        while(start1 <= (length1 - 1)  && start2 <= (length2 - 1)) {
            if(arr1[start1] < arr2[start2]) {
                arr[index++] = arr1[start1++];
            }else {
                arr[index++] = arr2[start2++];
            }
        }
        while(start1 <= (length1 - 1)) {
            arr[index++] = arr1[start1++];
        }
        while(start2 <= (length2 - 1)) {
            arr[index++] = arr2[start2++];
        }
        return arr;
    }

    public static void main(String[] args) {
        Integer[] arr1 = new Integer[] {
            2, 3, 4, 5, 6
        };
        Integer[] arr2 = new Integer[] {
           1, 2, 3, 4, 4, 8, 8, 9
        };
        System.out.println(Arrays.toString(merge(arr1, arr2)));
    }

}
