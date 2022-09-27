package com.liang.笔试真题.A360;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String a = sc.next();
            String b = sc.next();
//            System.out.println(a);
//            System.out.println(b);
            int aN = a.length();
            int bN = b.length();
            int aI = 0;
            boolean flag = true;
            if (aN>bN) {
                System.out.println("NO");
                continue;
            }
            for (int j = 0; j < bN; j++) {
                if (aI<aN && a.charAt(aI) == b.charAt(j)) {
                    aI++;
                    continue;
                } else if (aI>=1 && a.charAt(aI-1)==b.charAt(j)){
                    continue;
                } else {
                    System.out.println("NO");
                    flag = false;
                    break;
                }
            }
            if (flag){
//                System.out.println("YES");
                if (aI==aN) System.out.println("YES");
                else System.out.println("NO");
            }
        }
    }
}
