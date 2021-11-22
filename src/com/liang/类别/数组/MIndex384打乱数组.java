package com.liang.类别.数组;

import java.util.Arrays;
import java.util.Random;

public class MIndex384打乱数组 {
    int[] nums;
    int[] numsRandom;
    public MIndex384打乱数组(int[] nums) {
        this.nums = Arrays.copyOf(nums, nums.length);
        numsRandom = Arrays.copyOf(nums, nums.length);
    }
    public int[] reset() {
        return nums;
    }

    public int[] shuffle() {
        Random random = new Random();
        for (int i = 0; i < nums.length; i++) {
            swap(numsRandom, i, i+random.nextInt(nums.length-i));
        }
        return numsRandom;
    }
    public void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
