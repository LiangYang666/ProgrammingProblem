package com.liang.笔试真题.美团.实习;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean[] rs = new boolean[n];
        for (int i = 0; i < n; i++) {
            int temp = sc.nextInt();
            if (temp%11==0){
                rs[i] = true;
            } else {
                int flag = 0;
                String s = Integer.toString(temp);
                for (int j = 0; j < s.length(); j++) {
                    if (s.charAt(j)=='1'){
                        flag++;
                    }

                }
                rs[i] = flag >= 2;
            }

        }
        for (int i = 0; i < n; i++) {
            System.out.println(rs[i]?"yes":"no");
        }
    }
}
