package com.base.class_08;

/**
 * 母牛每年生一只母牛,新出生的母牛成长三年后也能每年生一只母牛,
 * 假设不会死。求N年后,母牛的数量。
 * 
 * 这里很直接可以找到公式 f(n) = f(n-1) + f(n -3)
 * @author yucang
 *
 */

public class C6_Cow {
    
    public static int getCowNum(int years) {
        int res = 1;
        if(years < 1) {
            return 0;
        }
        if(years == 1 || years == 2 || years == 3) {
            return res;
        }
        int[] arr = new int[years + 1];
        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 3;
        for(int i = 4; i <= years; i++) {
            arr[i] = arr[i-1] + arr[i-3];
        }
        return arr[years];
    }
    
    public static void main(String[] args) {
        System.out.println(getCowNum(5));
    }

}
