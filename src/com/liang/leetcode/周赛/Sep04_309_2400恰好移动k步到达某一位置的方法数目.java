package com.liang.leetcode.周赛;

public class Sep04_309_2400恰好移动k步到达某一位置的方法数目 {

    public int numberOfWays(int startPos, int endPos, int k) {
        int mod = (int) (1e9+7);
        int move = Math.abs(endPos-startPos);
        int add = k-move;
        if (add<0 || add%2!=0)    return 0;
        int n1 = add/2+move;
        int n0 = add/2;
        int n = n0+n1;
        int m = n1;
        long rs = 1;
        // c(n, m) = c(n-1, m)+c(n-1, m-1);
        int[][] c = new int[n + 1][m + 1];
        c[1][1] = 1;
        for (int i = 2; i <= n; i++) {
            c[i][1] = i;
            for (int j = 2; j <= m && j<=i; j++) {
                c[i][j] = (c[i-1][j-1]+c[i-1][j])%mod;
            }
        }
        return c[n][m];
    }
}
