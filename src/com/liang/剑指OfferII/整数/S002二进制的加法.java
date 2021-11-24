package com.liang.剑指OfferII.整数;

public class S002二进制的加法 {
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
