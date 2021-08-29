package com.liang.offer;

import java.util.Arrays;

public class Offer57和为s的两个数字 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{10, 26, 30, 31, 47, 60}, 40)));
    }

    static
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        int i = 0;
        int j = n-1;
        while(i<j){
            if(nums[i]+nums[j]==target){
                return new int[] {nums[i], nums[j]};
            }else if (nums[i]+nums[j]<target){
                i++;
            }else {
                j--;
            }
        }
        return null;
    }
}
