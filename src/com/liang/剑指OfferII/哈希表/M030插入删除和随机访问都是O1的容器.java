package com.liang.剑指OfferII.哈希表;

import com.liang.utils.ListNode;

import java.util.*;

public class M030插入删除和随机访问都是O1的容器 {


}
class RandomizedSet {
    public int length=0;
    HashMap<Integer, Integer> map;
    int[] nums;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        map = new HashMap<>();
        nums = new int[200000];
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val))   return false;
        map.put(val, length);
        nums[length++]=val;
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val))   return false;
        nums[map.get(val)]=nums[length-1];
        map.put(nums[length-1], map.get(val));
        length--;
        map.remove(val);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        Random random = new Random();
        int index = random.nextInt(length);
//        System.out.println(map);
        return nums[index];
    }
}
