package com.liang.剑指OfferII.整数;

public class S003前n个数字二进制中1的个数 {

    public int[] countBits(int n) {
        int[] rs = new int[n+1];
        if(n==0)    return rs;
        rs[1] = 1;
        int last = 1;
        for (int i = 2; i < n+1; i++) {
            rs[i] = 1+rs[i-(last+1)];
            if((last+1)*2-1==i) last = i;
        }
        return rs;
    }

}
