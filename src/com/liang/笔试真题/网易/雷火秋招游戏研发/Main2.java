package com.liang.笔试真题.网易.雷火秋招游戏研发;

import java.util.*;

public class Main2 {
    static HashMap<Integer, ArrayList<Integer>> map;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int t = sc.nextInt();
            map.put(i, new ArrayList<>());
            ArrayList<Integer> list = map.get(i);
            for (int j = 0; j < t; j++) {
                list.add(sc.nextInt());
            }
        }
        int max = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < m; i++) {
            if (sc.nextInt()==1){
                set.add(sc.nextInt());
            } else {
                set.remove(sc.nextInt());
            }
            HashSet<Integer> tempSet = new HashSet<>();
            for (Integer integer : set) {
                dfs(tempSet, integer);
            }
//            System.out.println(tempSet.size());
            max = Math.max(max, tempSet.size());
        }
        System.out.println(max);
    }
    public static void dfs(HashSet<Integer> tempSet, int num){
        ArrayList<Integer> list = map.get(num);
        tempSet.add(num);
        for (int i = 0; i < list.size(); i++) {
            int t = list.get(i);
            if (!tempSet.contains(t)) {
                tempSet.add(t);
                dfs(tempSet, t);
            }
        }
    }
}
