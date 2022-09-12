package com.liang.剑指OfferII.整数;

import java.util.Arrays;

public class M004只出现一次的数字 {
    public int singleNumber1(int[] nums) {       // 排序 判断
        Arrays.sort(nums);
        int n = nums.length;
        if(n==1)    return nums[0];
        if(nums[n-1]!=nums[n-2])    return nums[n-1];
        for (int i = 0; i < n-1; i+=3) {
            if(nums[i]!=nums[i+1])  return nums[i];
        }
        return 0;
    }
    public int singleNumber(int[] nums) {       // 每个二进制位
        int ans=0;
        for (int i = 0; i < 32; i++) {
            int total=0;
            for (int j = 0; j < nums.length; j++) {
                total += (nums[j]>>i)&1;
            }
            if (total%3!=0){
                ans |= 1<<i;
            }
        }
        return ans;
    }

    //二刷
    //排序
    public int singleNumber2(int[] nums){
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-3; i+=3) {
            if (nums[i]!=nums[i+1]) return nums[i];
        }
        return nums[nums.length-1];
    }
    //二进制
    public int singleNumber3(int[] nums){
        int rs = 0;
        for (int i = 0; i < 32; i++) {
            int tempTotal = 0;
            for (int j = 0; j < nums.length; j++) {
                if((nums[j]>>>i&1)==1){
                    tempTotal+=1;
                }
            }
            if(tempTotal%3!=0){
                rs|=1<<i;
            }
        }
        return rs;
    }

}
