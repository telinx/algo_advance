package com.offer.class_01;

/**
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 */
public class C12_BinaryOneCnt {

    public static int binaryOneCnt(int n) {
        int res = 0;
        for(int i = 0; i < 32; i++) {
            System.out.println((n>>i )+ "--" +((n>>i) & 1));
            res += (n>>i) & 1;
        }
        return  res;

    }

    public static void main(String[] args) {
        System.out.println(binaryOneCnt(8));
    }

}
