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

    public int minSubArrayLen2(int target, int[] nums) {     //前缀和 二分法
        int n = nums.length;
        int minLength = Integer.MAX_VALUE;
        int[] sums = new int[n+1];
        for (int i = 0; i < n; i++) {
            sums[i+1] = sums[i]+nums[i];
        }
        for (int i = 0; i < n+1; i++) {
            int l=i+1;
            int r=n;
            int t=sums[i]+target;
            while (l<=r){
                int m = (l+r)>>1;
                if(sums[m]>=t){
                    minLength = Math.min(minLength, m-i);
                    r = m-1;
                } else{
                    l=m+1;
                }
            }
        }
        return (minLength==Integer.MAX_VALUE)?0:minLength;
    }

    public int minSubArrayLen3(int target, int[] nums){
        int n=nums.length;
        int l = 0;
        int r = 0;
        int min_length = Integer.MAX_VALUE;
        int total_now = nums[0];
        for (l = 0; l < n; l++) {
            while (total_now<target){
                r++;
                if (r==n) return min_length==Integer.MAX_VALUE?0:min_length;
                total_now+=nums[r];
            }
            System.out.println(total_now);
            min_length = Math.min(min_length, r-l+1);
            total_now -= nums[l];
        }
        return min_length==Integer.MAX_VALUE?0:min_length;
    }

}
