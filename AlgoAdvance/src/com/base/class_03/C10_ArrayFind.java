package com.base.class_03;

public class C10_ArrayFind {
    
    public static boolean arrayFind(int[][] matrix, int aim) {
        int col = matrix[0].length;
        int row = matrix.length;
        int i = 0;
        int j = col - 1;
        boolean found = false;
        while(i < row && j >= 0) {
            if(matrix[i][j] == aim) {
                found = true;
                break;
            }else if(matrix[i][j] < aim) {
                i++;
            }else if(matrix[i][j] > aim) {
                j--;
            }
        }
        return found;
    }
    
    public static void main(String[] args) {
        int[][] matrix = new int[][] {
            {1, 2,  3,  4},
            {5, 6,  7,  8},
            {9, 10, 11, 12},
            {13, 14, 15, 16},
        };
        System.out.println(arrayFind(matrix, 110));
    }

}
