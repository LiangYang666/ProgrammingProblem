package com.liang.笔试真题.华为;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int sx = sc.nextInt();
        int sy = sc.nextInt();
        int ex = sc.nextInt();
        int ey = sc.nextInt();
        int num = sc.nextInt();
        int[][] graph = new int[n+100][m+100];
        int[][] count = new int[n+100][m+100];
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[0].length; j++) {
                graph[i][j] = -1;
            }
        }
        int[][] dir = {{0, 1, 0, -1}, {1, 0, -1, 0}};
        while (num-->0){
            int x = sc.nextInt();
            int y = sc.nextInt();
            graph[x][y] = -2;
//            System.out.println(x+" "+y);
        }
        LinkedList<int[]> q = new LinkedList<>();
        q.push(new int[]{sx, sy});
        graph[sx][sy] = 0;
        count[sx][sy] = 1;
        int step=0;
        while (!q.isEmpty()){
            int len = q.size();
            step++;
            while (len-->0){
                int[] temp = q.removeFirst();
                int x = temp[0];
                int y = temp[1];
                for (int i = 0; i < 4; i++) {
                    int nx = x+dir[0][i];
                    int ny = y+dir[1][i];
                    if (nx>=0 && nx<n && ny>=0 && ny<m ){
                        if (graph[nx][ny]==-1){
                            graph[nx][ny] =step;
                            q.addLast(new int[]{nx, ny});
                        }
                        if (graph[x][y]+1==graph[nx][ny]){
                            count[nx][ny]+=count[x][y];
                        }
                    }
                }
            }
        }
        System.out.println(count[ex][ey]+" "+graph[ex][ey]);
    }

}


