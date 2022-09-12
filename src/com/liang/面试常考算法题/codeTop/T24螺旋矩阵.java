package com.liang.面试常考算法题.codeTop;


import java.util.ArrayList;
import java.util.List;

public class T24螺旋矩阵 {
    public List<Integer> spiralOrder(int[][] matrix) {
        int[][] ori = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        int w = matrix[0].length;
        int h = matrix.length;
        int i=0, j=0;
        ArrayList<Integer> rs = new ArrayList<>();
        boolean[][] visited = new boolean[h][w];
        int total = w*h;
        int indexOri = 0;
        for (int k = 0; k < total; k++) {
            rs.add(matrix[i][j]);
            visited[i][j] = true;
            int jNext = j+ori[indexOri][0];
            int iNext = i+ori[indexOri][1];
            if (jNext>=w || jNext<0 || iNext>=h || iNext<0 || visited[iNext][jNext]){
                indexOri++;
                indexOri = indexOri%4;
            }
            j+=ori[indexOri][0];
            i+=ori[indexOri][1];
        }
        return rs;
    }
}
