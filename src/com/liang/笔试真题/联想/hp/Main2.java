package com.liang.笔试真题.联想.hp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

/**
 * @ProjectName: ProgrammingProblem
 * @Package: com.liang.笔试真题.联想.hp
 * @ClassName: Main2
 * @Description:
 * @Author: Yang Liang
 * @CreateDate: 2022/8/21 19:41
 * @Version: 1.0
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        HashSet<String> strings = new HashSet<>();
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            strings.addAll(Arrays.asList(s.trim().split(" ")));
        }
        String[] arr = strings.toArray(new String[0]);
        Arrays.sort(arr);
        int l = 0;
        ArrayList<ArrayList<String>> rs = new ArrayList<>();
        ArrayList<String> temp = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (temp.size()!=0){
                l++;
            }
            if (l+arr[i].length()>50){
                System.out.print(temp.get(0));
                for (int j = 1; j < temp.size(); j++) {
                    System.out.print(" "+temp.get(j));
                }
                System.out.println();
                temp = new ArrayList<>();
                l = 0;
            }
            temp.add(arr[i]);
            l+=arr[i].length();
        }
        if (temp.size()>0){
            System.out.print(temp.get(0));
            for (int j = 1; j < temp.size(); j++) {
                System.out.print(" "+temp.get(j));
            }
            System.out.println();
        }
    }
}
