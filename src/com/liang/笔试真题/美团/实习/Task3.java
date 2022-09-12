package com.liang.笔试真题.美团.实习;

import java.util.ArrayList;
import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int rs =0;

        int[][] record = new int[n][2];
        ArrayList<int[]> records = new ArrayList<>();
        for (int i=0;i<n;i++){
            int[] temp = new int[2];
            temp[0] = scanner.nextInt();
            temp[1] = scanner.nextInt();
            if(temp[0]>=1 && temp[0]<=m && temp[1]>=1 && temp[1]<=m){
                records.add(temp);
            }
//            record[i][0] = scanner.nextInt();
//            record[i][1] = scanner.nextInt();
        }
        n = records.size();
        for (int i = (1<<n)-1; i >= 0; i--) {
            int sum = 0;
            long choice = 0;
            boolean flag=true;
            for (int j = 0; j < n; j++) {
                if (((i>>j)&1)==0) continue;
                if ((choice&((1<<records.get(j)[0])|(1<<records.get(j)[1])))==0){
                    choice |= (1<<records.get(j)[0]) | (1<<records.get(j)[1]);
                    sum++;
                } else {
                    flag =false;
                    break;
                }
            }
            if (flag) rs=Math.max(rs, sum);
//            if (rs>n) break;
        }
        System.out.println(rs);
    }
}
