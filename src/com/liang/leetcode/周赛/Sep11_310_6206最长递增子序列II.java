package com.liang.leetcode.周赛;

import java.util.Arrays;

// 仅过了65/86 需要使用线段树 较难
public class Sep11_310_6206最长递增子序列II {
    public int lengthOfLIS(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n+1];
        int len = 1;
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = Integer.MIN_VALUE;
        dp[1] = nums[0];
        for (int i = 1; i < n; i++) {
            int num = nums[i];
            int tLen = len;
            for (int j = 1; j <= tLen+1; j++) {
                if (num>dp[j-1] && ((num-dp[j-1])<=k || dp[j-1]==Integer.MIN_VALUE)){
                    if (j==tLen+1){
                        len++;
                    }
                    dp[j] = Math.min(dp[j], num);
                }
            }
        }
        return len;
    }
}
