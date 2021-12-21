package com.liang.剑指OfferII.字符串;

import java.util.Arrays;

public class M014字符串的变位词 {

    public boolean checkInclusion(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        if (n<m)    return false;
        int[] s1_abc = new int[26];
        int[] s2_abc = new int[26];
        for (int i = 0; i < m; i++) {
            s1_abc[s1.charAt(i)-'a']++;
            s2_abc[s2.charAt(i)-'a']++;
        }
        for (int i = m-1; i < n; i++) {
            if (i>=m){
                s2_abc[s2.charAt(i-m)-'a']--;
                s2_abc[s2.charAt(i)-'a']++;
            }
            if (Arrays.equals(s1_abc, s2_abc)) return true;
        }
        return false;
    }
}
