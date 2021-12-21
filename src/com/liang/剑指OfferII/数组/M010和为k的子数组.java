package com.liang.剑指OfferII.数组;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class M010和为k的子数组 {
    public static void main(String[] args) {
        int[] nums = {-1, -1, 1};
        int k = 0;
        System.out.println(subarraySum(nums, k));
    }
    static
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int rs=0;
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            rs += map.getOrDefault(sum-k, 0);
            map.put(sum, map.getOrDefault(sum, 0)+1);
        }
        return rs;
    }
}
