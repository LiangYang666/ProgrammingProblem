package com.liang.面试常考算法题.codeTop;

import java.util.LinkedList;

public class T12买卖股票的最佳时机 {
    public int maxProfit(int[] prices) {
        int[] dp = new int[2];
        dp[0] = Integer.MIN_VALUE;
        dp[1] = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            dp[0] = Math.max(dp[0], -prices[i]);
            dp[1] = Math.max(dp[1], dp[0]+prices[i]);
        }
        return dp[1];
    }
}
