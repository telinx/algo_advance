package com.offer.class_02;
/**
 * 不用加减乘除做加法

 * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 * @author yucang
 *
 */
public class C24_Plus {
    /**
     * 先得到 and xor
     * num1 = and << 1
     * num2 = xor
     * 
     * 条件num1 != 0
     * @param num1
     * @param num2
     * @return
     */
    public static int getSum(int num1, int num2) {
        
        int and = 0;
        int xor = 0;
        
        while(true) {
            and = num1 & num2; 
            xor = num1 ^ num2;
            num1 = and << 1;
            num2 = xor;
            if(and != 0) {
                break;
            }
        }
        
        return num2;
    }

}
