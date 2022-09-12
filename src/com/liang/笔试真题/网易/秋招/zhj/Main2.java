package com.liang.笔试真题.网易.秋招.zhj;

import java.util.Scanner;

/**
 * @ProjectName: ProgrammingProblem
 * @Package: com.liang.笔试真题.网易.秋招.zhj
 * @ClassName: Main2
 * @Description:
 * @Author: Yang Liang
 * @CreateDate: 2022/8/20 15:43
 * @Version: 1.0
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int maxOdd = 0;
        int maxEven = 0;
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            if ((i%2)==0)   maxEven = Math.max(maxEven, a[i]);
            else maxOdd = Math.max(maxOdd, a[i]);
        }
        long rs = 0;
        for (int i = 0; i < n; i++) {
            if ((i%2)==0){
                rs += maxEven-a[i];
            } else {
                rs += maxOdd-a[i];
            }
        }
        if (maxEven==maxOdd){
            rs+=n/2;
        }
        System.out.println(rs);
    }
}
