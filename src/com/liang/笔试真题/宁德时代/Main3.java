package com.liang.笔试真题.宁德时代;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        new Main3().MatrixMergeCheck()
    }


    public boolean MatrixMergeCheck (int[][] rects) {
        // write code here
        int n = rects.length;
        HashMap<String, int[]> map = new HashMap<>();
        long area = 0;
        for (int i = 0; i < n; i++) {
            int[] temp = rects[i];
            area+=((long) (temp[2] - temp[0]) *(temp[3]-temp[1]));
            int[] tt = new int[2];
            tt[0] = temp[0];
            tt[1] = temp[1];
            addOrDelete(map, tt);
            tt[1] = temp[3];
            addOrDelete(map, tt);
            tt[0] = temp[2];
            addOrDelete(map, tt);
            tt[1] = temp[1];
            addOrDelete(map, tt);
        }
        if (map.size()!=4)  return false;
        int minX = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxY = Integer.MIN_VALUE;
        for (String s : map.keySet()) {
            int[] xy = map.get(s);
            System.out.println(Arrays.toString(xy));
            minX = Math.min(minX, xy[0]);
            maxX = Math.max(maxX, xy[0]);
            minY = Math.min(minY, xy[1]);
            maxY = Math.max(maxY, xy[1]);
        }
        System.out.println(area);
        long areaTest = (long) (maxY - minY) *(maxX-minX);
        System.out.println(areaTest);
        return area== areaTest;
    }
    public void addOrDelete(HashMap<String, int[]> map, int[] tt){
        String t = Arrays.toString(tt);
        if (map.containsKey(t))    map.remove(t);
        else map.put(t, Arrays.copyOf(tt, 2));
    }
}
