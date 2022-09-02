package com.liang.笔试真题.深信服;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);

        Main2 main2 = new Main2();
        System.out.println(main2.nucleicAcidTestWay(5));


    }
    int rs=0;
    public int nucleicAcidTestWay (int n) {
        // write code here
        dfs(0,5);
        return rs;

    }
    public void dfs(int last, int n){
        if (last==n || last==n-1) {
            rs++;
            return;
        }
        dfs(last + 1,n);
        dfs(last+2,n);
    }
}
