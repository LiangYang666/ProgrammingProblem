package com.liang.笔试真题.拼多多.秋招;

import com.liang.笔试真题.牛客阿里4星.小强爱数学;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main1 {
    static int n ;
    static int m ;
    static int[] a;
    static int rsJie;
    static int rsFen;
    static HashMap<Integer, ArrayList<Integer>> map;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        a = new int[n+1];
        for (int i = 1; i <=n; i++) {
            a[i] = sc.nextInt();
        }
        rsFen = 0;
        rsJie = 0;
        map = new HashMap<>();
        for (int i = 0; i < n-1; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            if (!map.containsKey(x)){
                map.put(x, new ArrayList<>());
            }
            map.get(x).add(y);
            if (!map.containsKey(y)){
                map.put(y, new ArrayList<>());
            }
            map.get(y).add(x);
        }
        boolean[] visit = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            if (m>=a[i]){
                dfs(i, m, 0, new boolean[n + 1]);
            }
        }
        System.out.println(rsJie+" "+rsFen);
    }
    public static void dfs(int x,int fenSheng, int jieNum, boolean[] visit){
        if (visit[x] || (fenSheng-a[x])<0){
            if (jieNum>rsJie){
                rsJie = jieNum;
                rsFen = m-fenSheng;
            } else if (jieNum==rsJie){
                rsFen = Math.min(rsFen, m-fenSheng);
            }
            return;
        }
        visit[x] = true;
        fenSheng-=a[x];
        jieNum++;
        ArrayList<Integer> list = map.get(x);
        for (int i = 0; i < list.size(); i++) {
            dfs(list.get(i), fenSheng, jieNum, visit);
        }
        visit[x] = false;
    }
}
