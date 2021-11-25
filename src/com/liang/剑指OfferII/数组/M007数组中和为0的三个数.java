package com.liang.剑指OfferII.数组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class M007数组中和为0的三个数 {
    public List<List<Integer>> threeSum(int[] nums) {   // 三层循环
        ArrayList<List<Integer>> rs = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n-2; i++) {
            if(i!=0 && nums[i]==nums[i-1])  continue;
            if((nums[i]+nums[i+1]+nums[i+2])>0) break;
            else if((nums[i]+nums[n-2]+nums[n-1])<0)    continue;
            for (int j = i+1; j < n-1; j++) {
                if(j!=i+1 && nums[j]==nums[j-1])  continue;
                if((nums[i]+nums[j]+nums[j+1])>0)    break;
                else if((nums[j]+nums[n-1]+nums[i])<0) continue;
                int target = -nums[i]-nums[j];
                int l=j+1;
                int r=n-1;
                while (l<=r){
                    int m = (l+r)/2;
                    if (target==nums[m]){
                        ArrayList<Integer> rsTemp = new ArrayList<>();
                        rsTemp.add(nums[i]);
                        rsTemp.add(nums[j]);
                        rsTemp.add(nums[m]);
                        rs.add(rsTemp);
                        break;
                    } else if (target<nums[m]){
                        r = m-1;
                    } else {
                        l = m+1;
                    }
                }
            }
        }
        return rs;
    }
}
