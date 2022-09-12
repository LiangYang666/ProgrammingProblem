package com.liang.面试常考算法题.codeTop;

public class T19最长回文子串 {
    public String longestPalindrome(String s) {
        int[] loc = new int[2];
        int n = s.length();
        int[] tempLoc = new int[2];
        for (int i = 1; i < n; i++) {
            func(s, i, i, tempLoc);
            if (tempLoc[1]-tempLoc[0]>loc[1]-loc[0]){
                loc[1] = tempLoc[1];
                loc[0] = tempLoc[0];
            }
            func(s, i-1, i, tempLoc);
            if (tempLoc[1]-tempLoc[0]>loc[1]-loc[0]){
                loc[1] = tempLoc[1];
                loc[0] = tempLoc[0];
            }
        }
        return s.substring(loc[0], loc[1]+1);

    }
    public void func(String s, int l, int r, int[] locTemp){
        locTemp[0] = 0;
        locTemp[1] = 0;
        while (l>=0 && r<s.length()){
            if (s.charAt(l)==s.charAt(r)){
                locTemp[0] = l--;
                locTemp[1] = r++;
            } else {
                break;
            }
        }
    }

}
