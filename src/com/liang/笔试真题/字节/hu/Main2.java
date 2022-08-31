package com.liang.笔试真题.字节.hu;

import java.util.*;

public class Main2 {
    static HashMap<String, ArrayList<String>> map;
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        int n = sc.nextInt()-1;
        sc.nextLine();
        String s = sc.nextLine();
        String[] cac = s.split(" ");
        map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            s = sc.nextLine();
            String[] temp = s.split(" ");
            ArrayList<String> strings = new ArrayList<>();
            for (int j = 1; j < temp.length; j++) {
                strings.add(temp[j]);
            }
            map.put(temp[0], strings);
        }
        for (int i = 0; i < cac.length; i++) {
            if(dfs(cac[i], new boolean[10])){
                System.out.print(1);
            } else {
                System.out.print(0);
            }
            if (i!=cac.length-1){
                System.out.print(" ");
            }
        }
        System.out.println();

    }
    static boolean dfs(String a, boolean[] visit){
        int aN = Integer.parseInt(a);
        if (visit[aN]){
            return false;
        } else {
            boolean flag=true;
            if (!map.containsKey(a)){
                return true;
            }
            visit[aN] = true;
            ArrayList<String> strings = map.get(a);
            for (int i = 0; i < strings.size(); i++) {
                flag &= dfs(strings.get(i), visit);
            }
            visit[aN] = false;
            return flag;
        }
    }
}
