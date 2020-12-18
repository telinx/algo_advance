package com.base.class_05;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class C2_IslandInfect {
    
    private static List<Island> islandList = new ArrayList<>();
    
    public static class Compator1 implements Comparator<Island>{
        @Override
        public int compare(Island o1, Island o2) {
            return o2.area - o1.area;
        }
    }
    
    public static class Island{
        String no;
        Integer area = 0;
        List<String> nodes = new ArrayList<>();
        public Island(String no) {
            this.no = no;
        }
       
    }
    
    public static int process(int[][] matrix) {
        int res = 0;
        int row = matrix.length;
        int col = matrix[0].length;
        for(int i = 0; i < row; i++) {
           for(int j = 0; j < col; j++) {
               if(matrix[i][j] == 1) {
                   res++;
                   Island island = new Island(String.valueOf(res));
                   inject(i, j, row, col, island, matrix);
                   islandList.add(island);
               }
           }
        }   
        return res;
    }
    
    public static void inject(int i, int j, int row, int col, Island island, int[][] matrix) {
        if(i < 0 || j < 0 || i > row || j > col || matrix[i][j] != 1) {
            return;
        }
        matrix[i][j] = 2;
        island.area++;
        System.out.println(i + "-" + j);
        island.nodes.add(i + "-" + j);
        inject(i-1, j, row, col, island, matrix);
        inject(i+1, j, row, col, island, matrix);
        inject(i, j-1, row, col, island, matrix);
        inject(i, j+1, row, col, island, matrix);
    }
    
    public static Island getMaxAreaIsland() {
        if(islandList.size() == 0) {
            return null;
        }
        islandList.sort(new Compator1());
        return islandList.get(0);
    }
    
    public static int getMaxAreaIslandArea() {
        if(islandList.size() == 0) {
            return 0;
        }
        islandList.sort(new Compator1());
        return islandList.get(0).area;
    }
    
    public static void main(String[] args) {
        int[][] matrix = { { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, // 0
                { 0, 1, 1, 1, 0, 1, 1, 1, 0 }, // 1
                { 0, 1, 1, 1, 0, 0, 0, 1, 0 }, // 2
                { 0, 1, 1, 0, 0, 0, 0, 0, 0 }, // 3
                { 0, 0, 0, 0, 0, 1, 1, 0, 0 }, // 4
                { 0, 0, 0, 0, 1, 1, 1, 0, 0 }, // 5
                { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, };// 6
        System.out.println("==================第零题==================");
        System.out.println("一共有：" + process(matrix) + "座岛");
        System.out.println("==================第一题==================");
        System.out.println("最大岛面积：" + getMaxAreaIslandArea());
       
    }
    

}
