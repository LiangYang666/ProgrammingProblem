package com.liang.笔试真题.tx;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @Description: TODO
 * @Author: LiangYang
 * @Date: 2022/4/24 下午8:10
 **/
public class Main2 {
    public static void main(String[] args) {
        System.out.println(new Main2().getNumber(new int[]{1, 2, 3,4}));
    }


    static HashSet<Integer> sets = new HashSet<>();
    void getZhi(int num){
        for (int i = 2; i < num; i++) {
            boolean flag = true;
            for (int j = 2; j < i; j++) {
                if (i%j==0){
                    flag=false;
                    break;
                }
            }
            if (flag)   sets.add(i);
        }
    }

    int getNumber(int[] a){
        boolean[] notValid = new boolean[a.length];
        getZhi(a.length);
        int count=0;
        while (count<a.length-1){
            int n = 0;
            for (int i = 0; i < a.length; i++) {
                if (!notValid[i]){
                    n++;
                    if(!sets.contains(n) || n==1){
                        notValid[i]=true;
                        count++;
                    }
                }
            }
        }
        for (int i = 0; i < a.length; i++) {
            if (!notValid[i])   return a[i];
        }
        return 0;
    }
}
