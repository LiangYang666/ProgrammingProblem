package com.liang.normal;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.HashSet;

public class MIndex200岛屿数量 {

    public static void main(String[] args) {
        /*
          ["1","1","1","1","0"],
          ["1","1","0","1","0"],
          ["1","1","0","0","0"],
          ["0","0","0","0","0"]
         */
        char[][] grid = {
                        {'1', '1', '1', '1', '0'},
                        {'1', '1', '0', '1', '0'},
                        {'1', '1', '0', '0', '1'},
                        {'0', '0', '0', '0', '0'}};

//        char[][] grid = {{'1'}};

        System.out.println(numIslands(grid));
    }
    static HashMap<Integer, Integer> map = new HashMap<>();
    static HashMap<XY, Integer> locMap = new HashMap<>();

    static
    public int numIslands(char[][] grid) {
//        HashMap<Integer, XY> locMap = new HashMap<>();
        int m = grid.length;
        int n = grid[0].length;
        int k = 0;
        //第一步初始化所有map
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j]=='1'){
                    locMap.put(new XY(i, j), k);
                    map.put(k, k);
                    k++;
                }
            }
        }
        //第二步 合并
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j]=='1'){
                    int locIndex = locMap.get(new XY(i, j));
                    merge4Ori(grid, locIndex, i-1, j, m, n);
                    merge4Ori(grid, locIndex, i+1, j, m, n);
                    merge4Ori(grid, locIndex, i, j-1, m, n);
                    merge4Ori(grid, locIndex, i, j+1, m, n);
                }
            }
        }
        HashSet<Integer> rs = new HashSet<>();
        for (Integer key : map.keySet()) {
            rs.add(find(key));
        }

        return rs.size();
    }
    static
    public void merge4Ori(char[][]grid, int x, int i, int j, int m, int n){
        if(i<0 || j<0 || i>=m || j>=n)    return;
        if(grid[i][j]=='1'){
            map.put(find(locMap.get(new XY(i, j))), find(x));
        }
    }

    static
    public int find(int x){
        if(x==map.get(x)){
            return x;
        } else {
            return find(map.get(x));
        }
    }

    static class XY{
        @Override
        public int hashCode() {
            return x.hashCode()^y.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            if(this==obj){
                return true;
            } else if (obj instanceof XY){
                if(this.x.equals(((XY)(obj)).x) && this.y.equals(((XY)(obj)).y)){
                    return true;
                }
            }
            return false;
        }

        public Integer x;
        public Integer y;

        public XY(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
