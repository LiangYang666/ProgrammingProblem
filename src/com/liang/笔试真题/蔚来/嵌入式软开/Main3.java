package com.liang.笔试真题.蔚来.嵌入式软开;

import java.util.Arrays;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int[][] sum = new int[128][2];
        for (int i = 0; i < 128; i++) {
            sum[i][1] = i;
        }
        for (int i = 0; i < s.length(); i++) {
            sum[s.charAt(i)][0]++;
        }
        Arrays.sort(sum, (a,b)->{
            if(a[0]==b[0]){
                return a[1]-b[1];
            }
            return b[0]-a[0];
        });
        for (int i = 0; i < 128; i++) {
            if (sum[i][0]==0){
                break;
            }
            System.out.print((char)(sum[i][1]));
        }
        System.out.println();
    }
}
