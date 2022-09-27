package com.liang.笔试真题.小米;

import java.util.*;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<int[]> arr = new ArrayList<>();
        while (sc.hasNextLong()){
            int[] ints = new int[2];
            ints[0] = sc.nextInt();
            ints[1] = sc.nextInt();
            arr.add(ints);
        }
        arr.sort((o1, o2) -> {
            if (o1[0]==o2[0]){
                return o1[1]-o1[0];
            }
            return o1[0]-o2[0];
        });
        int l = 0;
        int r = 0;
        int rs = 0;
        for (int i = 0; i < arr.size(); i++) {
            int[] now = arr.get(i);
            if (now[0]<=r){
                r = Math.max(r, now[1]);
            } else {
                rs+=(r-l);
                l = now[0];
                r = now[1];
            }
        }
        rs += (r-l);
        System.out.println(rs);
    }
}
