package com.liang.笔试真题.网易.互联网0327;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main4 {
    static int[][] map;
    static int[][] curMap;

    static int minCnt;
    static int m;
    static int n;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        int[][] fangxiang = {{0,0,1}, {1, -1, 0}};
        map = new int[n][m];
        int[][] rs = new int[n][m];
//        curMap = new int[m][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = in.nextInt();
                rs[i][j] = Integer.MAX_VALUE;
            }
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0]!=o2[0]){
                    return o1[0]-o2[0];
                }
                return o1[1]-o2[1];
            }
        });
        queue.add(new int[]{0,0});
        while (queue.size()!=0){
            int[] temp =  queue.peek();
            queue.poll();
            int time = temp[0];
            int i = temp[1]/m;
            int j = temp[1]%m;
            if(rs[i][j]==Integer.MAX_VALUE) rs[i][j]=time;
            else continue;
            for (int k = 0; k < 3; k++) {
                int newI = i+fangxiang[0][k];
                int newJ = j+fangxiang[1][k];
                if (newI>=0 && newI<n && newJ>=0 && newJ<m && rs[newI][newJ]==Integer.MAX_VALUE){
                    int nTime = map[i][j]==map[newI][newJ]?1:2;
                    queue.add(new int[]{time+nTime, newI*m+newJ});
                }
            }
        }
        System.out.println(rs[n-1][m-1]);

    }
}
