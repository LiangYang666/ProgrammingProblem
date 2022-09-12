package com.liang.面试常考算法题.codeTop;

import com.liang.utils.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T6三数之和 {
    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        System.out.println(threeSum(nums));
    }

    static
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> rs = new ArrayList<>();
        Arrays.sort(nums);
        if (nums.length<3){
            return rs;
        }
        int lastI = nums[0] - 1;
        for (int i = 0; i < nums.length-2; i++) {
            if (lastI == nums[i])   continue;
            int j = i+1;
            int k = nums.length-1;
            int target = -nums[i];
            while (j<k){
                if (nums[j]+nums[k]==target){
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[k]);
                    rs.add(temp);
                    while (j<k && nums[j]==nums[j+1]){
                        j++;
                    }
                    j++;
                } else if (nums[j] + nums[k] < target) {
                    j++;
                } else {
                    k--;
                }
            }
            lastI = nums[i];
        }
        System.out.println(Arrays.toString(nums));
        return rs;
    }
}
