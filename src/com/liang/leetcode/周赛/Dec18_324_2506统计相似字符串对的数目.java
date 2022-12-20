package com.liang.leetcode.周赛;

public class Dec18_324_2506统计相似字符串对的数目 {
    public int similarPairs(String[] words) {
        int rs = 0;
        int n = words.length;
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            String str = words[i];
            for (int j = 0; j < str.length(); j++) {
                nums[i] |= (1<<(str.charAt(j)-'a'));
            }
        }
        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j < n; j++) {
                if (nums[i]==nums[j]){
                  rs++;
                }
            }
        }
        return rs;
    }
}
