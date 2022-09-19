package com.liang.笔试真题.网易.雷火秋招游戏研发;

import java.util.*;

public class Main3 {
    static HashMap<String, Integer> map;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][4];
//        ArrayList<int[]> rs = new ArrayList<>();
        map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 4; j++) {
                arr[i][j] = sc.nextInt();
            }
            addString(arr[i]);
        }
//        for (String s : map.keySet()) {
//            System.out.println(s+":"+map.get(s));
//        }
//        System.out.println("==============================");
        for (int i = 0; i < n-1; i++) {
            int[] a = arr[i];
            for (int j = i+1; j < n; j++) {
                int[] b = arr[j];
                int x0 = Math.max(a[0], b[0]);
                int x1 = Math.min(a[2], b[2]);
                int y0 = Math.max(a[1], b[1]);
                int y1 = Math.min(a[3], b[3]);
//                System.out.println(Arrays.toString(new int[]{x0, y0, x1, y1}));
                if (x0>x1 || y0>y1){
                    continue;
                } else if (x0==x1 && y1==y0){
                    String temp = ""+x0+","+y0;
                    map.put(temp, map.getOrDefault(temp, 0)+1);
                } else if (x1==x0 || y1==y0){
                    continue;
                } else if (x1>x0 && y1>y0){
                    addString(new int[]{x0, y0, x1, y1});
                }
            }
        }
        ArrayList<int[]> rs = new ArrayList<>();
        for (String s : map.keySet()) {
//            System.out.println(s+":"+map.get(s));
            if (map.get(s)%2==1){
                String[] split = s.split(",");
                int[] ints = new int[2];
                ints[0] = Integer.parseInt(split[0]);
                ints[1] = Integer.parseInt(split[1]);
                rs.add(ints);
            }
        }
        rs.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0]==o2[0]){
                    return o1[1]-o2[1];
                }
                return o1[0]-o2[0];
            }
        });
        for (int i = 0; i < rs.size(); i++) {
            System.out.println(rs.get(i)[0]+" "+rs.get(i)[1]);
        }
    }
    public static void addString(int[] xy){
        for (int j = 0; j < 2; j++) {
            int x = xy[j*2];
            for (int k = 0; k < 2; k++) {
                int y = xy[k*2+1];
                String temp = ""+x+","+y;
                map.put(temp, map.getOrDefault(temp, 0)+1);
            }
        }
    }
}
