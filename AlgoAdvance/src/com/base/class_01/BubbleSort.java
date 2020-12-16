package com.base.class_01;

import java.util.Arrays;
/**
 * 冒泡思想
 * 两两交换，把最大的交换到最右边
 * 代码优化，设置一个是否交换过得flag，没交换可得是有序数组
 * @author yucang
 *
 */
public class BubbleSort {
    
    public static void bubbleSort(Integer[] arr) {
        int length = arr.length;
        boolean flag = true;
        for(int i = length - 1; i >= 0; i--) {
            for(int j = 1; j <= i; j++) {
                if(arr[j - 1] > arr[j]) {
                    SortUtils.swap(arr, j - 1, j);
                    flag = false;
                }
            }
            if(flag) {
                break;
            }
        }
    }
    
    public static void main(String[] args) {
        Integer[] arr = new Integer[] {
            10, 1, 2, 3, 4, 12, 8, 1, 9
        };
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
