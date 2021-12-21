package com.liang.剑指OfferII.字符串;

import java.util.ArrayList;
import java.util.List;

public class M015字符串中的所有变位词 {

    public List<Integer> findAnagrams(String s, String p) {
        int m = s.length();
        int n = p.length();
        ArrayList<Integer> rs = new ArrayList<>();
        if (m<n) return rs;
        int[] cnt = new int[26];
        for (int i = 0; i < n; i++) {
            cnt[s.charAt(i)-'a']++;
            cnt[p.charAt(i)-'a']--;
        }
        int abcNumber = 0;
        for (int i = 0; i < 26; i++) {
            if (cnt[i]!=0)  abcNumber|=(1<<i);
        }
        for (int i = n-1; i < m; i++) {
            if (i!=n-1){
                int last = s.charAt(i-n)-'a';
                int now = s.charAt(i)-'a';
                cnt[last]--;
                if (cnt[last]!=0)  abcNumber|=(1<<last);
                else abcNumber^=(1<<last);
                cnt[now]++;
                if (cnt[now]!=0)  abcNumber|=(1<<now);
                else abcNumber^=(1<<now);
            }
            if (abcNumber==0)   rs.add(i-n+1);
        }
        return rs;
    }
}
