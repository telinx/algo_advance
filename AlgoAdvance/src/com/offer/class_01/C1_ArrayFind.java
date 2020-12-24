package com.offer.class_01;

/**
 * 在一个二维数组中（每个一维数组的长度相同），
 * 每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class C1_ArrayFind {

    public static boolean arrayFind(int[][] arr, int aim){
        boolean res =false;
        int i = 0;
        int j = arr[0].length;
        while(i < arr.length && j >= 0){
            if(arr[i][j] ==aim){
                return true;
            }else if(arr[i][j] > aim){
                i--;
            }else{
                j++;
            }

        }
        return res;
    }

    public static void main(String[] args) {
        String a = "a";
    }

}
