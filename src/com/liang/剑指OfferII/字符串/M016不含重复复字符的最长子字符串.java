package com.liang.剑指OfferII.字符串;

public class M016不含重复复字符的最长子字符串 {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int[] abc = new int[256];
        int l = 0;
        int maxLength = 0;
        for (int r = 0; r < n; r++) {
            int now = s.charAt(r);
            abc[now]++;
            while (abc[now]>1){
                abc[s.charAt(l)]--;
                l++;
            }
            maxLength = Math.max(maxLength, r-l+1);
        }
        return maxLength;
    }
}
