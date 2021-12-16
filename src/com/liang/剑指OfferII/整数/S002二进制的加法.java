package com.liang.剑指OfferII.整数;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class S002二进制的加法 {
    public static void main(String[] args) {
        System.out.println(String.copyValueOf(new char[] {'0', '2'}));
    }

    public String addBinary2(String a, String b) {
        int aN = a.length();
        int bN = b.length();
        char[] rs = new char[Math.max(aN, bN)+1];
        int ct = 0;
        for (int i = 0; i < rs.length; i++) {
            int at = 0;
            int bt = 0;
            if(i<aN) at=a.charAt(aN-1-i)-'0';
            if(i<bN) bt = b.charAt(bN-1-i)-'0';
            int rt = (at+bt+ct);
            ct = rt>>1;
            rs[rs.length-1-i] = (char) (((char) (rt&1))+'0');
        }
//        Collections.reverse(rs);
        int i = 0;
        for (i = 0; i < rs.length; i++) {
            if (rs[i]=='1') break;
        }
        if(i==rs.length)    return "0";
        return String.copyValueOf(rs, i, rs.length-i);
    }



    public String addBinary(String a, String b) {
        if (a.equals("0")&& b.equals("0"))  return a;
        String rs= "";
        int n = Math.max(a.length(), b.length());
        int aN = a.length()-1;
        int bN = b.length()-1;
        int bA = 0;
        int bB = 0;
        int bC = 0;
        for (int i = 0; i < n; i++) {
            if (aN>=i)
                bA = ((a.charAt(aN-i)=='1'))?1:0;
            else bA = 0;
            if (bN>=i)
                bB = (b.charAt(bN-i)=='1')?1:0;
            else bB = 0;
            int d = bA+bB+bC;
            rs=(((d&1)==1)?"1":"0")+rs;
            bC = ((d&2)==2)?1:0;
        }
        if(bC==1)   rs = "1"+rs;
        return rs;
    }
}
