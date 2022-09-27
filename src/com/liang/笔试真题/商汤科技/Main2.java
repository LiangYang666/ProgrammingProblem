package com.liang.笔试真题.商汤科技;

import java.util.*;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    }
    public int[] topKFrequent (int[] nums, int k) {
        // write code here
        Arrays.sort(nums);
        int last = nums[0];
        int sum = 1;
//        ArrayList<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i < nums.length; i++) {
            if (last==nums[i]){
                sum++;
            } else {
                map.put(last, sum);
                sum = 1;
                last = nums[i];
            }
        }
        map.put(last, sum);
        int[][] temp = new int[map.size()][2];
        int i = 0;
        for (Integer integer : map.keySet()) {
            temp[i][0] = integer;
            temp[i][1] = map.get(integer);
            i++;
        }
        Arrays.sort(temp, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1]-o1[1];
            }
        });
        int[] rs = new int[k];
        for (int j = 0; j < k; j++) {
            rs[j] = temp[j][0];
        }
        Arrays.sort(rs);
        return rs;
    }
}
