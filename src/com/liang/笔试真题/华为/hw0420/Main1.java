package com.liang.笔试真题.华为.hw0420;

import java.util.Scanner;

/**
 * @Description: TODO
 * @Author: LiangYang
 * @Date: 2022/4/20 下午7:08
 **/
public class Main1 {
    static int[] chances = {2,2,2,2,2,
            2,2,2,2,2,
            4,4,4,4,4,
            4,4,4,4,4,
            8,8,8,8,8};
    static int n;
    static int rs = 0;

    public static void dfs(int i, int count, int error){
        if (error==3 || i==25){
            if (count==n)   rs++;
            return;
        }
        dfs(i+1, count+chances[i], error);
        dfs(i+1, count, error+1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        dfs(0, 0, 0);
        System.out.println(rs);
    }
}
