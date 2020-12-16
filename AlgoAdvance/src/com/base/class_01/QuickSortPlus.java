package com.base.class_01;

import java.util.Arrays;
import java.util.Random;

/**
 * 荷兰国旗解法
 * 注意选定参数povit = arr[left] 不能是povit = left,利用arr[povit] 比较
 * index++实在if内部完成 不是在外面
 */
public class QuickSortPlus {

    private static Random random = new Random();

    public static void quickSort(Integer[] arr, int left, int right){
        if(right <= left){
            return;
        }
        int random = (int)QuickSortPlus.random.nextDouble() * (right  - left + 1) + left;
        SortUtils.swap(arr, left, random);
        int[] partition = getPartition(arr, left, right);
        quickSort(arr, left, partition[0] - 1);
        quickSort(arr, partition[1] + 1, right);

    }


    public static int[] getPartition(Integer[] arr, int left, int right){
        int[] partitions = new int[2];
        int povit = arr[left]; // 注意这里的代码，选定povit是不能改变的
        int L = -1;
        int R = right + 1;
        int index = left;
        while(index < R){
            if(povit < arr[index]){
                SortUtils.swap(arr, index++, --R);
            }else if(povit > arr[index]){
                SortUtils.swap(arr, index++, ++L);
            }else{
                index++;
            }
        }

        partitions[0] = L + 1;
        partitions[1] = R - 1;
        return partitions;
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{
                4, 1, 2, 4, 7
        };
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }


}
