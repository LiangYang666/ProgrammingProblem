package com.liang.面试常考算法题.codeTop;

public class T40编辑距离 {
    public static void main(String[] args) {
        String a = "horse";
        String b = "ros" ;
        System.out.println(minDistance(a, b));

    }

    static
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m+1][n+1];
        dp[0][0]=0;
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= n; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1])+1;
                int temp = dp[i-1][j-1];
                if (word1.charAt(i-1)!=word2.charAt(j-1)){
                    temp+=1;
                }
                dp[i][j] = Math.min(temp, dp[i][j]);
            }
        }
        return dp[m][n];
    }
}
