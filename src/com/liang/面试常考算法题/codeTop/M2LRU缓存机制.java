package com.liang.面试常考算法题.codeTop;

import java.util.HashMap;

public class M2LRU缓存机制 {


}
class LRUCache {
    private int capacity;
    private int size;
    private HashMap<Integer, Integer> map;
    DoubleList headDump;
    DoubleList tailDump;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size=0;
        headDump = new DoubleList(-1);
        tailDump = new DoubleList(-1);
        headDump.next = tailDump;
        headDump.prev = null;
        tailDump.next = null;
        tailDump.prev = headDump;
        map = new HashMap<>();
    }

    public int get(int key) {
        if (!map.containsKey(key))  return -1;
        addToHead(delVal(key));
        return map.get(key);
    }

    public void put(int key, int value) {
        if (!map.containsKey(key)){
            if (capacity==size){
                size--;
                removeLRU();
            }
            size++;
        } else{
            delVal(key);
        }
        map.put(key, value);
        addToHead(key);
    }
    public void addToHead(int val){
        DoubleList now = new DoubleList(val);
        now.next = headDump.next;
        now.prev = headDump;
        headDump.next = now;
        now.next.prev = now;
    }
    public void addToHead(DoubleList now){
        now.next = headDump.next;
        now.prev = headDump;
        headDump.next = now;
        now.next.prev = now;
    }
    public DoubleList delVal(int val){
        DoubleList node=headDump.next;
        while (node!=tailDump){
            if (node.val==val){
                node.next.prev = node.prev;
                node.prev.next = node.next;
                return node;
            }
            node = node.next;
        }
        return null;
    }
    public void removeLRU(){
        map.remove(tailDump.prev.val);
        tailDump.prev.prev.next = tailDump;
        tailDump.prev = tailDump.prev.prev;
    }

}
class DoubleList{
    DoubleList next;
    DoubleList prev;
    int val;
    public DoubleList(int val){
        this.val = val;
    }
}