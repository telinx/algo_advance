package com.base.class_08;

/**
 * 如果每只母牛只能活10年,求N年后,母牛的数量。
 * 上题目引申
 * f(n) = f(n-1) + f(n-3) + f(n - 10)
 * @author yucang
 *
 */
public class C7_CowDeath {

    
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
            if(i > 10) {
                arr[i] -= arr[i-10];
            }
        }
        return arr[years];
    }
    
    public static void main(String[] args) {
        System.out.println(getCowNum(5));
    }


}
