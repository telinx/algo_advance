package com.base.class_08;
/**
 * 给定两个数组w和v,两个数组长度相等
 * ,w[i]表示第i件商品的重量,
 * ,v[i]表示第i件商品的价值。 
 * 再给定一个整数bag,要求你挑选商品的重量加起来一定不能超 过bag,
 * 返回满足这个条件下,你能获得的最大价值。
 * @author yucang
 *
 */
public class C11_knapsack {
    
    public static int getMaxValue(int[] w, int[] v, int bag, int i, int weight) {
        if(weight < bag) {
            return 0;
        }
        if(i == w.length) {
            return 0;
        }
        return Math.max(
            getMaxValue(w, v, bag, i+1, weight)
            , 
            v[i]+getMaxValue(w, v, bag, i+1, weight+w[i])
           );
    }
    
    public static int dpProcess(int[] w, int[] v, int bag) {
        int row = w.length + 1;
        int col = bag + 1;
        int[][] dp = new int[row][col];
        for(int i = row - 2; i >=0; i--) {
            for(int j = col - 1; j >= 0; j--) {
                dp[i][j] = dp[i+1][j];
                if(w[i] + j <= bag) {
                    dp[i][j] = Math.min(dp[i][j], v[i] + dp[i+1][j+w[i]]);
                }
            }
        }
        return 0;
    }
}
