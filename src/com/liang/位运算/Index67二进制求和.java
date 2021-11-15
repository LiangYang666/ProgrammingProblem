package com.liang.位运算;

public class Index67二进制求和 {
    public String addBinary(String a, String b) {
        int length = Math.max(a.length(), b.length());
        String ans = "";
        int fC = 0;
        for (int i = 0; i < length; i++) {
            fC += i<a.length()?a.charAt(a.length()-i-1)-'0':0;
            fC += i<b.length()?b.charAt(b.length()-i-1)-'0':0;
            ans = ((fC%2==1)?"1":"0")+ans;
            fC/=2;
        }
        ans = ((fC%2==1)?"1"+ans:ans);
        return ans;
    }
}
