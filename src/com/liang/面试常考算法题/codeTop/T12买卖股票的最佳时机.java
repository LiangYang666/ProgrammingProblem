package com.liang.面试常考算法题.codeTop;

import java.util.LinkedList;

public class T12买卖股票的最佳时机 {
    public int maxProfit(int[] prices) {    // 一次遍历
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            maxProfit = Math.max(maxProfit, prices[i]-minPrice);
            minPrice = Math.min(prices[i], minPrice);
        }
        return maxProfit;
    }
}
