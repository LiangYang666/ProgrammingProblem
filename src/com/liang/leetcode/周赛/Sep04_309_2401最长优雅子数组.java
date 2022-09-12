package com.liang.leetcode.周赛;

import java.util.Arrays;

public class Sep04_309_2401最长优雅子数组 {
    public int longestNiceSubarray(int[] nums) {
        int n = nums.length;
        int rs = 1;
        int[] L = new int[32];
        Arrays.fill(L, -1);
        int l = 0;
        for (int r = 0; r < n; r++) {
            int t = nums[r];
            for (int i = 0; i < 32; i++) {
                if (((t>>i)&1)==1){
                    if (L[i]!=-1){
                        l = Math.max(L[i]+1, l);
                    }
                    L[i] = r;
                }
            }
            rs = Math.max((r-l+1), rs);
        }
        return rs;
    }
}
