package com.liang.笔试真题.商汤科技;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    }
    public int[][] rotate_img (int[][] img) {
        // write code here
        int n = img.length;
        int m = img[0].length;
        int[][] rs = new int[m][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                rs[j][n-i-1] = img[i][j];
            }
        }
        return rs;
    }
}
