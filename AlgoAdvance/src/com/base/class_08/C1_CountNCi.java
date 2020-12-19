package com.base.class_08;
/**
 * 求n!的结果
 * @author yucang
 *
 */
public class C1_CountNCi {
    
    public static int getCountCi(int n) {
        if(n < 1) {
            // throw
        }
        int res = 1;
        for(int i = n; i >= 1; i--) {
            res *= i;
        }
        return res;
    }
    
    public static int process(int n) {
        if(n < 1) {
            // throw
        }
        if(n <= 1) {
            return 1;
        }
        return n * process(n-1);
    }
    
    public static void main(String[] args) {
        System.out.println(process(4));
        System.out.println(getCountCi(4));
    }

}
