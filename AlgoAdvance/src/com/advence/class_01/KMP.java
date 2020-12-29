package com.advence.class_01;

import java.util.Arrays;

/**
 * 核心思想求出部分匹配值
 * 注意next[0] = -1
 * https://www.cnblogs.com/imzhr/p/9613963.html
 * @author yucang
 *
 */
public class KMP {
    //ABCABCD
    /**
     * 最核心的思路
     * 比如第二个C前面是ABCABC 第二个C的部分匹配值是2 前缀AB后缀AB
     * 那走到D就是前面是ABCABCA 只要保证新来也是C 部分匹配值+1  chars[k-1] == chars[next[k - 1]]，
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
//        int k = 2;
//        while(k < chars.length) {
//            int val = next[k - 1];
//            if(chars[k-1] == chars[val]) {
//                next[k++] = val + 1;
//            }else {
//                next[k++] = 0;
//            }
//        }
        for(int k = 2; k < chars.length; k++) {
            int val = next[k - 1];
            while(val != -1) { // 这段代码 比如AsadafeqeAX，这种情况是要匹配A A的
              if(chars[k-1] == chars[val]) {
                  next[k] = val + 1;
                  break;
              }else {
                  val = next[val];
              }
              next[k] = 0;
            }
            
        }
        return next;
    }

    /**
     * i 指针只能往前 不能退后 j指针可退后
     * @param content
     * @param exp
     * @return
     */
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
                // 注意第一个就匹配不上的时候是-1
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
