package com.liang.offer;

public class MOffer16数值的整数次方_快速幂 {
    static
    public double myPow(double x, int n) {
        double rs=1.0;
        long l =(long)n;
        if(l==0)    return rs;
        rs = 1;
        if(n<0) {
            x = 1/x;
            l = -l;
        }
//        rs = dp(x, n);
        rs = fastPower(x, l);
        return rs;
    }
    static double fastPower(double x, long n){
        double res = 1;
        while (n>0){
            if((n&1)==1){
                res *= x;
            }
            x *= x;
            n>>=1;
        }
        return res;
    }
    static double dp(double x, int n){
        long i=1;
        double rs=x;
        while(true){
            i = i+i;
            if(i>n) break;
            rs = rs*rs;
        }
        i/=2;
        if(i==n){
            return rs;
        } else {
            return rs*dp(x, n-(int)i);
        }
    }

    public static void main(String[] args) {
        double x=1;
        int n=-5;
        double a = 2e31-1;
        n=(int)a;
        System.out.println(myPow(x, n));
        System.out.println(Math.pow(x, n));
        System.out.println((int)(a));
    }

}
