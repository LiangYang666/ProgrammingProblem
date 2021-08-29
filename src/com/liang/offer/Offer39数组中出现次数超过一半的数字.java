package com.liang.offer;

import java.util.Arrays;

public class Offer39数组中出现次数超过一半的数字 {
    public static void main(String[] args) {
        int[] a = {2, 2, 2, 2,2, 4, 4, 4, 4};
        System.out.println(majorityElement2(a));

    }
    static
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        return nums[nums.length/2];

    }
    static
    public int majorityElement2(int[] nums){    //使用摩尔投票法
        int x=0, votes=0;
        for (int i = 0; i < nums.length; i++) {
            if(votes==0){
                x = nums[i];
            }
            if(x==nums[i])  votes++;
            else votes--;
        }
        return x;
    }

}
