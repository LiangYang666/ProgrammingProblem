package com.liang.笔试真题.拼多多;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- >0){

            int n = sc.nextInt();
            int v = sc.nextInt();
            int[][] nums = new int[n][3];
            int[] k = new int[n];
            int[] a = new int[n];
            int[] b = new int[n];
            int rs = 0;
            for (int i = 0; i < n; i++) {
                nums[i][2] = sc.nextInt();
                nums[i][0] = sc.nextInt();
                nums[i][1] = sc.nextInt();
//            k[i] = sc.nextInt();
//            a[i] = sc.nextInt();
//            b[i] = sc.nextInt();
            }
            Arrays.sort(nums, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if (o1[0]==o2[0]){
                        if(o1[1]==o2[1]){
                            return o1[2]-o2[2];
                        } else {
                            return o1[1]-o2[1];
                        }
                    } else {
                        return o1[0]-o2[0];
                    }
                }
            });
//        System.out.println(Arrays.deepToString(nums));

            PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if (o1[0]==o2[0]){
                        return o1[1]-o2[1];
                    } else {
                        return o1[0]-o2[0];
                    }
                }
            });
            int now =0;
            for (int i = 0; i <= 3000; i++) {
                while (now<n && nums[now][0]==i){
                    q.add(new int[] {nums[now][1], nums[now][2]});
                    now++;
                }
                while (!q.isEmpty() && q.peek()[0]<i) q.remove();
                int leave = v;
                while (!q.isEmpty() && leave>0){
                    int[] temp = q.peek();
                    q.remove();
                    if (leave<temp[1]){
                        q.add(new int[] {temp[0], temp[1]-leave});
                        rs += leave;
                        leave = 0;
                    }else {
                        rs += temp[1];
                        leave -= temp[1];
                    }
                }

            }
            System.out.println(rs);

        }
    }
}
