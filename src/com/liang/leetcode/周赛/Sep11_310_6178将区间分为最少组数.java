package com.liang.leetcode.周赛;

public class Sep11_310_6178将区间分为最少组数 {
    // 类似于最多在线人数题
    public int minGroups(int[][] intervals) {
        int[] cac = new int[1000005];
        for (int i = 0; i < intervals.length; i++) {
            cac[intervals[i][0]]++;
            cac[intervals[i][1]+1]--;
        }
        int temp = 0;
        int rs = 0;
        for (int i = 0; i < cac.length; i++) {
            temp = cac[i]+temp;
            rs = Math.max(rs, temp);
        }
        return rs;
    }
}
