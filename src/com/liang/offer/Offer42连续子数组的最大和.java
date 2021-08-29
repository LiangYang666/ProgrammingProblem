package com.liang.offer;

public class Offer42连续子数组的最大和 {
    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-3,-2,-5}));

    }
    static
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            temp = temp+nums[i];
            if(temp>max){
                max = temp;
            }
            temp = Math.max(temp, 0);

        }
        return max;
    }
}
