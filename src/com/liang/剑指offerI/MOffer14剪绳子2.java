package com.liang.剑指offerI;

public class MOffer14剪绳子2 {
    public static void main(String[] args) {
        System.out.println(cuttingRope(100));
    }

    static
    public int cuttingRope(int n) {
        switch (n){
            case 2:return 1;
            case 3:return 2;
            default:{
                int res=1;
                while (n>4){
                    res = (int)((long)res*3%1000000007);
                    n -= 3;
                }
                return (int)((long)res*n%1000000007);
                }
            }
    }
}
