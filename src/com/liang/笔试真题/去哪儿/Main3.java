package com.liang.笔试真题.去哪儿;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @ProjectName: ProgrammingProblem
 * @Package: com.liang.笔试真题.去哪儿
 * @ClassName: Main3
 * @Description:
 * @Author: Yang Liang
 * @CreateDate: 2022/9/7 13:50
 * @Version: 1.0
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    }
    public String showDown (String inHand) {
        // write code here
        String[] s = inHand.split(" ");
        HashMap<Character, Integer> huaMap = new HashMap<>();
        huaMap.put('S', 0);
        huaMap.put('H', 1);
        huaMap.put('C', 2);
        huaMap.put('D', 3);

        HashMap<Character, Integer> numberMap = new HashMap<>();
        numberMap.put('J', 11);
        numberMap.put('Q', 12);
        numberMap.put('K', 13);
        numberMap.put('A', 1);
        numberMap.put('1', 10);

        boolean[][] have = new boolean[4][14];
        for (int i = 0; i < s.length; i++) {
            int h = huaMap.get(s[i].charAt(0));
            int n = numberMap.getOrDefault(s[i].charAt(1), s[i].charAt(1)-'0');
            have[h][n] = true;
        }
        for (int i = 0; i < 4; i++) {
            if (have[i][1]){
                for (int j = 10; j < 14; j++) {
                    if (!have[i][j]){
                        break;
                    } else if (j==13){
                        return "HuangJiaTongHuaShun";
                    }
                }
            }
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 1; j < 10; j++) {
                for (int k = 0; k < 5; k++) {
                    if (!have[i][j+k]){
                        break;
                    } else if (k==4){
                        return "TongHuaShun";
                    }
                }
            }
        }

        for (int j = 1; j < 14; j++) {
            for (int i = 0; i < 4; i++) {
                if (!have[i][j]){
                    break;
                } else if (i==3){
                    return "SiTiao";
                }
            }
        }
        boolean[] flags = new boolean[2];
        for (int j = 1; j < 14; j++) {
            int count = 0;
            for (int i = 0; i < 4; i++) {
                if (have[i][j]){
                    count++;
                }
            }
            if (count==2){
                flags[0] = true;
            }
            if (count>2){
                if (flags[1])
                    flags[0] = true;
                else
                    flags[1] = true;
            }
        }
        if (flags[0]&&flags[1]) return "HuLu";


        for (int i = 0; i < 4; i++) {
            int count = 0;
            for (int j = 1; j < 14; j++) {
                if (have[i][j]) count++;
            }
            if (count>=5)   return "TongHua";
        }

        for (int j = 1; j < 11; j++) {
            for (int k = 0; k < 5; k++) {
                int jk = j+k;
                if (jk==14) jk=1;
                boolean tempFlag = false;
                for (int i = 0; i < 4; i++) {
                    tempFlag |= have[i][jk];
                }
                if (!tempFlag) break;
                else if (k==4){
                    return "ShunZi";
                }
            }
        }


        for (int j = 1; j < 14; j++) {
            int count = 0;
            for (int i = 0; i < 4; i++) {
                if (have[i][j]){
                    count++;
                }
            }
            if (count==3){
                return "SanTiao";
            }
        }

        int flagCount = 0;
        for (int j = 1; j < 14; j++) {
            int count = 0;
            for (int i = 0; i < 4; i++) {
                if (have[i][j]){
                    count++;
                }
            }
            if (count>=2){
                flagCount++;
            }
        }
        if (flagCount>=2) return "LiangDui";
        else if (flagCount==1)  return "YiDui";
        return "GaoPai";
    }
}
