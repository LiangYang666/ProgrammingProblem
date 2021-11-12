package com.liang.normal;

public class MIndex375猜数字大小II {
    public static void main(String[] args) {
        System.out.println(getMoneyAmount(11));
    }
    static
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n+1][n+1];
        for (int i = n-1; i > 0; i--) {
            for (int j = i+1; j <= n; j++) {
                int rs = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    rs = Math.min(rs, k+Math.max(dp[k+1][j], dp[i][k-1]));
                }
                dp[i][j] = rs;
            }
        }
        return dp[1][n];
    }
    /*  递归会超时
    static
    public int getMoneyAmount(int n) {
        return getMax(1, n);
    }
    static
    public int getMax(int l, int r){
        if(l>=r)    return 0;
        int rs=Integer.MAX_VALUE;
        for (int i = l; i <= r; i++) {
            rs = Math.min(Math.max(i+getMax(i+1, r), i+getMax(l,i-1)), rs);
        }
        return rs;
    }
    */


}
