package com.base.class_08;

/**
 * 打印一个字符串的全部排列
 * 这个真不知道
 * @author yucang
 *
 */
public class C4_ArrangStrArr {
    
    public static void process(String str) {
        char[] arr = str.toCharArray();
        subPring(arr, 0);
    }
    
    public static void subPring(char[] arr, int i) {
        if(i == arr.length) {
            System.out.println(String.valueOf(arr));
            return;
        }
        for(int j = i; j < arr.length; j++) {
            swap(arr, i, j);
            subPring(arr, i + 1);
        }
    }
      
    public static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    public static void main(String[] args) {
        process("abc");
    }
    
}
