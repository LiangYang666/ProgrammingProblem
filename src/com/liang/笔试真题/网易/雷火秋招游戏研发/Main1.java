package com.liang.笔试真题.网易.雷火秋招游戏研发;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
//        System.out.println(new DecimalFormat("#.00").format(1.005));
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long all = 0;
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            String a = s.split(" ")[0];
            String b = s.split(" ")[1];
            all+= getAcc(a, b);
        }
        double rs = all*10.0/n;
//        String s = new DecimalFormat("#.00").format(all / n * 100.0+0.005);
        System.out.printf("%.2f", rs);
        System.out.println("%");
    }
    public static int getAcc(String a, String b){
        int aN = a.length();
        int bN = b.length();
        int fen = 0;
        if (a.charAt(0) == b.charAt(0)) {
            fen+=2;
        }
        boolean flag = true;
        if (aN==bN){
            for (int i = 1; i < aN-5; i++) {
                if (a.charAt(i)!=b.charAt(i)){
                    flag = false;
                    break;
                }
            }
            if (flag){
                fen += 3;
            }
        }
        String aNums = a.substring(aN-5);
        String bNums = b.substring(bN-5);
//        System.out.println(aNums);
//        System.out.println(bNums);
        int lenMax = 0;
        for (int i = 0; i < 9; i++) {
            int offset = 4-i;
            int lenTemp = 0;
            for (int j = 0; j < 5; j++) {
                int jT = offset+j;
                if (jT<0 || jT>=5 ){
                    continue;
                }
                if (aNums.charAt(j)==bNums.charAt(jT)){
                    lenTemp++;
                } else {
                    lenMax = Math.max(lenTemp, lenMax);
                    lenTemp = 0;
                }
            }
            lenMax = Math.max(lenTemp, lenMax);
        }
        fen += lenMax;
//        System.out.println(fen/10.0);
        return fen;
    }
}
