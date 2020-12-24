package com.offer.class_02;

/**
 * 数组中只出现一次的数字
 * 一个整型数组里除了两个数字之外，其他的数字都出现了偶数次。
 * 请写程序找出这两个只出现一次的数字
 * 
 * 这种题型真心不怎会
 * @author yucang
 *
 */
public class C15_ArrAppearOnce {
    
    public static int[] getAppearOnce(int[] arr) {
        int[] res = new int[2];
        int xorSum = 0;
        for(int i = 0; i < arr.length; i++) {
            xorSum ^= arr[i];
        }
        xorSum = (xorSum ^ (xorSum - 1)) & xorSum;
        for(int i = 0; i < arr.length; i++) {
            res[0] = (arr[i] & xorSum) == 0 ? res[0]^arr[i] : res[0];
            res[1] = (arr[i] & xorSum) != 0 ? res[1]^arr[i] : res[1];
        }
        return res;
    }

}
