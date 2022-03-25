package com.liang.剑指offerI;

public class MOffer04二维数组找存在 {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10,13, 14, 17, 24},
                {18, 21, 23, 26, 30}};

        int[][] matrix1 = {
                {7, 11, 15},
                {8, 12, 19},
                {9, 16, 22},
                {14, 17, 24},
                {23, 26, 30}};

        int[][] matrix2 = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22}};

        System.out.println(findNumberIn2DArray(matrix2, 16));

    }

    static
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if(matrix.length==0) return false;
        if(matrix[0].length==0) return false;
        int w = matrix[0].length;
        int h = matrix.length;
        for (int i = 0; i < h; i++) {
            int left = 0;
            int right = w-1;

            while (left<=right){
                int middle = (left+right)/2;
                if(matrix[i][middle]==target){
                    return true;
                }
                else if(matrix[i][middle]<target){
                    left = middle+1;
                }else {
                    right = middle-1;
                }
            }
        }
        return false;
    }
}
