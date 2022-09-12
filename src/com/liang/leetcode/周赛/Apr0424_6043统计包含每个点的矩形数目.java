package com.liang.leetcode.周赛;

import java.util.Arrays;

/**
 * @Description: TODO
 * @Author: LiangYang
 * @Date: 2022/4/24 下午7:52
 **/
public class Apr0424_6043统计包含每个点的矩形数目 {

    public int[] countRectangles(int[][] rectangles, int[][] points) {
        int[] rs = new int[points.length];

        for (int i = 0; i < points.length; i++) {
            int x = points[i][0], y = points[i][1];
            int count = 0;
            for (int j = 0; j < rectangles.length; j++) {
                if (x<=rectangles[j][0] && y<=rectangles[j][1]) {
                    count++;
                }
            }
            rs[i] = count;
        }
        return rs;
    }

}

class Solution {

    public int[] countRectangles(int[][] rectangles, int[][] points) {
        Integer[] index = new Integer[points.length];
        for (int i = 0; i < points.length; i++) {
            index[i] = i;
        }
        Arrays.sort(rectangles, (o, p) -> p[0] - o[0]);
        Arrays.sort(index, (o, p) -> points[p][0] - points[o][0]);
        int[] result = new int[points.length], count = new int[101];
        for (int i = 0, j = 0; i < points.length; i++) {
            for (; j < rectangles.length && rectangles[j][0] >= points[index[i]][0]; j++) {
                count[rectangles[j][1]]++;
            }
            for (int k = points[index[i]][1]; k <= 100; k++) {
                result[index[i]] += count[k];
            }
        }
        return result;
    }
}

