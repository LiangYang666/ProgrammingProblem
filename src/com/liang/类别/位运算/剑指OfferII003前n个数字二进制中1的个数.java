package com.liang.类别.位运算;

public class 剑指OfferII003前n个数字二进制中1的个数 {

    public int[] countBits(int n) {
        int[] rs = new int[n + 1];
        int highFlag = 1;
        rs[0] = 0;
        for (int i = 1; i < n + 1; i++) {
            if((i==(highFlag<<1)))   highFlag<<=1;
            rs[i] = rs[i-highFlag]+1;
        }
        return rs;
    }
}
