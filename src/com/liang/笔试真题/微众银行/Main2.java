package com.liang.笔试真题.微众银行;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            long a = sc.nextLong();
            long b = sc.nextLong();
//            String sa = Integer.toBinaryString(a);
//            String sb = Integer.toBinaryString(b);
            long aa = Math.max(a, b);
            long bb = Math.min(a,b);
            if (aa%bb!=0){
                System.out.println(-1);
            } else {
                long t = aa/bb;
                if (t==1){
                    System.out.println(0);
                    continue;
                } else if (t%2!=0){
                    System.out.println(-1);
                    continue;
                }
                int rs = 0;
                while (t>1){
                    if (t/8>=1 && t%8==0){
                        t/=8;
                    } else if (t/4>=1 && t%4==0){
                        t/=4;
                    } else if (t/2>=1 && t%2==0){
                        t/=2;
                    } else {
                        System.out.println(-1);
                        break;
                    }
                    rs++;
                    if (t==1){
                        System.out.println(rs);
                        break;
                    }
                }
            }
        }
    }
}
