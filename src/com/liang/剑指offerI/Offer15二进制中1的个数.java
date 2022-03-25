package com.liang.剑指offerI;

public class Offer15二进制中1的个数 {
    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());
        System.out.println(hammingWeight(6576750));
        System.out.println(System.currentTimeMillis());
        System.out.println(hammingWeight1(6576750));
        System.out.println(System.currentTimeMillis());
    }
    static
    public int hammingWeight1(int n) {
        int r=0;
        if(n<0){
            r=1;
            n = n+Integer.MAX_VALUE+1;
        }
        if(n==0) return r;
        while (n>2){
            r+=n%2;
            n/=2;
        }
        r+=1;
        return r;
    }
    static
    public int hammingWeight(int n) {
        int r=0;
        while (n!=0) {
            if((n&1)==1){
                r++;
            }
            n>>>=1;
        }
        return r;
    }
}
