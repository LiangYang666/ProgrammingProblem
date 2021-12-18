package com.liang.剑指OfferII.整数;

public class S006排序数组中两个数字之和 {

    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        int l=0, r=n-1;
        while (l<r){
            int now_total = numbers[l]+numbers[r];
            if (now_total==target){
                return new int[]{l, r};
            } else if (now_total<target){
                l++;
            } else {
                r--;
            }
        }
        return new int[0];

    }

    public int[] twoSum2(int[] numbers, int target) {
        for (int i = 0; i < numbers.length-1; i++) {
            int temp = findTarget(numbers, i+1, numbers.length, target-numbers[i]);
            if (temp!=-1)   return new int[] {1,2};
        }
        return new int[0];
    }
    public int findTarget(int[] numbers, int l, int r, int target){

        while(l<=r){
            int m = (l+r)>>2;
            if (numbers[m]==target) return m;
            else if (numbers[m]<target) l=m+1;
            else r=m-1;
        }
        return -1;
    }
}
