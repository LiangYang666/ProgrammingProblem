package com.liang.面试常考算法题.codeTop;

/**
 * @ProjectName: ProgrammingProblem
 * @Package: com.liang.面试常考算法题.codeTop
 * @ClassName: T8最大子序和
 * @Description:
 * @Author: Yang Liang
 * @CreateDate: 2022/7/7 8:15
 * @Version: 1.0
 */
public class T8最大子序和 {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = 0;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i-1], 0)+nums[i];
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
