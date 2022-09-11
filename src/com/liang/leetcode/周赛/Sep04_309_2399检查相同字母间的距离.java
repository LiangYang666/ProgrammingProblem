package com.liang.leetcode.周赛;

import java.util.Arrays;

public class Sep04_309_2399检查相同字母间的距离 {

    public boolean checkDistances(String s, int[] distance) {
        int[] start = new int[26];  //
        // 数组填充-1
        Arrays.fill(start, -1);
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i)-'a';
            if (start[index]==-1){
                start[index] = i;
            } else {
                if (distance[index]!=(i-start[index]-1)){
                    return false;
                }
            }
        }
        return true;
    }
}
