package com.liang.剑指OfferII.字符串;

public class M020回文子字符串的个数 {
    public int countSubstrings(String s) {
        int rs = 0;
        for (int i = 0; i < s.length(); i++) {
            rs+=lengthOfString(s, i, i);
            rs+=lengthOfString(s, i, i+1);
        }
        return rs;
    }
    public int lengthOfString(String s, int l, int r){
        int length = 0;
        int rs = 0;
        while (l>=0 && r<s.length()){
            if (s.charAt(l)==s.charAt(r)){
               rs+=1;
            } else {
                break;
            }
            l--;
            r++;
        }
        return rs;
    }
}
