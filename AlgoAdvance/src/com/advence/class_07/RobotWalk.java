package com.advence.class_07;

/**
 * 给你标号为1、2、3、……、N的N个位置，机器人初始停在M位置上，
 * 走P步后停在K位置上的走法有多少种。注：机器人在1位置上时只能向右走，
 * 在N位置上时只能向左走，其它位置既可向右又可向左。
 * @author yucang
 *
 */
public class RobotWalk {
    
    public static int process(int N, int M, int P, int K) {
        if(P == 0) {
            return M == K ? 1 : 0;
        }
        if(M == 1) {
            return process(N, M + 1, P - 1, K);
        }
        if(M == N) {
            return process(N, M - 1, P - 1, K);
        }else {
            return process(N, M + 1, P - 1, K) + process(N, M - 1, P - 1, K);
        }
    }
    
    
    public static int dpProcess(int N, int M, int P, int K) {
        int[][] dp = new int[P + 1][N + 1];
        dp[0][K] = 1;
        for(int i = 1; i < dp.length; i++) {
            for(int j = 1; j<dp[0].length; j++) {
                if(j == 1) {
                    dp[i][j] = dp[i - 1][j + 1];
                }else if(j == N){
                    dp[i][j] = dp[i - 1][j - 1];
                }else {
                    dp[i][j] = dp[i - 1][j + 1] + dp[i - 1][j - 1];
                }
            }
        }
        
        return dp[P][M];
    }

}
