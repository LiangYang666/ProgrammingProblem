package com.liang.笔试真题.网易.秋招.雷火;


import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int total = 0;

        for (int i = 0; i < n; i++) {   // 右边
            for (int j = 0; j < getWeiSHu(i); j++) {
                
            }
        }
        System.out.println(total);
        System.out.println(getWeiSHu(0));
    }
    static
    public int getWeiSHu(int x){
        if (x==0) return 1;
        int rs=0;
        while (x>0){
            rs++;
            x /= 10;
        }
        return rs;
    }
}
