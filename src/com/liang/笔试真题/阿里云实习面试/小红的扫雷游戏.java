package com.liang.笔试真题.阿里云实习面试;

import java.util.Scanner;

public class 小红的扫雷游戏 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(2 << 16);
        char[][] nums = new char[4][4];
        int mask=(1<<16)-1;
        for (int i = 0; i < 4; i++) {
            String s = scanner.nextLine();
            for (int j = 0; j < 4; j++) {
                nums[i][j] = s.charAt(j);
                if(nums[i][j]!='.'){
                    mask -= (1<<(i*4+j));
                }
            }
        }
        //遍历每种可能的方案 再做验证
        for (int n = 0; n < (1 << 16); n++) {
            char[][] temp = new char[4][4];
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    temp[i][j] = nums[i][j];
                }
            }
            int num=n&mask;
            boolean flag = true;    // 验证flag
            for (int i = 0; i < 4 && flag; i++) {
                for (int j = 0; j < 4 && flag; j++) {
                    if(nums[i][j]!='.'){
                        int count=0;
                        for (int x = -1; x <= 1; x++) {
                            for (int y = -1; y <=1; y++) {
                                if(x==0 && y==0)    continue;
                                int nx=i+x;
                                int ny = j+y;
                                int index = nx*4+ny;
                                if(nx>=0 && nx<4 && ny>=0 && ny<4){
                                    if(nums[nx][ny]!='.') continue;
                                    if(((num>>index)&1)!=0){
                                        temp[nx][ny] = 'X';
                                        count++;
                                    } else {
                                        temp[nx][ny] = 'O';
                                    }
                                }
                            }
                        }
                        if (count!=nums[i][j]-'0') flag=false;
                    }
                }
            }
            if(flag){
                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j < 4; j++) {
                        System.out.print(temp[i][j]);
                    }
                    System.out.println();
                }
                break;
            }
        }

//        System.out.println(Arrays.deepToString(input));

    }
}
