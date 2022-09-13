package com.liang.normal;

import java.util.LinkedList;

/**
 * @Description: TODO
 * @Author: LiangYang
 * @Date: 2022/9/13 上午8:15
 **/
public class M122买卖股票的最佳时机II {
    public int maxProfit(int[] prices) {
        int last = prices[0];
        int total = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i]>=last){
                total += (prices[i]-last);
            }
            last = prices[i];
        }
        return total;
    }
}
