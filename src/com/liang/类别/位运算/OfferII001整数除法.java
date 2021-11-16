package com.liang.类别.位运算;

public class OfferII001整数除法 {
    public static void main(String[] args) {
        divide(10, -2);
    }
    static
    public int divide(int a, int b) {
        boolean sign  = (a<0)^(b<0);
        if(!sign){
            if(a==Integer.MIN_VALUE && b==-1)    return Integer.MAX_VALUE;
        }
        int all = Math.abs(a);
        b = Math.abs(b);
        int bNow = 31;
        int res = 0;
        for (int i = 31; i >= 0; i--) {
            if(((all>>>i)-b)>=0){
                all -= (b<<i);
                res += 1<<i;
            }
        }
        return sign?-res:res;
    }
}
