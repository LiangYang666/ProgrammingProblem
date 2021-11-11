package com.liang.normal;

import java.util.Arrays;

public class DIndex629K个逆序对数组 {
    public static void main(String[] args) {
        System.out.println(kInversePairs(3, 3));

    }
    static
    public int kInversePairs(int n, int k) {
        int mod = (int)(Math.pow(10, 9))+7;
        long[][] dp = new long[n+1][k+1];
        dp[1][0] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i][0] = 1;
            for (int j = 1; j <= k; j++) {
                dp[i][j] = dp[i-1][j];
                long last = dp[i][j-1];
                if (j>(i-1))
                    last -= dp[i-1][j-i];
                    if (last<0) last+=mod;
                dp[i][j] += last;
                if(dp[i][j]>mod){
                    dp[i][j]-=mod;
                }
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return (int)dp[n][k];
    }
}
