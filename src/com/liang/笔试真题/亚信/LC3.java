package com.liang.笔试真题.亚信;

import java.util.Arrays;

/**
 * @Description: TODO
 * @Author: LiangYang
 * @Date: 2022/10/16 下午7:40
 **/
public class LC3 {
    public static void main(String[] args) {
        System.out.println(new LC3().func(4, new int[]{1, 2, 3, 4, 5}));
        System.out.println(new LC3().func(8, new int[]{2, 5, 9, 13, 21, 35}));
    }
    public int func(int d, int[] array){
        Arrays.sort(array);
        int n = array.length;
        int rs = 0;
        int l = 0;
        for (int r = 2; r < n; r++) {
            while ((array[r]-array[l])>d){
                l++;
            }
            if ((r-l)>=2){
                int t = r-l;
                rs+= t *(t-1)/2;
            }
        }
        return rs;
    }
}
