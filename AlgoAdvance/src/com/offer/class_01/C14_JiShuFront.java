package com.offer.class_01;

/**
 * 调整数组顺序使奇数位于偶数前面
 */
public class C14_JiShuFront {

    public static void process(int[] arr) {
        int index = 0;
        for(int i = 0;i < arr.length; i++){
            if(arr[i] % 2 == 1){
                int temp = arr[index];
                arr[index] = arr[i];
                arr[i] = temp;
                index++;
            }
        }
    }
}
