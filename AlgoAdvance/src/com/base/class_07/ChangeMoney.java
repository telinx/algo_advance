package com.base.class_07;

public class ChangeMoney {
    
    /**
     * 递归 具体分析可以画出 递归树
     * @param arr
     * @param index
     * @param aim
     * @return
     */
    public static int recursionProcess(int[] arr, int index, int aim) {
        if(index == arr.length) {
            return aim == 0 ? 1 : 0;
        }
        int res = 0;
        for(int i = 0; aim >= i * arr[index]; i++ ) {
            res += recursionProcess(arr, index + 1, aim - i * arr[index]);
        }
        return res;
    }
    
  
    
    public static void main(String[] args) {
        int arr[] = {5, 10, 25, 1};
        System.out.println(recursionProcess(arr, 0, 15));
    }

}
