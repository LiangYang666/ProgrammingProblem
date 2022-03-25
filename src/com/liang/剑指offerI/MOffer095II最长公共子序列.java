package com.liang.剑指offerI;

public class MOffer095II最长公共子序列 {
    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("adfbec", "abc"));

    }

    static
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m+1][n+1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(text1.charAt(i)==text2.charAt(j)){
                    dp[i+1][j+1] = dp[i][j]+1;
                }else {
                    dp[i+1][j+1] = Math.max(dp[i][j+1], dp[i+1][j]);
                }
            }
        }
//        System.out.println(Arrays.deepToString(dp));
        return dp[m][n];
    }

}
