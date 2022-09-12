package com.liang.剑指OfferII.哈希表;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class M031最近最少使用缓存 {
}
class LRUCache1 {
    HashMap<Integer, Integer> map;
    HashMap<Integer, Integer> timeKeyMap;
    HashMap<Integer, Integer> keyTimeMap;

    int capacity;
    int begin=0;
    int end=0;
    public LRUCache1(int capacity) {
        map = new HashMap<>();
        keyTimeMap = new HashMap<>();
        timeKeyMap = new HashMap<>();
        this.capacity = capacity;
    }
    public void refresh(int key){
        int time = keyTimeMap.get(key);
        timeKeyMap.remove(time);
        timeKeyMap.put(end, key);
        keyTimeMap.put(key, end);
        end++;
    }

    public int get(int key) {
        if (map.containsKey(key)){
            refresh(key);
            return map.get(key);
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)){
            refresh(key);
            map.put(key, value);
        } else {
            if (map.size()>capacity){
                while (!timeKeyMap.containsKey(begin)){
                    begin++;
                }
                int removeKey = timeKeyMap.get(begin);
                timeKeyMap.remove(begin);
                keyTimeMap.remove(removeKey);
                map.remove(removeKey);
            }
            map.put(key, value);
            timeKeyMap.put(end, key);
            keyTimeMap.put(key, end);
            end++;
        }

    }
}
class LRUCache extends LinkedHashMap<Integer, Integer> {
    private int capacity;

    public LRUCache(int capacity) {
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }
}

