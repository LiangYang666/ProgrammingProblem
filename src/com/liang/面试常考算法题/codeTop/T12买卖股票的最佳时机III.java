package com.liang.面试常考算法题.codeTop;

/*
给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。

设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。

注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 */
public class T12买卖股票的最佳时机III {
    public int maxProfit(int[] prices) {
        int[] dp = new int[4];
        dp[0] = Integer.MIN_VALUE;
        dp[1] = Integer.MIN_VALUE;
        dp[2] = Integer.MIN_VALUE;
        dp[3] = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            dp[0] = Math.max(dp[0], -prices[i]);
            dp[1] = Math.max(dp[1], dp[0]+prices[i]);
            dp[2] = Math.max(dp[2], dp[1]-prices[i]);
            dp[3] = Math.max(dp[3], dp[2]+prices[i]);
        }
        return dp[3];
    }
}
