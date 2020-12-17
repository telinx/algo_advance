package com.base.class_03;

public class C7_RonateMatrix {

    public static void ronateMatrix(int[][] matrix ) {
        int row = matrix.length;
        int col = matrix[0].length;
        int a1 = 0;
        int b1 = 0;
        int a2 = row - 1;
        int b2 = col - 1;
        while(b1 < col && a1 < row && a2 > 0 && b2 > 0) {
            toChange(matrix, a1++, b1++, a2--, b2--);
        }
    }
    
    public static void toChange(int[][] matrix, int a1, int b1, int a2, int b2) {
        int len = a2 - a1;
        for(int i = 0; i < len; i++) {
            int temp = matrix[a1][b1 + i];
            matrix[a1][b1 + i] = matrix[a2 - i][b1];
            matrix[a2 - i][b1] = matrix[a2][b2 - i];
            matrix[a2][b2 - i] = matrix[a1 + i][b2];
            matrix[a1 + i][b2] = temp;
        }
    }
    
    public static void main(String[] args) {
        int[][] matrix = new int[][] {
            {1, 2,  3,  4},
            {5, 6,  7,  8},
            {9, 10, 11, 12},
            {13, 14, 15, 16},
        };
        ronateMatrix(matrix);
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
