package com.liang.笔试真题.牛客阿里4星;

import java.util.Arrays;
import java.util.Scanner;

public class 子集 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        int[] rs = new int[T];
        for (int i = 0; i < T; i++) {
            int n = in.nextInt();
            int[] xs = new int[n];
            int[] ys = new int[n];
            for (int j = 0; j < n; j++) {
                xs[j] = in.nextInt();
            }
            for (int j = 0; j < n; j++) {
                ys[j] = in.nextInt();
            }
            rs[i] = handleEach(xs, ys);
            System.out.println(rs[i]);
        }
//        for (int i = 0; i < T; i++) {
//        }

    }
    public static int handleEach(int[] xs, int[] ys){
        int n = xs.length;
        int[][] all = new int[n][2];
        for (int i = 0; i < n; i++) {
            all[i][0] = xs[i];
            all[i][1] = ys[i];
        }
        Arrays.sort(all, (o1, o2) -> {
            if (o1[0]-o2[0]==0){
                return o1[1]-o2[1];
            } else {
                return o1[0]-o2[0];
            }
        });
        int[][] low = new int[n][];
        low[0] = all[0];
        int last = 0;
        for (int[] temp : all) {
            if (temp[0]<low[last][0] && temp[1]<low[last][1]){
                low[++last] = temp;
            } else{

            }
        }
//        System.out.println(Arrays.deepToString(all));
        return 0;
    }
    int getFirstMin(int[][] low, int last, int[] temp){
        int l=0;
        int r=last;
        while(l<r){
//            if()

        }
        return 0;

    }
}
