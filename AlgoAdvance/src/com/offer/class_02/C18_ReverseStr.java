package com.offer.class_02;

/**
 * 旋转字符串
 * 题目描述
 * 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，
 * 就是用字符串模拟这个指令的运算结果。对于一个给定的字符序列S，
 * 请你把其循环左移K位后的序列输出。例如，字符序列S=”abcXYZdef”,
 * 要求输出循环左移3位后的结果，即“XYZdefabc”。
 * 是不是很简单？OK，搞定它！
 * @author yucang
 *
 */
public class C18_ReverseStr {
    
    public static String reverseStr(String str, int i) {
        // return 不合法
        char[] arr = str.toCharArray();
        swap(arr, 0, i-1);
        swap(arr, i, arr.length - 1);
        swap(arr, 0, arr.length - 1);
        return new String(arr);
    }
    
    public static void swap(char[] arr, int m, int n) {
        for(; m < n; m++, n--) {
            char temp = arr[m];
            arr[m] = arr[n];
            arr[n] = temp;
        }
    }
    
    public static void main(String[] args) {
        System.out.println(reverseStr("abcXYZdef", 3));
    }

}
