package com.base.class_03;

public class C6_CirclePrintMatrix {
    
    
    public static void circlePrintMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int a1 = 0;
        int b1 = 0;
        int a2 = row - 1;
        int b2 = col - 1;
        while(b1 < col && a1 < row && a2 > 0 && b2 > 0) {
            toPrint(matrix, a1++, b1++, a2--, b2--);
        }
    }
    
    public static void toPrint(int[][] matrix, int a1, int b1, int a2, int b2) {
        int Y = b1;
        int X = a1;
        while(X < b2) {
            System.out.println(matrix[a1][X++]);
        }
        while(Y < a2) {
            System.out.println(matrix[Y++][b2]);
        }
        while(X > b1) {
            System.out.println(matrix[a2][X--]);
        }
        while(Y > a1) {
            System.out.println(matrix[Y--][b1]);
        }
    }
    
    public static void main(String[] args) {
        int[][] matrix = new int[][] {
            {1, 2,  3,  4},
            {5, 6,  7,  8},
            {9, 10, 11, 12},
            {13, 14, 15, 16},
        };
        circlePrintMatrix(matrix);
    }
}
