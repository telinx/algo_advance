package com.base.class_01;

import java.util.Arrays;

/**
 * 思想
 * 升级版的插入排序
 * @author yucang
 *
 */
public class HillSort {
    
    public static void hillSort(Integer[] arr) {
        int length = arr.length;
        int step = 1;
        while((3*step + 1) < length) {
            step = 3*step + 1;
        }
        
        while(step > 0) {
            for(int i = step; i < length; i++) {
                int temp = arr[i];
                int j = i;
                while(j > 0 && arr[j - step] > arr[j]) {
                    arr[j] = arr[j - step];
                    j -= step;
                }
                arr[j] = temp;
            }
            step = (step - 1)/3;
        }
    }
    
    public static void main(String[] args) {
        Integer[] arr = new Integer[] {
            10, 1, 22, 3, 4, 121, 82, 1121, 9
        };
        hillSort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
