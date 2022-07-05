package com.liang.面试常考算法题.codeTop;

import java.util.HashMap;

public class T3LRU缓存机制 {


}
class LRUCache {
    private int capacity;
    private DoubleList listHead = new DoubleList(-1);
    private DoubleList listTail = new DoubleList(-1);
    private HashMap<Integer, Integer> keyValue = new HashMap<>();
    private HashMap<Integer, DoubleList> keyPosition = new HashMap<>();
    public LRUCache(int capacity) {
        listHead.next = listTail;
        listHead.pre = null;
        listTail.next = null;
        listTail.pre = listHead;
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!keyValue.containsKey(key)){
            return -1;
        }
        DoubleList node = deleteKey(keyPosition.get(key));
        insertToHead(node);
        return keyValue.get(key);
    }

    public void put(int key, int value) {
        DoubleList now = null;
        if (keyValue.containsKey(key)){
            DoubleList node = deleteKey(keyPosition.get(key));
            insertToHead(node);
            keyValue.put(key, value);
        } else {
            if (keyValue.size() == capacity) {
                DoubleList willDelete = deleteLast();
                keyValue.remove(willDelete.val);
                keyPosition.remove(willDelete.val);
            }
            DoubleList node = new DoubleList(key);
            insertToHead(node);
            keyValue.put(key, value);
            keyPosition.put(key, node);
        }
    }
    private DoubleList deleteKey(DoubleList node){
        node.next.pre = node.pre;
        node.pre.next = node.next;
        return node;
    }
    private DoubleList deleteLast(){
        return deleteKey(listTail.pre);
    }
    private void insertToHead(DoubleList node){
        node.next = listHead.next;
        node.pre = listHead;
        node.pre.next = node;
        node.next.pre = node;
    }

}

class DoubleList{
    DoubleList pre;
    DoubleList next;
    int val;
    public DoubleList(int val){
        this.val = val;
    }
}