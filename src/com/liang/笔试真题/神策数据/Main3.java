package com.liang.笔试真题.神策数据;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('f', 0);
        map.put('a', 1);
        map.put('i', 2);
        map.put('l', 3);
        map.put('e', 4);
        map.put('d', 5);
        ArrayList<Integer> record = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (!map.containsKey(c)){
                System.out.println(-1);
                return;
            }
            int index = map.get(c);
            boolean hasSet = false;
            for (int j = 0; j < record.size(); j++) {
                if (index==(record.get(j)+1)%6){
                    record.set(j, index);
                    hasSet = true;
                    break;
                }
            }
            if (!hasSet){
                if (index==0){
                    record.add(0);
                } else {
                    System.out.println(-1);
                    return;
                }
            }
        }
        for (Integer integer : record) {
            if (integer != 5) {
                System.out.println(-1);
                return;
            }
        }
        System.out.println(record.size());
    }
}
