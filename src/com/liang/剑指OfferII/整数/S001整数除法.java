package com.liang.剑指OfferII.整数;

public class S001整数除法 {
    public static void main(String[] args) {
        System.out.println(divide(-2147483648, 2));
    }

    static
    public int divide(int a, int b) {
        int res = 0;
        if (a==Integer.MIN_VALUE) {
            if (b==-1)  return Integer.MAX_VALUE;
            else if(b==1)   return Integer.MIN_VALUE;
            else if(b==Integer.MIN_VALUE)   return 1;
            else{
                a+=Math.abs(b);
                res +=1;
            }
        }
        System.out.println(a);
        if(b==Integer.MIN_VALUE) return 0;
        if(a==0)    return 0;

        boolean sign = (a < 0) == (b < 0);
        a = Math.abs(a);
        b = Math.abs(b);
        String bStr = Integer.toBinaryString(b);
        int index = bStr.indexOf("1");
        int bitNow = 31-(bStr.length()-index);
        System.out.println(bitNow);
        while(bitNow>=0){
//            System.out.println(Integer.toBinaryString(b<<bitNow));
            if (b<<bitNow <a){
                a -= b<<bitNow;
                res += 1<<bitNow;
            }
            bitNow--;
        }
        return sign?res:-res;
    }
}
