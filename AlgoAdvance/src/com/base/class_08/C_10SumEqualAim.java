package com.base.class_08;
/**
 * 给你一个数组arr,和一个整数aim。
 * 如果可以任意选择arr中的数字,能不能累加得到aim,返回true或者false
 * 
 * 注意dp的范围 一定不能错！！！！
 * @author yucang
 *
 */
public class C_10SumEqualAim {
    
    public static boolean process(int[] arr, int i, int aim) {
        if(aim == 0) {
            return true;
        }
        if(i == arr.length) {
            return aim == 0;
        }
        return process(arr, i+1, aim) || process(arr, i+1, aim - arr[i]);
    }
    
    public static boolean dpProcess(int[] arr, int aim) {
        int dpRow = arr.length+1;
        int dpCol = aim + 1;
        boolean[][] dp = new boolean[dpRow][dpCol];
        for(int i = 0; i < dpRow; i++) {
            dp[i][0] = true;
        }
        for(int i = 1; i < dpCol; i++) {
            dp[arr.length - 1][i] = false;
        }
        for(int i = dpRow - 2; i >= 0; i--) {
            for(int j = 1; j < dpCol; j++) {
                dp[i][j] = dp[i+1][j];
                if(j - arr[i] >= 0) {
                    dp[i][j] = dp[i][j] || dp[i+1][j - arr[i]];
                }
            }
        }
        
        for(int i = 0; i < dpRow; i++) {
            for(int j = 0; j < dpCol; j++) {
                System.out.print(dp[i][j] + "\t");
            }
            System.out.println();
        }
        return dp[0][aim];
    }
    
    
    public static void main(String[] args) {
        int[] arr = new int[] {4, 2, 5};
        System.out.println(dpProcess(arr, 7));
        System.out.println(process(arr, 0, 1));
    }
}
