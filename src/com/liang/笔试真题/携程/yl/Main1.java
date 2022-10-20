package com.liang.笔试真题.携程.yl;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            String a = sc.next();
            String b = sc.next();
            if (a.length() != b.length()) {
                System.out.println("No");
            } else {
                int[] indexes = new int[2];
                int num = 0;
                boolean flag0 = false;
                for (int j = 0; j < a.length(); j++) {
                    if (a.charAt(j)!=b.charAt(j)){
                        if (num==2){
                            System.out.println("No");
                            flag0 = true;
                            break;
                        }
                        indexes[num++] = j;
                    }
                }
                if (flag0)  continue;
                if (num==2 && a.charAt(indexes[0])==b.charAt(indexes[1]) &&
                        a.charAt(indexes[1])==b.charAt(indexes[0])){
                    System.out.println("Yes");
                } else if(num==0) {
                    int[] sum = new int[128];
                    boolean flag = false;
                    for (int j = 0; j < a.length(); j++) {
                        sum[a.charAt(j)]++;
                        if (sum[a.charAt(j)]>1){
                            flag = true;
                        }
                    }
                    if (flag) System.out.println("Yes");
                    else System.out.println("No");
                } else {
                    System.out.println("No");
                }
            }
        }
    }
}
