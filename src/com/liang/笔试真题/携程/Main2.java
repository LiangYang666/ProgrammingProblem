package com.liang.笔试真题.携程;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

import static com.liang.剑指offerI.MOffer46把数字翻译成字符串.total;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] ai = new int[n];
        for (int i = 0; i < n; i++){
            ai[i] = sc.nextInt();
        }
        sc.nextLine();
        String s = sc.nextLine();
        HashMap<Integer, Integer> redMap = new HashMap<>();
        HashMap<Integer, Integer> blueMap = new HashMap<>();
        for (int i = 0; i <s.length(); i++){
            if (s.charAt(i)=='R'){
                redMap.put(ai[i], 1+redMap.getOrDefault(ai[i], 0));
            } else{
                blueMap.put(ai[i], 1+blueMap.getOrDefault(ai[i], 0));
            }
        }
        Integer[] keys = redMap.keySet().toArray(new Integer[0]);
        long rs = 0;
        for (int i = 0; i < keys.length; i++){
            int k = keys[i];
            if (blueMap.containsKey(k)){
                rs += (long) redMap.get(k) *blueMap.get(k);
            }
        }
        System.out.println(rs);
    }
}
