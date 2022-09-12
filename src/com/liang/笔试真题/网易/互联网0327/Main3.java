package com.liang.笔试真题.网易.互联网0327;

import java.util.Arrays;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int jishu=1;
        int oushu=2;
        int cur = n-1;
        int[] rs = new int[n];
        while (cur>=0){
            if(rs[cur]==0){
                if (jishu<=n){
                    rs[cur] = jishu;
                    jishu += 2;
                } else {
                    rs[cur] = oushu;
                    oushu+=2;
                }
            }
            cur--;
        }
//        System.out.println(Arrays.toString(rs));
        for (int i = 0; i < n; i++) {
            System.out.print(rs[i]+" ");
        }
    }
}
