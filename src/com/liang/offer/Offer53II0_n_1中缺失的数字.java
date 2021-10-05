package com.liang.offer;

public class Offer53II0_n_1中缺失的数字 {
    public int missingNumber(int[] nums) {
        int l = 0;
        int r = nums.length-1;

        while (l<r){
            int m = (l+r)/2;
            if(nums[m] ==m){
                l = m+1;
            } else {
                r = m;
            }
        }
        if(r==nums[r])  return r+1;
        return r;
    }
}
