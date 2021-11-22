package com.liang.类别.数组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class M剑指OfferII081允许重复选择元素的组合_回溯 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        back(candidates, target, new ArrayList<>(), 0);
        return res;
    }
    public void back(int[] candidates, int target, List<Integer> now, int index){
        ArrayList<Integer> temp = new ArrayList<>(now);
        if(target==0){
            res.add(temp);
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (target-candidates[i]>=0){
                temp.add(candidates[i]);
                back(candidates, target-candidates[i], temp, i);
                temp.remove(temp.size()-1);
            } else
                break;
        }

    }

}
