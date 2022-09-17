package com.liang.normal;

import java.util.Arrays;

/**
 * @ProjectName: ProgrammingProblem
 * @Package: com.liang.normal
 * @ClassName: D188买卖股票的最佳时机IV
 * @Description:
 * @Author: Yang Liang
 * @CreateDate: 2022/9/16 21:33
 * @Version: 1.0
 */
public class D188买卖股票的最佳时机IV {
    public int maxProfit(int k, int[] prices) {
        int[] dp = new int[2 * k];
        Arrays.fill(dp, Integer.MIN_VALUE);
        for (int i = 0; i < prices.length; i++) {
            for (int j = 0; j < 2 * k; j++) {
                if (j==0){
                    dp[j] = Math.max(dp[j], -prices[i]);
                } else if (j%2==0){
                    dp[j] = Math.max(dp[j], dp[j-1]-prices[i]);
                } else {
                    dp[j] = Math.max(dp[j], dp[j-1]+prices[i]);
                }
            }
        }
        return dp[2*k-1];
    }
}
