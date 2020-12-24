package com.offer.class_02;
/**
 * 字符串全排列
 * 题目描述
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的
 * 所有字符串abc,acb,bac,bca,cab和cba。
 * @author yucang
 *
 */
public class C2_StringArrange {
    
    public static void arrange(String str) {
        if(str == null && str.length() < 1) {
            return;
        }
        if(str.length() == 1) {
            System.out.println(str);
            return;
        }
        process(str.toCharArray(), 0);
    }
    
    public static void process(char[] arr, int i) {
        if(i == arr.length) {
            System.out.println(new String(arr));
            return;
        }
        for(int j = i; j < arr.length; j++) {
            swapStr(arr, i, j);
            process(arr, i+1);
        }
    }
    
    public static void swapStr(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    public static void main(String[] args) {
        String a = "abc";
        arrange(a);
    }

}
