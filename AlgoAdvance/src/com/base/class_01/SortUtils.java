package com.base.class_01;

public class SortUtils {

    public static void swap(Integer[] arr, int i , int j) {
        Integer temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    public static void swap(int[] arr, int i , int j) {
        Integer temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
}
