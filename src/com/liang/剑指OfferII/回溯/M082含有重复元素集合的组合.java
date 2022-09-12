package com.liang.剑指OfferII.回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ProjectName: ProgrammingProblem
 * @Package: com.liang.剑指OfferII.回溯
 * @ClassName: M082含有重复元素集合的组合
 * @Description:
 * @Author: Yang Liang
 * @CreateDate: 2022/9/2 22:24
 * @Version: 1.0
 */
public class M082含有重复元素集合的组合 {
    List<List<Integer>> rs = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(candidates, target, 0, new ArrayList<>());

        return rs;
    }
    public void dfs(int[] c, int target, int index, ArrayList<Integer> list){
        if (target<0)   return;
        if (target==0){
            rs.add(new ArrayList<>(list));
        }
        for (int i = index; i < c.length; i++) {
            if (i>index && c[i]==c[i-1])    continue;
            list.add(c[i]);
            dfs(c, target-c[i], i+1, list);
            list.remove(list.size()-1);
        }
    }
}
