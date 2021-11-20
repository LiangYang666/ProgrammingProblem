package com.liang.类别.位运算;

public class MIndex397整数替换 {
    public static void main(String[] args) {
        System.out.println(integerReplacement(8));
    }
    static
    public int integerReplacement(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            System.out.println(Integer.toBinaryString(n));
            if (n==1)   break;
            if((n&3)==3 && n!=3){
                n+=1;
                res+=1;
            } else if((n&1)==1){
                res+=1;
            }
            n>>>=1;
            res+=1;
        }
        return res;
    }
}
