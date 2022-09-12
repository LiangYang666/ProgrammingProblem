package com.liang.剑指OfferII.字符串;

public class D017含有所有字符的最短字符串 {
    public static void main(String[] args) {
//        System.out.println((int)('z'-'A'));
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));

    }
    static
    public String minWindow(String s, String t) {
        int[] cnt = new int[58];
        int minLength = Integer.MAX_VALUE;
        String rs = "";
        if (s.length()<t.length())  return "";
        for (int i = 0; i < t.length(); i++) {
            cnt[t.charAt(i)-'A']--;
            cnt[s.charAt(i)-'A']++;
        }
        if (checkOk(cnt))   return s.substring(0, t.length());
        int l=0;
        for (int r = t.length(); r < s.length(); r++) {
            boolean tempFlag = false;
            cnt[s.charAt(r)-'A']++;
            if (cnt[s.charAt(r)-'A']==0) tempFlag=true;
            while (cnt[s.charAt(l)-'A']>=1 && l<r) {
                cnt[s.charAt(l++)-'A']--;
            }
            if (tempFlag) {
                if (checkOk(cnt)) {
                    if (minLength>(r-l+1)){
                        minLength = r-l+1;
                        rs = s.substring(l, r+1);
                    }
                    cnt[s.charAt(l++)-'A']--;
                }
            }
        }
        return rs;
    }
    static
    public boolean checkOk(int[] cnt){
        for (int i = 0; i < cnt.length; i++) {
            if (cnt[i]<0)   return false;
        }
        return true;
    }
}
