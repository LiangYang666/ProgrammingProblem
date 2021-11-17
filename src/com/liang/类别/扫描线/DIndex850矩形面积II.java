package com.liang.类别.扫描线;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class DIndex850矩形面积II {
    //太难 暂时放着吧
    public static void main(String[] args) {
        int[][] a = {{1,1,3,3},{3,1,4,2},{3,2,4,4},{1,3,2,4},{2,3,3,4}};
        System.out.println(rectangleArea(a));
    }
    static
    public int rectangleArea(int[][] rectangles) {
        int n = rectangles.length;
        int[][] edge = new int[2 * n][4];
        for (int i = 0; i < n; i++) {
            edge[2*i+0][0] = rectangles[i][0];
            edge[2*i+0][1] = rectangles[i][1];
            edge[2*i+0][2] = rectangles[i][3];
            edge[2*i+0][3] = 0;

            edge[2*i+1][0] = rectangles[i][2];
            edge[2*i+1][1] = rectangles[i][1];
            edge[2*i+1][2] = rectangles[i][3];
            edge[2*i+1][3] = 1;
        }
        Arrays.sort(edge, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                for (int i = 0; i < 4; i++) {
                    if(o1[i]!=o2[i]){
                        return o1[i]-o2[i];
                    }
                }
                return -1;
            }
        });
        ArrayList<int[]> left = new ArrayList<>();
        for (int i = 0; i < 2*n; i++) {
            boolean flag = true;
            for (int j = 0; j < left.size(); j++) {
                int yI1 = Math.max(edge[i][1], left.get(j)[1]);
                int yI2 = Math.min(edge[i][2], left.get(j)[2]);
                if(yI1<yI2){
                    flag = false;

                } else {
                    continue;
                }
            }
            if (flag)
                left.add(edge[i]);
        }
//        System.out.println(Arrays.deepToString(edge));
        return 0;
    }

}
