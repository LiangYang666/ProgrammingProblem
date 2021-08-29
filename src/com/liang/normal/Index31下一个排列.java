package com.liang.normal;

import java.util.Arrays;

public class Index31下一个排列 {
    public static void main(String[] args) {
        int[] a = {2, 3,1 };
        nextPermutation(a);
        System.out.println(Arrays.toString(a));
    }
    static
    public void nextPermutation(int[] nums) {
        int end = nums.length-1;
        if(nums.length<=1)  return;
        int i=0,j=0;
        boolean flag=false;
        for (i = end; i > 0; i--) {
            if(nums[i-1]<nums[i]){
                flag = true;
                i = i-1;
                j = i+1;
                break;
            }
        }
        if(flag){
            for (int k = end; k >= j ; k--) {
                if(nums[k]>nums[i]){
                    int temp = nums[k];
                    nums[k] = nums[i];
                    nums[i] = temp;
                    System.out.println(Arrays.toString(nums));
                    break;
                }
            }
        } else {
            j = 0;
        }
        for (int k = j; k <= (end+j)/2; k++) {
            int temp = nums[k];
            nums[k] = nums[end-(k-j)];
            nums[end-(k-j)] = temp;
        }
    }
}
