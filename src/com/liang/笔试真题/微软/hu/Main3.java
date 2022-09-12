package com.liang.笔试真题.微软.hu;

import java.util.Arrays;

public class Main3 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{4, 2, 3, 7}, 2, 2));
    }

    static
    public int solution(int[] A, int X, int Y){
        int N = A.length;
        int[][] dp = new int[N+1][X+1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= X; j++) {
                int temp = i-X>=0 ? dp[i-X][j-1]:Integer.MAX_VALUE;
                if (j==1)   temp = A[i-1];
                dp[i][j] = Math.min(A[i-1]+temp, dp[i-1][j]);
            }
        }
        return dp[N][X];
    }
}
