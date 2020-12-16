package com.advence.class_07;

public class ChangeMoney {
    
    /**
     * 递归 具体分析可以画出 递归树
     * @param arr
     * @param index
     * @param aim
     * @return
     */
    public static int recursionProcess(int[] arr, int index, int aim) {
        if(index == arr.length) {
            return aim == 0 ? 1 : 0;
        }
        int res = 0;
        for(int i = 0; aim >= i * arr[index]; i++ ) {
            res += recursionProcess(arr, index + 1, aim - i * arr[index]);
        }
        return res;
    }
    
    public static int dpProcess(int[] arr,int aim) {
        int[][] dp = new int[arr.length + 1][aim + 1];
        for(int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
        }
        for(int i = 1; i < dp[0].length; i++) {
            dp[arr.length][i] = 0;
        }
        
        for(int i = dp[0].length - 2; i >=0; i--) {
            for(int j = 1; j < dp[0].length; j++) {
//                dp[i][j] = dp[i + 1][j];
//                int subSum = (j - arr[i]);
//                for(; subSum >= 0; subSum-= arr[i]) {
//                    dp[i][j] += dp[i + 1][subSum];
//                }
                dp[i][j] = dp[i + 1][j];
                if(j - arr[i] >= 0) {
                    dp[i][j] += dp[i + 1][j - arr[i]];
                }
            }
        }
        return dp[0][aim + 1];
    }
    
  
    
    public static void main(String[] args) {
        int arr[] = {5, 10, 25, 1};
        System.out.println(recursionProcess(arr, 0, 15));
    }

}
