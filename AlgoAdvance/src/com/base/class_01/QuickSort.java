package com.base.class_01;

import java.util.Arrays;

public class QuickSort {

    public static void quickSort(Integer[] arr, int left, int right){
        if(right <= left){
            return;
        }
        int partition = getPartition(arr, left, right);
        quickSort(arr, left, partition);
        quickSort(arr, partition + 1, right);
    }

    //public static int partition1(Integer[] array , int left, int right){
    //    int pivot = left;
    //    int leftIndex = left;
    //    int rightIndex = right + 1;
    //    while(true){
    //        while(leftIndex < right && array[leftIndex++] < array[pivot]){}
    //        while(rightIndex > left && array[--rightIndex] > array[pivot]){}
    //        if(rightIndex > leftIndex){
    //            SortUtils.swap(array, leftIndex, rightIndex);
    //        }else {
    //            break;
    //        }
    //    }
    //    SortUtils.swap(array, pivot, rightIndex);
    //    return rightIndex;
    //}

    public static int getPartition(Integer[] arr, int left, int right){
        int pivot = left;
        int L = left;
        int R = right + 1;
        while(true){
            // 左游标一直往右跑，直到发现比自己大的停
            // 右游标一直往左跑，直到发现比自己小的停
            // L<R两者交换
            // https://www.cnblogs.com/ysocean/p/8032632.html#_label1_0
            // 图解有问题  游标是不会重合，而是L 直接大于了R

            while(L < right && arr[L++] < arr[pivot]){}
            while(R > left && arr[--R] > arr[pivot]){ }
            if(L < R){
                SortUtils.swap(arr, L, R);
            }else{
                break;
            }
        }
        SortUtils.swap(arr, left, R);
        return R;
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{
          7, 1, 2, 4, 5, 6, 2, 11, 9
        };
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }


}
