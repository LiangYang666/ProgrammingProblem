package com.liang.笔试真题.boss;


import java.util.ArrayList;
import java.util.Scanner;

public class Main3 {
    static int n;
    static int[] a;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        ArrayList<Integer> array = dfs(0, n - 1);
        System.out.println(array.get(0));
        for (int i = 1; i < array.size(); i++) {
            System.out.print((array.get(i)+1)+" ");
        }
    }
    public static ArrayList<Integer> dfs(int l, int r){
        ArrayList<Integer> temp = new ArrayList<>();
        if (l==r){
            temp.add(a[l]);
            temp.add(l);
            return temp;
        }
        if (l>r){
            temp.add(1);
            return temp;
        }
        int max = 0;
        ArrayList<Integer> Tleft = null;
        ArrayList<Integer> Tright = null;
        int ai = 0;
        for (int i = l; i <= r; i++) {
            ArrayList<Integer> left = dfs(l, i - 1);
            ArrayList<Integer> right = dfs(i + 1, r);
            int tt = left.get(0)*right.get(0)+a[i];
            if (tt>max){
                Tleft = left;
                Tright = right;
                ai = i;
                max = tt;
            }
        }
        temp.add(max);
        temp.add(ai);
        for (int i = 1; i < Tleft.size(); i++) {
            temp.add(Tleft.get(i));
        }
        for (int i = 1; i < Tright.size(); i++) {
            temp.add(Tright.get(i));
        }
        return temp;
    }
}
