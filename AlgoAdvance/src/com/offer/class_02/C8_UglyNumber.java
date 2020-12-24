package com.offer.class_02;
/**
 * 丑数
 * 题目描述
 * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。
 * 例如6、8都是丑数，但14不是，因为它包含质因子7。 
 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 * @author yucang
 *
 */
public class C8_UglyNumber {
    
    /**
     * 首先从丑数的定义我们知道，一个丑数的因子只有2,3,5，
     * 那么丑数p = 2 ^ x * 3 ^ y * 5 ^ z，换句话说
     * 一个丑数一定由另一个丑数乘以2或者乘以3或者乘以5得到，
     * 所以下一个丑数必定由数组中的
     * 某一个丑数A * 2， B * 3， C * 5 的中的最小值得来。
     * @param n
     */
    public static void getNUglyNo(int n) {
        if(n < 7) {
            System.out.println(n);
            return; 
        }
        int[] arr = new int[n];
        arr[0] = 1;
        int t2 = 0;
        int t3 = 0;
        int t5 = 0;
        
        for(int i = 1; i < n; i++) {
            arr[i] = Math.min(arr[t2]*2, Math.min(arr[t3]*3, arr[t5]*5));
            if(arr[i] == arr[t2]*2) {
                t2++;
            }
            if(arr[i] == arr[t3]*3) {
                t3++;
            }
            if(arr[i] == arr[t5]*5) {
                t5++;
            }
        }
        System.out.println(arr[n-1]);
    }
    
}
