package com.liang.面试知识点.常考算法题.codeTop;

public class M3无重复的最长子串 {
    public int lengthOfLongestSubstring(String s) {
        int l=0;
        int[] sum = new int[256];
        int maxLength = 0;
        for (int r = 0; r < s.length(); r++) {
            sum[s.charAt(r)]++;
            while (sum[s.charAt(r)]>1){
                sum[s.charAt(l)]--;
                l++;
            }
            maxLength = Math.max(maxLength, r-l+1);
        }
        return maxLength;
    }
}
