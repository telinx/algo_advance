package com.interview.backtrack;

import java.util.LinkedList;
import java.util.List;

public class C2_EightQueue {

    private int queens = 0;
    List<List<String>> res = new LinkedList<>();
    int[][] board;
    int map = 0;


    List<List<String>> solveNQueues(int n){
        res.clear();
        this.queens = n;
        this.board =  new int[n][n];
        LinkedList<String> track = new LinkedList<>();
        backtrack(track, 0);
        return res;
    }

    void backtrack(LinkedList<String> track, int row){

        if(row >= this.queens){
            map++;
            // print();
            res.add(new LinkedList<>(track));
            return;
        }

        for(int col = 0; col < this.queens; col++){
            if(check(row, col)){
                board[row][col] = 1;
                track.add("[" + row + ", " + col +"]");
                backtrack(track,row+1);
                track.pollLast();
                board[row][col] = 0;
            }
        }


    }

    public  void print(){//打印结果
        System.out.print("方案"+map+":"+"\n");
        for(int i=0;i<8;i++){
            for(int m=0;m<8;m++){
                if(board[i][m]==1){
                    //System.out.print("皇后"+(i+1)+"在第"+i+"行，第"+m+"列\t");
                    System.out.print("o ");
                }
                else{
                    System.out.print("+ ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }



    public boolean check(int row, int col){
        // 位置冲突
        for(int i = 0; i < this.queens; i++){
            if(this.board[i][col] == 1){
                return false;
            }
        }
        // 左对角线冲突
        for(int i = row-1, j = col-1; i>=0 && j>=0; i--, j--){
            if(this.board[i][j] == 1){
                return false;
            }
        }
        // 右对角线冲突
        for(int i = row-1, j = col+1; i>=0 && j<this.queens; i--, j++) {
            if(this.board[i][j] == 1){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        C2_EightQueue eightQueue = new C2_EightQueue();
        eightQueue.solveNQueues(8);
        for(List<String> list : eightQueue.res){
            System.out.println(list.toString());
        }
        System.out.println(eightQueue.res.size());
    }


}
