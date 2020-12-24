package com.offer.class_02;
/**
 * 求1+2+3+…+n
 * 既然不允许遍历求和
 * 
 * 递归
 * @author yucang
 *
 */
public class C22_SumOneToN {
   
    public static int getSum(int n) {
        if(n == 1) {
            return 1;
        }
        return n + getSum(n-1);
    }

}
