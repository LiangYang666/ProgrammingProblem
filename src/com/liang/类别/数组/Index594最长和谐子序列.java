package com.liang.类别.数组;

import java.util.ArrayList;
import java.util.Arrays;

public class Index594最长和谐子序列 {
    public int findLHS(int[] nums) {
        Arrays.sort(nums);
        ArrayList<Integer> index = new ArrayList<>();
        index.add(0);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i]!=nums[i-1]){
                index.add(i);
            }
        }
        index.add(nums.length);
        int max = 0;
        for (int i = 2; i < index.size(); i++) {
            if(nums[index.get(i-1)]-nums[index.get(i-2)]==1)
                max = Math.max(index.get(i)-index.get(i-2), max);
        }
        return max;
    }
}
