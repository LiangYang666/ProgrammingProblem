package com.liang.笔试真题.腾讯音乐;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

    }

    public int minOperations (String str) {
        // write code here
        int[] sum = new int[26];
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            int index = str.charAt(i)-'a';
            sum[index]++;
        }
        int rs = 0;
        while (true){
            boolean flag=true;
            for (int i = 0; i < 26; i++) {
                if (sum[i]>1){
                    flag = false;
                    sum[i]-=2;
                    rs++;
                    int minIndex = i;
                    int min = sum[i];
                    for (int j = 0; j < 26; j++) {
                        if (min>sum[j]){
                            min = sum[j];
                            minIndex=j;
                        }
                    }
                    sum[minIndex]++;
                }
            }
            if (flag)   return rs;
        }
    }
}
