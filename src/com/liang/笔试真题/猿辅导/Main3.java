package com.liang.笔试真题.猿辅导;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main3 {
    static int totalMax = Integer.MIN_VALUE-1;
    static HashMap<Integer, ArrayList<int[]>> record = new HashMap<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
//        int[][] ways = new int[m][4];
        for (int i = 0; i < m; i++) {
            int from = sc.nextInt();
            if (!record.containsKey(from)){
                record.put(from, new ArrayList<>());
            }
            int[] temp = new int[3];
            for (int j = 0; j < 3; j++) {
                temp[j] = sc.nextInt();
//                ways[i][j] = sc.nextInt();
            }
            record.get(from).add(temp);
        }
        boolean canOk = false;
        for (Integer integer : record.keySet()) {
            if (record.get(integer).size()>1){
                canOk = true;
            }
        }
        if (!canOk) System.out.println(-1);
        else {
            for (Integer integer : record.keySet()) {
                dfs(integer, 0, Integer.MAX_VALUE, new boolean[n+1]);
            }
        }
        System.out.println(totalMax<0?-totalMax:0);

    }
    public static void dfs(int want, int have, int minQian, boolean[] visit){
        if (visit[want]){
            totalMax = Math.max(totalMax, minQian);
            return;
        } else {visit[want]=true;}
        ArrayList<int[]> ways = record.get(want);
        for (int[] way : ways) {
            minQian = Math.min(minQian, have-way[1]);
            dfs(way[0], have-way[1]+way[2], minQian, visit);
        }
        visit[want]=false;
    }
}

/*
5 5
4 2 4 0
3 2 3 0
2 4 1 1
4 3 3 1
5 3 0 2
 */
