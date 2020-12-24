package com.offer.class_02;

/**
 * 和为S的两个数字
 * 题目描述
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，
 * 使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 * 
 * 思路
 * 窗口模式
 * @author yucang
 *
 */
public class C17_ArrTwoEqualAim {
    
    public static void getArrTwoEqualAim(int[] arr, int aim) {
        // throw返回 至少大于等于2个
        int L = 0, R = 1;
        int len = arr.length;
        int sum = arr[L] + arr[R];
        int minMinus = Integer.MAX_VALUE;
        boolean exist = false;
        while(R < arr.length && L < R) {
            sum = arr[L] + arr[R];
            if(sum == aim) {
                exist = true;
                minMinus = Math.min(minMinus, arr[L] * arr[R]);
                L++;
            }else {
                if(sum < aim) {
                    sum += arr[++R];
                }else {
                    break;
                }
            }
           
        }
        
        if(exist) {
            System.out.println(minMinus);
        }else {
            System.out.println("不存在");
        }
    }
    
    public static void main(String[] args) {
        int[] arr = new int[] {
          1, 3, 3, 3, 4, 5, 6, 7, 8, 9, 10      
        };
        getArrTwoEqualAim(arr, 9);
    }
    

}
