package com.liang.面试常考算法题.codeTop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class T38合并区间 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0]!=o2[0]){
                    return o1[0]-o2[0];
                }else {
                    return o1[1]-o2[1];
                }
            }
        });
        int[] last = intervals[0];
        ArrayList<int[]> rs = new ArrayList<>();
        for (int i = 1; i < intervals.length; i++) {
            if (last[1]< intervals[i][0]){
                rs.add(last);
                last = intervals[i];
            } else {
                last[1] = Math.max(last[1], intervals[i][1]);
            }
        }
        rs.add(last);
        return rs.toArray(new int[rs.size()][]);
    }
}
