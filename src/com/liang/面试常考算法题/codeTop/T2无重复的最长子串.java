package com.liang.面试常考算法题.codeTop;

public class T2无重复的最长子串 {
    public int lengthOfLongestSubstring(String s) {
        int n =  s.length();
        int r = 0, l=0;
        int maxL = 0;
        int[] cac = new int[255];
        for (l = 0; l < n; l++) {
            cac[s.charAt(l)]++;
            while (cac[s.charAt(l)]>1){
                cac[s.charAt(r)]--;
                r++;
            }
            maxL = Math.max(maxL, l-r+1);
        }
        return maxL;
    }
}
