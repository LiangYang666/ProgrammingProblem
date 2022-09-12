package com.liang.leetcode.周赛;

import java.util.Arrays;

public class Sep11_310_6176出现最频繁的偶数元素 {
    public static void main(String[] args) {
        // input []
        System.out.println(mostFrequentEven(new int[]{2, 10000, 10000, 10000, 2}));
    }
    static
    public int mostFrequentEven(int[] nums) {
        int longestNumber = -1;
        int longestTotal = 0;
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            int tempTotal = 0;
            if ((temp&1)==0){
                while (i<nums.length && temp==nums[i]){
                    tempTotal++;
                    i++;
                }
                i--;
                if (tempTotal>longestTotal){
                    longestTotal=tempTotal;
                    longestNumber = temp;
                }
            }
        }
        return longestNumber;
    }
}
