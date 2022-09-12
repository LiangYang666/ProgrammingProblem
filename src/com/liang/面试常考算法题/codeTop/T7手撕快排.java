package com.liang.面试常考算法题.codeTop;

public class T7手撕快排 {
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length-1);
        return nums;
    }
    public void quickSort(int[] nums, int low, int high){
        if (low>=high) return;
        int i = low;
        int j = high;
        int temp = nums[low];
        while (i < j) {
            while (temp <= nums[j] && i < j) {
                j--;
            }
            while (temp >= nums[i] && i < j) {
                i++;
            }
            if (i < j) {
                int swap = nums[i];
                nums[i] = nums[j];
                nums[j] = swap;
            }
        }
        nums[low] = nums[i];
        nums[i] = temp;
        quickSort(nums, low, i-1);
        quickSort(nums, i+1, high);
    }
}
