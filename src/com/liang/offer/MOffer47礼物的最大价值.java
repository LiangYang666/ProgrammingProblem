package com.liang.offer;

public class MOffer47礼物的最大价值 {

    public static void main(String[] args) {

    }
    public int maxValue(int[][] grid) {     //递归做法
        int[][] reward = new int[grid.length][grid[0].length];
        return writeReward(grid, reward, grid.length-1, grid[0].length-1);
    }
    public int writeReward(int[][] grid, int[][] reward,  int i, int j){
        if(i<0 || j<0)  return 0;
        if(reward[i][j]!=0) return reward[i][j];
        reward[i][j] = grid[i][j] + Math.max(writeReward(grid, reward, i, j-1), writeReward(grid, reward, i-1, j));
        return reward[i][j];
    }
}
