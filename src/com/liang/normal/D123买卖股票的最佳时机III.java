package com.liang.normal;

import java.util.Arrays;

/**
 * @Description: TODO
 * @Author: LiangYang
 * @Date: 2022/9/13 上午8:46
 **/
public class D123买卖股票的最佳时机III {
    public int maxProfit(int[] prices) {
        int[] dp = new int[4];
        int n = prices.length;
        Arrays.fill(dp, Integer.MIN_VALUE);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 4; j++) {
                if (j==0){
                    dp[j] = Math.max(dp[j], -prices[i]);
                } else if (j%2==0){
                    dp[j] = Math.max(dp[j], dp[j-1]-prices[i]);
                } else {
                    dp[j] = Math.max(dp[j], dp[j-1]+prices[i]);
                }
            }
        }
        return dp[3];
    }
}
