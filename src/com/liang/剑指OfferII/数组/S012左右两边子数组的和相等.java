package com.liang.剑指OfferII.数组;

import java.util.Arrays;
import java.util.HashMap;

public class S012左右两边子数组的和相等 {
    public static void main(String[] args) {
        int a =-5;
    }
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        int total = sum;
        sum = 0;
        for (int i = 0; i < n; i++) {
            if ((sum<<1)==(total-nums[i]))  return i;
            sum+=nums[i];
        }
        return -1;
    }
}
