package com.offer.class_02;

import java.util.Arrays;
import java.util.Comparator;
/**
 * 把数组排成最小的数
 * 题目描述
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，
 * 打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的
 * 最小数字为321323。
 * @author yucang
 *
 */
public class C7_ArrangeSmallArr {
    
    public static class Comparator1 implements Comparator<Integer>{

        @Override
        public int compare(Integer o1, Integer o2) {
            String v1 = String.valueOf(o1) + String.valueOf(o2);
            String v2 = String.valueOf(o2) + String.valueOf(o1);
            return Integer.parseInt(v1) - Integer.parseInt(v2);
        }
        
    }
    
    public static String arrangeMin(Integer[] arr) {
        StringBuffer res = new StringBuffer();
        Arrays.sort(arr, new Comparator1());
        for(int val : arr) {
            res.append(val);
        }
        return res.toString();
    }
    
    public static void main(String[] args) {
        Integer[] arr = new Integer[] {
                3,32,321   
        };
        System.out.println(arrangeMin(arr));
    }

}
