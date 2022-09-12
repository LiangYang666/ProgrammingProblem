package com.liang.面试常考算法题.codeTop;

import java.util.ArrayList;
import java.util.List;

public class T22全排列 {
    List<List<Integer>> rs = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        ArrayList<Integer> temp= new ArrayList<>();
        backtrack(nums, new boolean[nums.length], temp);
        return rs;
    }
    public void backtrack(int[] nums, boolean[] flag, ArrayList<Integer> temp){
        if (temp.size()==nums.length){
            ArrayList<Integer> rsT = new ArrayList<>(temp);
            rs.add(rsT);
        }
        for (int i = 0; i < nums.length; i++) {
            if (!flag[i]){
                flag[i] = true;
                temp.add(nums[i]);
                backtrack(nums, flag, temp);
                flag[i] = false;
                temp.remove(temp.size()-1);
            }
        }
    }
}
