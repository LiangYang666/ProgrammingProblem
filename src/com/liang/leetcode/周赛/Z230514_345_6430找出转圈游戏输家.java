package com.liang.leetcode.周赛;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Z230514_345_6430找出转圈游戏输家 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(circularGameLosers(5, 2)));
    }
    static
    public int[] circularGameLosers(int n, int k) {
        HashSet<Integer> has = new HashSet<>();
        int now = 0;
        int i = 0;
        while (!has.contains(now)){
            i++;
            has.add(now);
            now = (now+i*k)%n;

        }
        ArrayList<Integer> rs = new ArrayList<>();
        for (int j = 0; j < n; j++) {
            if (!has.contains(j)){
                rs.add(j+1);
            }
        }
        int[] ints = new int[rs.size()];
        for (int j = 0; j < rs.size(); j++) {
            ints[j] = rs.get(j);
        }
        return ints;
    }
}
