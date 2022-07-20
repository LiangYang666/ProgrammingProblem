package com.liang.面试常考算法题.codeTop;

import java.util.Arrays;

public class T28最长递增子序列 {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] d = new int[n + 1];
        int i = 0;
        d[0] = Integer.MIN_VALUE;
        for (int j = 0; j < n; j++) {
            if (d[i]>=nums[j]) {
                int l =0, r = i;
                while (l<r){
                    int m = (l+r)>>1;
                    if (d[m]<nums[j]){
                        l = m+1;
                    } else {
                        r = m;
                    }
                }
                d[l] = nums[j];
            } else {
                d[++i] = nums[j];
            }
        }
        return i;
    }
}
