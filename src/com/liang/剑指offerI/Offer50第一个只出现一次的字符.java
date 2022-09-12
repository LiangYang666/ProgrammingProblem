package com.liang.剑指offerI;

import java.util.*;

public class Offer50第一个只出现一次的字符 {

    public static void main(String[] args) {
        System.out.println(firstUniqChar("gabaccdeff"));
    }

    static
    public char firstUniqChar(String s) {
        HashMap<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.get(c)==null?1: map.get(c)+1);
        }
//        System.out.println(map.keySet());
        for (Character key : map.keySet()) {
            if(map.get(key)==1){
                return key;
            }
        }
        return ' ';
    }
}
