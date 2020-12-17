package com.base.class_03;

public class C9_ZhiPrint {
    
    static boolean status = true;
    
    public static void zhiPrint(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int a1 = 0;
        int b1 = 0;
        int a2 = 0;
        int b2 = 0;
        
        while(a1 < row && b1 < col && a2 < row && b2 < col) {
            toPrint(matrix, a1, b1, a2, b2);
            if(b1 < (col - 1)) {
                b1++;
            }else {
                a1++;
            }
            
            if(a2 < (row - 1)) {
                a2++;
            }else {
                b2++;
            }
        }
    }
    
    public static void toPrint(int[][] matrix, int a1, int b1, int a2, int b2) {
        if(status) {
            while(b1 >= b2) {
                System.out.println(matrix[a1++][b1--]);
            }
        }else {
            while(b2 <= b1) {
                System.out.println(matrix[a2--][b2++]);
            }
        }
        status = !status;
    }
    
    public static void main(String[] args) {
        int[][] matrix = new int[][] {
            {1, 2,  3,  4},
            {5, 6,  7,  8},
            {9, 10, 11, 12},
            {13, 14, 15, 16},
        };
        zhiPrint(matrix);
        
    }

}
