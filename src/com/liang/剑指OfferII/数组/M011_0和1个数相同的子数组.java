package com.liang.剑指OfferII.数组;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class M011_0和1个数相同的子数组 {
    public static void main(String[] args) {
        System.out.println(findMaxLength(new int[] {0, 1, 0}));
    }
    static
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        int pre_diff = 0;
        int[] pre_diffs = new int[n + 1];
        HashMap<Integer, Integer> map = new HashMap<>();
        int max_length = 0;
        pre_diffs[0] = 0;
        map.put(0, 0);
        for (int i = 1; i < n+1; i++) {
            pre_diff = pre_diff+(nums[i-1]==1?1:-1);
            pre_diffs[i] = pre_diff;
            map.putIfAbsent(pre_diff, i);
        }
        for (int i = n; i >=0; i--) {
            pre_diff=pre_diffs[i];
            if (map.containsKey(pre_diff)){
                max_length = Math.max(i-map.get(pre_diff), max_length);
            }
            if (max_length>=i)  return max_length;
        }
        return max_length;
    }

}
