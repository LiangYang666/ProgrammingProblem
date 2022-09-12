package com.liang.面试常考算法题.背包问题;

// 可优化 每一次dp只与上次有关，可以用一维dp优化
public class 力扣416分割等和子集 {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        int maxNum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
            maxNum = Math.max(maxNum, nums[i]);
        }
        int target = sum/2;
        if (sum%2!=0 || n<=1 || maxNum>target){
            return false;
        }
        boolean[][] dp = new boolean[n][target+1];
        dp[0][nums[0]] = true;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < target + 1; j++) {
                dp[i][j] = dp[i-1][j] | (j-nums[i]>=0?dp[i-1][j-nums[i]]:false);
            }
        }
        return dp[n-1][target];
    }
}
