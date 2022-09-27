package com.liang.笔试真题.信也科技;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    }
    public int getMinVolume (int[] volume, int t) {
        // write code here
        int rs = 0;
        for (int i = 0; i < volume.length; i++) {
            rs = Math.max(rs, volume[i]);
        }
        while (true) {
            if (check(volume, t, rs))   return rs;
            rs++;
        }
    }
    public boolean check(int[] volume, int t, int init){
        int temp = init;
        for (int i = 0; i < volume.length; i++) {
            if (temp<volume[i]){
                temp = init;
                t--;
            }
            if (t==-1)  return false;
            temp-=volume[i];
        }
        return true;
    }
}
