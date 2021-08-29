package com.liang.offer;

import java.util.Arrays;

public class Offer21奇偶分组 {
    public static void main(String[] args) {
        int[] nums = {2,2,2,2,2,2,3,3,3,1,2,3};
        System.out.println(Arrays.toString(exchange(nums)));

    }
    static
    public int[] exchange(int[] nums) {
        int i=0,j=nums.length-1;
        while (i<j){
            while (i<j && nums[i]%2==1){
                i++;
            }
            while (i<j && nums[j]%2==0){
                j--;
            }
            if(i<j){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        return nums;
    }
}
