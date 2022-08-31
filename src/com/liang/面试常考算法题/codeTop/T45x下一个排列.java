package com.liang.面试常考算法题.codeTop;

import java.util.Arrays;

public class T45x下一个排列 {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int lowerIndex = -1;
        for (int i = n-2; i >=0 ; i--) {// 从右边开始搜索第一个升序
            if (nums[i]<nums[i+1]){
                lowerIndex = i;
                break;
            }
        }
        if (lowerIndex==-1){
            // 是倒序数组 翻转数组
            for (int i = 0; i < n/2; i++) {
                int temp = nums[i];
                nums[i] = nums[n-1-i];
                nums[n-1-i] = temp;
            }
            return;
        }
        for (int i = n-1; i >lowerIndex ; i--) {
            if (nums[i]>nums[lowerIndex]){
                int swap = nums[i];
                nums[i] = nums[lowerIndex];
                nums[lowerIndex] = swap;
                int start  = lowerIndex+1;
                for (int j = start; j < (n - start) / 2 + start; j++) { // 翻转后面的
                    int tt = nums[j];
                    nums[j] = nums[n-1-(j-start)];
                    nums[n-1-(j-start)] = tt;
                }
                return;
            }
        }
    }
}
