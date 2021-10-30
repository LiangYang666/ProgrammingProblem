package com.liang.offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Offer61扑克牌中的顺子 {
    public static void main(String[] args) {
        System.out.println(isStraight(new int[]{3, 5, 7, 2, 4}));
    }
    static
    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        List<Integer> numsList = (ArrayList<Integer>)Arrays.stream(nums).boxed().collect(Collectors.toList());
        System.out.println(numsList);
        int n0 = numsList.lastIndexOf(0)+1;
        if(n0==5)   return true;
        System.out.println(n0);
//        ArrayList<Integer> numsList = new ArrayList<Integer>();
        Integer[] no0Arrays = Arrays.copyOfRange(numsList.toArray(new Integer[0]), n0, 5);
        HashSet<Integer> set = new HashSet<>(Arrays.asList(no0Arrays));
        if(set.size()!=no0Arrays.length)    return false;
        if(numsList.get(4)-numsList.get(n0)<=4)
            return true;
        else
            return false;
    }
}
