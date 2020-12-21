package com.base.class_08;

import java.time.chrono.MinguoChronology;

/**
 * f(i, j) = res + Math.min(f(i-1, j), f(i, j+1))
 * 
 * 这中递归问题，需要反过来思维，从终点往回走，每次选取权重最小的
 * 又暴力递归得到dp
 * 暴力递归得到 
 *  1.可变参数
 *  2.base case
 *  3.位置依赖的关系
 * @author yucang
 *
 */
public class C9_GetMinPath {
    
    public static int getMinSum(int[][] matrix, int i, int j) {
       int res = matrix[i][j];
       if(i == 0 && j == 0) {
            return res;
       }
       if(i != 0 && j == 0) {
           return res += getMinSum(matrix, i - 1, j);
       }
       if(i == 0 && j != 0) {
           return res += getMinSum(matrix, i, j - 1);
       }
     
       return res + Math.min(getMinSum(matrix, i, j - 1), getMinSum(matrix, i - 1, j));
    }
    
    public static int dpProcess(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] dp = new int[row][col];
        dp[0][0] = matrix[0][0];
        for(int i = 1; i < row; i++) {
            dp[i][0] = dp[i-1][0] + matrix[i][0];
        }
        for(int i = 1; i < col; i++) {
            dp[0][i] = dp[0][i-1] + matrix[0][i];
        }
        for(int i = 1; i < row; i++) {
            for(int j = 1; j < col; j++) {
                dp[i][j] = matrix[i][j] + Math.min(dp[i-1][j], dp[i][j-1]);
            }
        }
        
        for(int i = 0; i<dp.length; i++) {
            for(int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + "\t");
            }
            System.out.println();
        }
        
        return dp[row - 1][col - 1];
    }
    
    public static void main(String[] args) {
        int[][] matrix = new int[][] {
            {1, 2, 3},
            {4, 1, 6},
            {4, 2, 4}
        };
        
        System.out.println(getMinSum(matrix, 2, 2));
        System.out.println(dpProcess(matrix));
    }

}
