package com.liang.剑指OfferII.整数;

public class S001整数除法 {
    public static void main(String[] args) {
        System.out.println(divide(-2147483648, 2));
    }
    static
    public int divide(int a, int b){
        int r=0;
        boolean sign = a > 0 == b > 0;
        if(b==1)    return a;
        if(a==Integer.MIN_VALUE){
            if (b==Integer.MIN_VALUE)   return 1;
            else if (b==-1) return Integer.MAX_VALUE;
            else {
                a+=Math.abs(b);
                r+=1;
            }
        }
        if (b==Integer.MIN_VALUE)   return 0;
        if (a==0)   return 0;
        a = Math.abs(a);
        b = Math.abs(b);
        int bitNow = Integer.toBinaryString(a).length()-Integer.toBinaryString(b).length();
        while (bitNow>=0){
            if(a>= (b<<bitNow)){
                a-=b<<bitNow;
                r+=1<<bitNow;
            }
            bitNow--;

        }
        return sign?r:-r;
    }

}
