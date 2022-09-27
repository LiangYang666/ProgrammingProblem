package com.liang.笔试真题.A360;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main2 {
    static long rs = Long.MAX_VALUE;
    static HashMap<Integer, ArrayList<int[]>> map;
    static boolean[] has;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[m][3];
        map = new HashMap<>();
        int[] qian = new int[m];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < m; j++) {
                arr[j][i] = sc.nextInt();
                qian[j] = arr[j][i];
            }
        }
        Arrays.sort(qian);
//        long rs = 0;
//        for (int i = 0; i < m-1; i++) {
//            rs+=qian[i];
//        }
//        System.out.println(rs);
//        if (rs>0)   return;
        for (int i = 0; i < m; i++) {
            if (!map.containsKey(arr[i][0]))
                map.put(arr[i][0], new ArrayList<>());
            map.get(arr[i][0]).add(new int[]{arr[i][1], arr[i][2]});

            if (!map.containsKey(arr[i][1]))
                map.put(arr[i][1], new ArrayList<>());
            map.get(arr[i][1]).add(new int[]{arr[i][0], arr[i][2]});

        }
        for (int i = 1; i < n+1; i++) {
            has = new boolean[n+1];
            rs = Math.min(dfs(i, 0), rs);
        }
        System.out.println(rs);

    }
    public static long dfs(int index, long qian){
        if (index>has.length || has[index]) return 0;
        has[index] = true;
        ArrayList<int[]> list = map.get(index);
        long temp = qian;
        for (int i = 0; i < list.size(); i++) {
            temp += dfs(list.get(i)[0], list.get(i)[1]);
        }
        return temp+qian;
    }
}
