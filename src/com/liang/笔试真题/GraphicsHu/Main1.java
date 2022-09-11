package com.liang.笔试真题.GraphicsHu;

/**
 * @ProjectName: ProgrammingProblem
 * @Package: com.liang.笔试真题.Graphics
 * @ClassName: Main1
 * @Description:
 * @Author: Yang Liang
 * @CreateDate: 2022/9/9 9:56
 * @Version: 1.0
 */
public class Main1 {
    public static void main(String[] args) {
        func("BOOK", "BOOL", 3);
    }
    static void func(String str1, String str2, int n){
        n = str1.length();
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (str1.charAt(i)==str2.charAt(j)){
                    dp[i+1][j+1] = Math.max(Math.max(dp[i][j]+1, dp[i+1][j]),dp[i][j+1]);
                } else {
                    dp[i+1][j+1] = Math.max(Math.max(dp[i][j], dp[i+1][j]),dp[i][j+1]);
                }
            }
        }
        System.out.println(dp[n][n]);
    }
}
