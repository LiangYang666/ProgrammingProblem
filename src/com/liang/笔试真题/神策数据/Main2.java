package com.liang.笔试真题.神策数据;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] inputs = new String[n];
        int[][] timeRecord = new int[n][2];
        for (int i = 0; i < n; i++) {
            inputs[i] = sc.next();
            String tt = inputs[i];
            String[] split = tt.split(":");
            timeRecord[i][0] = Integer.parseInt(split[0])*60*60+Integer.parseInt(split[1])*60+Integer.parseInt(split[2]);
            timeRecord[i][1] = i;
        }
        Arrays.sort(timeRecord, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0]==o2[0]){
                    return o1[1]-o2[1];
                }
                return o1[0]-o2[0];
            }
        });
        System.out.println(Arrays.deepToString(timeRecord));
        int MaxTime = 0;
        int MaxTimeIndex = 0;
        for (int i = 0; i < n-1; i++) {
            int tt = timeRecord[i+1][0]-timeRecord[i][0];
            if (tt>MaxTime){
                MaxTime = tt;
                MaxTimeIndex = timeRecord[i][1];
            }
        }
        int tt = timeRecord[0][0]-timeRecord[n-1][0]+3600*24;
        if (tt>MaxTime){
            MaxTime = tt;
            MaxTimeIndex = timeRecord[n-1][1];
        }
        System.out.println(inputs[MaxTimeIndex]);
    }
}
