package com.advence.class_01;

import java.util.Arrays;

/**
 * 核心思想求出部分匹配值
 * @author yucang
 *
 */
public class KMP {
    //ABCABCD
    /**
     * 最核心的思路
     * 比如第二个C前面是ABCAB 部分匹配值是2 前缀AB后缀AB 
     * 那走到D就是前面是ABCABC 只要保证新来也是C 部分匹配值+1  chars[k-1] == chars[next[k - 1]]，
     * 否则就是0
     * @param chars
     * @return
     */
    public static int[] next(char[] chars) {
        if(chars.length == 1) {
            return new int[] {-1};
        }
        int[] next = new int[chars.length];
        next[0] = -1;
        next[1] = 0;
        int k = 2;
        while(k < chars.length) {
            int val = next[k - 1];
            if(chars[k-1] == chars[val]) {
                next[k++] = val + 1;
            }else {
                next[k++] = 0;
            }
        }
        return next;
    }
    
    public static int kmp(char[] content, char[] exp) {
        if(content == null || content.length < 1 || exp == null || exp.length < 1) {
            System.out.println("Data is invalid!");
            return -1;
        }
        int[] next = next(exp);
        int i = 0;
        int j = 0;
        while(i < content.length && j < exp.length) {
            if(content[i] == exp[j]) {
                i++;
                j++;
            }else {
                i++;
                // 注意地一个就匹配不上的时候是-1
                j = next[j] != -1 ? next[j] : j;  
            }
        }
        return j == exp.length ? i - j : -1;
    }
    
    public static void main(String[] args) {
        String content = "DBCDABCABCD!";
        String exp = "ABCABCD";
        
        int index = kmp(content.toCharArray(), exp.toCharArray());
        System.out.println(index);
        System.out.println(Arrays.toString(next("ABCDABD".toCharArray())));
        System.out.println(Arrays.toString(next("123123123123".toCharArray())));
        
    }

}
