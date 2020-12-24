package com.offer.class_01;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 *
 *  进阶问题
 *  一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
 *  求该青蛙跳上一个n级的台阶总共有多少种跳法。
 */
public class C10_FrogJump {

    public static int jump(int n){
        if(n == 1){
            return 1;
        }
        if(n == 2){
            return 2;
        }
        return jump(n-1) + jump(n-2);
    }

    public static int jump1(int n){
        int res = 0;
        if(n == 1){
            return 1;
        }
        if(n == 2){
            return 2;
        }
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;

        for(int i = 3; i<=n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int a = jump(3);
        int b = jump1(3);
        System.out.println(a);
        System.out.println(b);
    }

    public static int goJump(int n) {
        if(n < 0){
            return 0;
        }
        if(n == 0){
           return 1;
        }
        int res = 0;
        for(int i = 1; i <= n; i++){
            res += goJump(i);
        }
        return res;

    }

    public static int dpJump(int n){
        if(n < 0){
            return 0;
        }
        if(n == 0){
            return 1;
        }
        int[] dp = new int[n+1];
        dp[0] = 1;
        for(int i = 1;  i < dp.length; i++){
            for(int j = 1; j <= i; i++){
                dp[i] += dp[j];
            }
        }
        return dp[n];
    }

}
