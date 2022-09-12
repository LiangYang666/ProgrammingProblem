package com.liang.类别.扫描线;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class DIndex391完美矩形 {

    public static void main(String[] args) {
        int[][] a = {{1,1,3,3},{3,1,4,2},{3,2,4,4},{1,3,2,4},{2,3,3,4}};
        int[][] b = {{1,2,4,4},{1,0,4,1},{0,2,1,3},{0,1,3,2},{3,1,4,2},{0,3,1,4},{0,0,1,1}};
        System.out.println(isRectangleCover(b));
    }

    static
    public boolean isRectangleCover(int[][] rectangles) {
        int n = rectangles.length;
        if(n==1)    return true;
        int[][] left = new int[n][3];
        int[][] right = new int[n][3];
        for (int i = 0; i < n; i++) {
            left[i][0] = rectangles[i][0];
            left[i][1] = rectangles[i][1];
            left[i][2] = rectangles[i][3];
            right[i][0] = rectangles[i][2];
            right[i][1] = rectangles[i][1];
            right[i][2] = rectangles[i][3];
        }
        Comparator<int[]> comparator = new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) {
                    return o1[0] - o2[0];
                } else {
                    if (o1[1] != o2[1]) {
                        return o1[1] - o2[1];
                    } else {
                        return o1[2] - o2[2];
                    }
                }
            }
        };
        Arrays.sort(left, comparator);
        Arrays.sort(right, comparator);
        System.out.println(Arrays.deepToString(left));
        System.out.println(Arrays.deepToString(right));
        int il = 0;
        int[] start = get_y1_y2(left,left[0][0],0, n);
        if(start[0]!=1)    return false;
        il = start[1];

        int ir = n-1;
        while(ir>=0 && right[n-1][0]==right[ir][0])  ir--;
        ir++;
        int[] end = get_y1_y2(right, right[n-1][0], ir, n);
        if(end[0]!=1)    return false;

        if(start[2]!=end[2] || start[3]!=end[3])    return false;
        int iil = il;
        int iir = 0;
        while (!(iil==n && iir==ir)){
            int now_x = left[iil][0];
            int[] left_y = get_y1_y2(left,now_x,iil, n);
            if(right[iir][0]!=now_x)    return false;
            int[] right_y = get_y1_y2(right,now_x,iir, ir);
            if (left_y[0]==-1||right_y[0]==-1)  return false;
            iil = left_y[1];
            iir = right_y[1];
            if(left_y[0]!=right_y[0])   return false;
            if(left_y[0]==-1) return false;
            for (int i = 0; i < left_y[0]; i++) {
                if(left_y[i*2+2]!=right_y[i*2+2] || left_y[i*2+3]!=right_y[i*2+3])    return false;
            }
            if(left_y[2]<start[2] || left_y[left_y.length-1]>start[3])    return false;
        }
        return true;
    }
    static
    int[] get_y1_y2(int[][] arr,int x, int l, int r){
        int i = l;
        ArrayList<Integer> ys = new ArrayList<>();
        ys.add(arr[i][1]);
        ys.add(arr[i][2]);
        i++;

        while(i<r && x==arr[i][0]){
            if(arr[i][1]<ys.get(ys.size()-1)){
                return new int[]{-1};
            }
            if(arr[i][1]>ys.get(ys.size()-1)){
                ys.add(arr[i][1]);
                ys.add(arr[i][2]);
            } else {
                ys.set(ys.size() - 1, arr[i][2]);
            }
            i++;
        }
        int[] rs = new int[ys.size() + 2];
        rs[0] = ys.size()/2;
        rs[1] = i;
        for (int j = 0; j < ys.size(); j++) {
            rs[j+2] = ys.get(j);
        }
        return rs;
    }


}
