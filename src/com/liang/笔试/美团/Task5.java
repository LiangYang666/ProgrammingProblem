package com.liang.笔试.美团;

import java.util.ArrayList;
import java.util.Scanner;

public class Task5 {

    static int[] nums;
    static int whiteTotal;
    static int blackTotal;
    public static int dfs(ArrayList<ArrayList<Integer>> graph, int now){
        int w =0;
        int b =0;
        for (int i = 0; i < graph.get(now).size(); i++) {
            int res = dfs(graph, graph.get(now).get(i));
            if (res==0) w++;
            else b++;
        }
        if(nums[now]==0 &&((w+b)==0  || (b>=1))) whiteTotal++;
        if(nums[now]==1 &&((w+b)==0  || (w==2))) blackTotal++;
        return nums[now];

    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        whiteTotal = 0;
        blackTotal = 0;
        int n = scanner.nextInt();
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<Integer>());
        }
        nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            int t = scanner.nextInt();
            if (t-1 ==-1) continue;
            graph.get(t-1).add(i);
        }
        dfs(graph, 0);
        System.out.println(whiteTotal+" "+ blackTotal);
    }
}
