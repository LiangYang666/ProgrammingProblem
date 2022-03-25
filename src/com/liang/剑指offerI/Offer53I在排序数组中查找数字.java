package com.liang.剑指offerI;

public class Offer53I在排序数组中查找数字 {
    public static void main(String[] args) {

    }
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length-1;
        int total=0;
        while(l<=r){
            int mid = (l+r)/2;
            if(nums[mid]>target){
                r = mid-1;
            } else if(nums[mid]<target){
                l = mid+1;
            } else {
                l = mid;
                while (l<nums.length && nums[l]==target) {
                    l++;
                }
                r =mid;
                while (r>=0 && nums[r]==target)
                    r--;
                return l-r-1;
            }
        }
        return 0;
    }
}
