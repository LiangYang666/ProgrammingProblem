package com.liang.笔试真题.oppo;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    }
    public long tourismRoutePlanning (int scenicspot) {
        // write code here
        if (scenicspot==1)  return 1;
        int[] dp = new int[scenicspot+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= scenicspot; i++) {
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[scenicspot];
    }
}
