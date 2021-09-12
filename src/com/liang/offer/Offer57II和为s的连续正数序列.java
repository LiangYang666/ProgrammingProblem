package com.liang.offer;

import java.util.ArrayList;
import java.util.Arrays;

public class Offer57II和为s的连续正数序列 {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(findContinuousSequence(15)));
    }
    static
    public int[][] findContinuousSequence(int target) {
        int l=1, r;
        r = (int)(Math.pow(target*2, 0.5)-1);
        int total = (r+1)*r/2;
        ArrayList<int[]> rs = new ArrayList<>();
        while(l<r){
            total = get_total(l, r);
            if (total==target){
                int[] temp = new int[r - l + 1];
                for (int i = 0; i < temp.length; i++) {
                    temp[i] = l+i;
                }
                rs.add(temp);
                l++;
            }
            else if (total<target){
                r++;
            } else {
                l++;
            }
//            System.out.println(""+l+r);
        }
        return rs.toArray(new int[rs.size()][]);
    }
    static
    int get_total(int l, int r){
        int n = r-l+1;
        return n*l+n*(n-1)/2;
    }
}
