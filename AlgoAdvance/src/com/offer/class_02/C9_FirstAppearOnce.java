package com.offer.class_02;
/**
 * 第一个只出现一次的字符
 * 题目描述
 * 在一个字符串(0<=字符串长度<=10000，
 * 全部由字母组成)中找到第一个只出现一次的字符,
 * 并返回它的位置, 如果没有则返回 -1（需要区分大小写）.
 * 
 * 思路
 * 创建一个asc 256长度的数组，初始默认值-1
 * 第一次进入设置为下标，再次进入设置为-2
 * @author yucang
 *
 */
public class C9_FirstAppearOnce {
    
    public static int firstAppearOnce(char[] arr) {
        int res = -1;
        int[] ascArr = new int[256];
        for(int i = 0; i < ascArr.length; i++) {
            ascArr[i] = -1;
        }
        for(int i = 0; i < arr.length; i++) {
            int index = (int)arr[i];
            if(ascArr[index] == -1) {
                ascArr[index] = i;
            }else {
                ascArr[index] = -2;
            }
        }
        
        if(arr.length > 256) {
            for(int i = 0; i < ascArr.length; i++) {
                if(ascArr[i] > 0 && res == -1) {
                    res = ascArr[i];
                }else if(ascArr[i] > 0 && res > -1) {
                    res = Math.min(res, ascArr[i]);
                }
            }
        }else {
            for(int i = 0; i < arr.length; i++) {
                int index = (int)arr[i];
                if(ascArr[index] > -1) {
                    return i;
                }
            }
        }
        
        
        return res;
    }

}
