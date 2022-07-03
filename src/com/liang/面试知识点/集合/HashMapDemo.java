package com.liang.面试知识点.集合;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class HashMapDemo {
    public static void main(String[] args) {
        Integer a = 1;
        Integer b = 2;
        System.out.println(a=b);
        HashMap<Object, Object> map = new HashMap<>();
        map.put(1,2);
        map.size();
        ConcurrentHashMap<Object, Object> cMap = new ConcurrentHashMap<>();
        cMap.put(2,1);
        cMap.put(2,2);
        cMap.size();
    }

}
