package com.liang.leetcode.周赛;

/**
 * @Description: TODO
 * @Author: LiangYang
 * @Date: 2022/4/24 下午7:42
 **/
public class Apr0424_6042统计圆内格点数目 {
    public static void main(String[] args) {

    }
    public int countLatticePoints(int[][] circles) {
        int rs=0;
        for(int i=0;i<=200;i++){
            for (int j = 0; j <= 200; j++) {
                boolean ok = false;
                for (int k = 0; k < circles.length; k++) {
                    int x=circles[k][0];
                    int y = circles[k][1];
                    int r = circles[k][2];
                    if((i-x)*(i-x)+(j-y)*(j-y)<=r*r){
                        ok=true;
                    }
                }
                if (ok) rs++;
            }
        }
        return rs;
    }
}
