package com.liang.笔试真题.网易.互娱;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int N = sc.nextInt();
            int[][] points = new int[N][4];
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < 4; k++) {
                    points[j][k] = sc.nextInt();
                }
            }
            int total = 0;
            for (int j = 0; j < N-1; j++) {
                int x1 = Math.min(points[j][0], points[j][2]);
                int x2 = Math.max(points[j][0], points[j][2]);
                int y1 = Math.min(points[j][1], points[j][3]);
                int y2 = Math.max(points[j][1], points[j][3]);
                for (int k = j+1; k < N; k++) {
                    int x3 = Math.min(points[k][0], points[k][2]);
                    int x4 = Math.max(points[k][0], points[k][2]);
                    int y3 = Math.min(points[k][1], points[k][3]);
                    int y4 = Math.max(points[k][1], points[k][3]);
                    int xm1 = Math.max(x1, x3);
                    int xm2 = Math.min(x2, x4);
                    int ym1 = Math.max(y1, y3);
                    int ym2 = Math.min(y2, y4);
                    int w = xm2-xm1;
                    int h = ym2-ym1;
                    if (w<=0 || h<=0){
                        continue;
                    }
                    int cros = w*h;
                    int area = (y2-y1)*(x2-x1)+(y4-y3)*(x4-x3);
                    total += area-cros;
                }
            }
            System.out.println(total);
        }
    }
}
