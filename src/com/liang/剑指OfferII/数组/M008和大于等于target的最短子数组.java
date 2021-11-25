package com.liang.剑指OfferII.数组;

public class M008和大于等于target的最短子数组 {
    public int minSubArrayLen1(int target, int[] nums) {    //自己写的滑动窗口 不好
        int l=0;
        int r=1;
        int n = nums.length;
        int total = nums[0];
        int minLength = Integer.MAX_VALUE;
        while (r<=n){
            if(total>=target){
                minLength = Math.min(minLength, (r-l));
                if(minLength==1)    return 1;
                total-=nums[l];
                l++;
            } else {
                r++;
                if(r>n) break;
                total+=nums[r-1];
            }
        }
        return (minLength==Integer.MAX_VALUE)?0:minLength;
    }
    public int minSubArrayLen(int target, int[] nums) {     //滑动窗口
        int n = nums.length;
        int total = 0;
        int l = 0;
        int minLength = Integer.MAX_VALUE;
        for (int r = 0; r < n; r++) {
            total+=nums[r];
            while (total>=target){
                minLength = Math.min(minLength, r-l+1);
                if (minLength==1) return 1;
                total -= nums[l++];
            }
        }
        return (minLength==Integer.MAX_VALUE)?0:minLength;
    }

}
