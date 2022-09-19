package com.liang.笔试真题.蚂蚁;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;


/*

5
1 2
1 3
2 4
4 5

5
1 2
1 3
2 4
3 5
 */
public class Main2 {
    static HashMap<Integer, ArrayList<Integer>> map = null;
    static int rs=0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        map = new HashMap<>();
        rs = 0;
        for (int i = 0; i < n-1; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            if (!map.containsKey(a)){
                map.put(a, new ArrayList<>());
                map.get(a).add(1);
            }
            if (!map.containsKey(b)){
                map.put(b, new ArrayList<>());
                map.get(b).add(1);
            }
            map.get(a).add(b);
        }
        dfs(1);
        System.out.println(rs);

    }
    static void dfs(int index){
        int add = index-map.get(index).get(0);
        if (add>0){
            rs += add;
            addSons(index, add);
        }
        ArrayList<Integer> list = map.get(index);
        for (int i = 1; i < list.size(); i++) {
            dfs(list.get(i));
        }
    }
    static void addSons(int index, int add){
        ArrayList<Integer> list = map.get(index);
        list.set(0, list.get(0)+add);
        for (int i = 1; i < list.size(); i++) {
            addSons(list.get(i), add);
        }
    }
}
