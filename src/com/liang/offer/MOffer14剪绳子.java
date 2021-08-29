package com.liang.offer;

public class MOffer14剪绳子 {
    public static void main(String[] args) {

        System.out.println(cuttingRope(10));
    }

    static
    public int cuttingRope(int n) {

        int[] dp = new int[n+1];
        switch (n){
            case 0:return 0;
            case 1:
            case 2:return 1;
            case 3:return 2;
            default:
                dp[0] = 0;
                dp[1] = 1;
                dp[2] = 2;
                for (int i = 4; i <= n; i++) {
                    dp[i] = i;
                    for (int j = 1; j < i; j++) {
                        dp[i] = Math.max(dp[i], dp[j]*(i-j));
                    }
                }
                return dp[n];
        }
    }
}
