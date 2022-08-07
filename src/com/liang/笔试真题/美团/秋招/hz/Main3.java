package com.liang.笔试真题.美团.秋招.hz;

import java.util.HashMap;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        int a = 1000000000;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] fore = new int[n];
        int[] back = new int[n];
        for (int i = 0; i < n; i++) {
            fore[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            back[i] = sc.nextInt();
        }
        HashMap<Integer, int[]> record = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (!record.containsKey(fore[i])){
                record.put(fore[i],new int[3]);
            }
            record.get(fore[i])[0] += 1;
            if (!record.containsKey(back[i])){
                record.put(back[i],new int[3]);
            }
            record.get(back[i])[1] += 1;
            if (fore[i]==back[i]){
                record.get(back[i])[2] += 1;
            }
        }
        int min = Integer.MAX_VALUE;
        int thr = (n+1)/2;
        for (int key : record.keySet()) {
            int[] temp = record.get(key);
            int all = temp[0]+temp[1]-temp[2];
            if (all>=thr){
                int bb = Math.max(temp[0], temp[1]);
                min = Math.min(bb<thr?thr-bb:0, min);
            }
        }
        if (min==Integer.MAX_VALUE) min = -1;
        System.out.println(min);
    }
}
