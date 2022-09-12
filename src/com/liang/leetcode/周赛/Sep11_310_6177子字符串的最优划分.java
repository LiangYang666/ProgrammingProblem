package com.liang.leetcode.周赛;


import java.util.Arrays;

public class Sep11_310_6177子字符串的最优划分 {

    public int partitionString(String s) {
        int rs = 0;
        boolean[] sum = new boolean[26];
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i)-'a';
            if (sum[index]){
                rs++;
                Arrays.fill(sum, false);
            }
            sum[index]=true;
        }
        return rs+1;
    }

}
