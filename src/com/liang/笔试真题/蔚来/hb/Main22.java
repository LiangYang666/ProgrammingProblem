package com.liang.笔试真题.蔚来.hb;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @Description: TODO
 * @Author: LiangYang
 * @Date: 2022/9/21 下午7:48
 **/

/*
5
1
2
3
4
5
 */
public class Main22 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int max = 0;
        HashMap<Integer, Long> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            map.put(arr[i], (long) -1);
            max = Math.max(max, arr[i]);
        }
        long temp = 0;
        for (int i = 1; i <= max; i++) {
            temp += i/getNum(i);
            if (map.containsKey(i)){
                map.put(i, temp);
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.println(map.get(arr[i]));
        }
    }
    public static int getNum(int n){
        int i;
        for (i = 0; i < 32; i++) {
            if ((n>>i &1) ==1){
                break;
            }
        }
        return 1<<i;
    }
}
