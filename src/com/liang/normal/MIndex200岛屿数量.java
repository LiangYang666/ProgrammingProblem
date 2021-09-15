package com.liang.normal;

import javafx.util.Pair;

import java.util.HashMap;

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
                        {'1', '1', '0', '0', '0'},
                        {'0', '0', '0', '0', '0'}};
        XY xy1 = new XY(1, 2);
        XY xy2 = new XY(7, 9);
        XY xy3 = new XY(9, 7);
        HashMap<XY, Integer> map = new HashMap<>();
        map.put(xy1, 1);
        map.put(xy2, 2);
        map.put(xy3, 3);
        System.out.println(map.get(new XY(1, 3)));
        System.out.println(map.get(new XY(7, 9)));
        System.out.println(map.get(new XY(9, 7)));

//        System.out.println(numIslands(grid));
    }
    static HashMap<Integer, Integer> m = new HashMap<>();

    static
    public int numIslands(char[][] grid) {
//        HashMap<Integer, XY> locMap = new HashMap<>();
        HashMap<XY, Integer> locMap = new HashMap<>();
        int k = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j]=='1'){
                    locMap.put(new XY(i, j), k);
//                    locMap.get()
                    m.put(k, k);
                    k++;
                }
            }
        }
        return 0;
    }

    static
    public int find(int x){
        if(x==m.get(x)){
            return x;
        } else {
            return find(x);
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
