package com.liang.笔试真题.蚂蚁;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int[] temp = new int[26];
        temp[0] = 1;
        for (int i = 1; i < 26; i++) {
            temp[i] = temp[i-1]*2;
        }
        int[] rsRecord = new int[26];
        while (x>0){
            for (int i = 25; i >= 0; i--) {
                if (x>=temp[i]){
                    rsRecord[i]++;
                    x-=temp[i];
                    break;
                }
            }
        }
        StringBuilder rs = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < rsRecord[i]; j++) {
               rs.append((char) ('a' + i));
            }
        }
        System.out.println(rs.toString());
    }
}
