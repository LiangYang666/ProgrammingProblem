package com.liang.剑指OfferII.数组;

public class M009乘积小于k的子数组 {
    public static void main(String[] args) {
        int[] nums = {10, 5, 2, 6};
        int k = 8;
        System.out.println(numSubarrayProductLessThanK(nums, k));
    }
    static
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        long product = 1;
        int n = nums.length;
        int total = 0;
        int l =0;
        for (int r = 0; r < n; r++) {
            product *= nums[r];
            while (product>=k && l<=r){
                product /= nums[l];
                l++;
            }
            if(l<=r) {
                total+=r-l+1;
            }
        }
        return total;
    }
}
