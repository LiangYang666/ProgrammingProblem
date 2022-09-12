package com.liang.剑指OfferII.数组;

import java.util.Arrays;

public class M013二维子矩阵的和 {

}
class NumMatrix {       // 前缀和
    private int[][] pre_sum;

    public NumMatrix(int[][] matrix) {
        int w = matrix[0].length;
        int h = matrix.length;
        pre_sum = new int[h][w + 1];
        for (int i = 0; i < h; i++) {
            pre_sum[i][0] = 0;
            for (int j = 0; j < w; j++) {
                pre_sum[i][j+1] = pre_sum[i][j]+matrix[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum =0;
        for (int i = row1; i < row2+1; i++) {
            sum+=pre_sum[i][col2+1]-pre_sum[i][col1];
        }
        return sum;
    }
}

class NumMatrix2 {      // 二维前缀和
    private int[][] pre_sum;

    public NumMatrix2(int[][] matrix) {
        int w = matrix[0].length;
        int h = matrix.length;
        pre_sum = new int[h+1][w + 1];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                pre_sum[i+1][j+1] = -pre_sum[i][j]+pre_sum[i+1][j]+pre_sum[i][j+1]+matrix[i][j];
            }
        }
        System.out.println(Arrays.deepToString(pre_sum));
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return pre_sum[row2+1][col2+1]-pre_sum[row1][col2+1]-pre_sum[row2+1][col1]+pre_sum[row1][col1];
    }
}