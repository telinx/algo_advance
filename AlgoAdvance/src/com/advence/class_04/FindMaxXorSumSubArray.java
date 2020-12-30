package com.advence.class_04;

import java.util.HashMap;

/**
 * 这个有点男。。。
 * 改天补上
 *
 * 思路两种情况
 * 1.当前下标异或和没出现过得xorSum, xorSum = 0的子数组个数等同上一个
 * 2.当前下标异或和累加出现过得xorSum, xorSum = 0的子数组个数等同上一个
 *
 * 0^N = N  N^N = 0
 * @author yucang
 *
 */
public class FindMaxXorSumSubArray {

    public int findMaxXorSumSubArray(int[] arr){
        int len = arr.length;
        int[] dp = new int[len];
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int xorSum = 0;
        for(int i = 0; i < len; i++){
            xorSum ^= arr[i];
            if(!map.containsKey(xorSum)){
                dp[i] = i > 0 ? dp[i-1] : 0;
            }else{
                int index = map.get(xorSum);
                dp[i] = index > 0 ? dp[index] + 1 : 1;
            }
            map.put(xorSum, i);
        }
        return dp[len-1];
    }
    
}
