package com.liang.normal;

/**
 * @Description: TODO
 * @Author: LiangYang
 * @Date: 2022/9/13 上午8:11
 **/
public class S121买卖股票的最佳时机 {
    public int maxProfit(int[] prices) {
        int lMin = Integer.MAX_VALUE;
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            lMin = Math.min(lMin, prices[i]);
            max = Math.max(max, prices[i]-lMin);
        }
        return max;
    }
}
