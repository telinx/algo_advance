package com.offer.class_02;

/**
 * 数组中出现次数超过一半的数
 * 题目描述
 * 数组中有一个数字出现的次数超过数组长度的一半，
 * 请找出这个数字。例如输入一个长度为9的数组
 * {1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，
 * 超过数组长度的一半，因此输出2。如果不存在则输出0。
 * @author yucang
 *
 */
public class C3_ArrAppearMoreThan {
    
    public static int appearMoreThanHalf(int[] arr) {
        if(arr == null || arr.length < 1) {
            return 0;
        }
        int res = 0;
        int target = arr[0];
        int count = 1;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == target) {
                count++;
            }else {
                count--;
                if(count == 0) {
                    target = arr[i];
                    count = 1;
                }
            }
        }
        if(count > 1) {
            return target;
        }
        return res;
    }
    
    public static void main(String[] args) {
        int[] arr = new int[] {
          1, 1, 1, 3, 2      
        };
        System.out.println(appearMoreThanHalf(arr));
    }

}
