package com.liang.笔试真题.字节.zhj;

import java.util.Scanner;

public class Main3 {
    static int rs;
    static String s ;
    static String s01;
    static int n;
    static int m;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            rs = 0;
            n = sc.nextInt();
            m = sc.nextInt();
            s = sc.next();
            s01 = sc.next();
            for (char j = 0; j < 26; j++) {
                check((char) ('a'+j));
            }
            System.out.println(rs);
        }
    }
    static void check(char need){
        int have = 0;
        int l = 0;
        int max = 0;
        for (int r = 0; r < n; r++) {
            if (s.charAt(r)==need){
                max++;
            } else if (s01.charAt(r)=='1'){
                if (have<m){
                    max++;
                    have++;
                } else {
                    rs = Math.max(rs, max);
                    while (l<r && s.charAt(l)==need){
                        l++;
                        max--;
                    }
                    l++;
                }
            } else {
                rs = Math.max(rs, max);
                max = 0;
                have = 0;
                l = r+1;
            }
        }
    }
}
