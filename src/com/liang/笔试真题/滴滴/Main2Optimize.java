package com.liang.笔试真题.滴滴;


import java.util.HashMap;
import java.util.Scanner;

public class Main2Optimize {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int p = sc.nextInt();
        int q = sc.nextInt();
        long[][] shua = new long[n][3];
        long max = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < n; j++) {
                shua[j][i] = sc.nextLong();
                if (i==1){
                    max = Math.max(max,shua[j][i]);
                }
            }
        }
        HashMap<Long, Integer> map1 = new HashMap<>();
        HashMap<Long, Integer> map2 = new HashMap<>();
        for (int i = 0; i < n; i++) {
            long[] temp = shua[i];
            HashMap<Long, Integer> map = map1;
            if (temp[2]==2){
                map = map2;
            }
            map.put(temp[0], map.getOrDefault(temp[0], 0)+1);
            map.put(temp[1]+1, map.getOrDefault(temp[1]+1, 0)-1);
        }
        int last1 = 0;
        int last2 = 0;
        long rs=0;
        for (long i = 0; i < max-1; i++) {
            if (map1.containsKey(i)){
                last1+=map1.get(i);
            }
            if (map2.containsKey(i)){
                last2+=map2.get(i);
            }
            if (last1>=p && last2>=q){
                rs++;
            }
        }
        System.out.println(rs);
    }
}
