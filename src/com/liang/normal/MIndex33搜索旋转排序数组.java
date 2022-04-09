package com.liang.normal;

public class MIndex33搜索旋转排序数组 {
    public int search(int[] nums, int target){
        int l=0;
        int r= nums.length-1;
        while (l<r){
            int m=(l+r)/2;
            if(nums[l]<nums[m]){    //左边正序
                if(nums[l]<=target && target<=nums[m]){
                    r=m;
                } else {
                    l=m+1;
                }
            } else {    //右边正序
                if(nums[m]<=target && target<=nums[r]){
                    l=m;
                }else {
                    r=m;
                }
            }
        }
        if (nums[l]==target)    return r;
        return -1;
    }

    public int search1(int[] nums, int target) { //非严格二段性
        int l=0;
        int r =nums.length-1;
        while (l<=r){
            int m = (l+r)/2;
            if (nums[m]==target)    return m;

            if (nums[l]<=nums[m]){
                if (target<nums[m] && target>=nums[l]){
                    r = m-1;
                } else{
                    l = m+1;
                }
            } else {
                if(target>nums[m] && target<=nums[r]){
                    l = m+1;
                } else {
                    r = m-1;
                }
            }
        }
        return -1;
    }

}
