package com.liang.test;

import java.util.HashMap;
import java.util.Scanner;

//华为机试 小朋友 游戏分组
public class 并查集_游戏分组 {
    static HashMap<String, String> m;

    static
    public String find(String name){
        if(name.equals(m.get(name))){
            return name;
        } else {
            return find(m.get(name));
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine().trim());
        String[][] get_s = new String[N][2];
        for (int i = 0; i < N; i++) {
            String[] ss = scanner.nextLine().trim().split(" ");
            get_s[i][0] = ss[0];
            get_s[i][1] = ss[1];
            m.putIfAbsent(ss[0], ss[0]);
            m.putIfAbsent(ss[1], ss[1]);
        }
        for (int i = 0; i < N; i++) {
            m.put(m.get(find(get_s[i][1])), m.get(find(get_s[i][0])));
        }
        int total=0;
        for (String key :
                m.keySet()) {
            if(key.equals(m.get(key))){
                total+=1;
            }
        }
        System.out.println(total);
    }

}
