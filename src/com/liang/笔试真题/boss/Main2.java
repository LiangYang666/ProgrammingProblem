package com.liang.笔试真题.boss;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int sum = 0;
        if(s.length()==1){
            System.out.println(0);
            return;
        }
        while (true){
            sum++;
            long temp = 1;
            for (int i = 0; i <s.length(); i++) {
                temp*=(s.charAt(i)- '0');
            }
            if (temp<=9){
                System.out.println(sum);
                break;
            } else {
                s = ""+temp;
            }
        }
    }
}
