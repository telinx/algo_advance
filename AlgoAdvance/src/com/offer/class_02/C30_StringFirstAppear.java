package com.offer.class_02;
/**
 * 字符流中第一个只出现一次的字符
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。
 * 例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 * @author yucang
 * 
 * 思路
 * asc 256位的长度数组
 * 默认设置为-1
 * 初次进入为1
 * 再次进入为-2
 */
public class C30_StringFirstAppear {
    
    public static int firstAppear(char[] arr) {
        int res = -1;
        int[] ascArr = new int[256];
        for(int i = 0; i < 256; i++) {
            ascArr[i] = -1;
        }
        for(char c : arr) {
            int idx = (int)c;
            if(ascArr[idx] == -1) {
                ascArr[idx] = 1;
            }else {
                ascArr[idx] = -2;
            }
        }
        
        for(int i = 0; i < arr.length; i++) {
            int idx = (int)arr[i];
            if(ascArr[idx] == 1) {
                return i;
            }
        }
        return res;
    }

}
