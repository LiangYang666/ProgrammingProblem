package com.liang.normal;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Index1760袋子里最少数目的球 {
    public static void main(String[] args) {
        minimumSize(new int[]{2,4,8,2}, 4);
    }
    static
    public int minimumSize(int[] nums, int maxOperations) {
        int r = 1;
        for (int num : nums) {
            if (num>r)  r=num;
        }
        int l = 1;
        int ans = 1;
        while (l<=r){
            int m = (l+r)>>1;
            int ops = 0;
            for (int i = 0; i < nums.length; i++) {
                ops += (nums[i]-1)/m;
            }
            if (ops<=maxOperations){
                ans = m;
                r = m-1;
            } else {
                l = m+1;
            }
        }
        return ans;
    }
}
