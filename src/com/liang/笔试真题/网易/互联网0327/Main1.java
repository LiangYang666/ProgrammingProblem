package com.liang.笔试真题.网易.互联网0327;

import java.util.Scanner;

public class Main1 {
    static int allCount;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        int x = in.nextInt();
        int y = in.nextInt();
        allCount = Integer.MAX_VALUE;
        dfs(a, b, x, y,0);
        System.out.println(allCount);
    }
    public static void dfs(int a, int b,int x, int y,  int count){
        if(a<=0 && b<=0){
            allCount = Math.min(count, allCount);
            return;
        }
        dfs(a-y, b-y, x, y, count+1);
        if(a>0 && b>0){
            dfs(a-x, b-x, x, y, count+2);
        } else {
            if(a>0){
                dfs(a-x, b, x, y, count+1);
            } else {
                dfs(a, b-x, x, y, count+1);
            }
        }
    }
}
