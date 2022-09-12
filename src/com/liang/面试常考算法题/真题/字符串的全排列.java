package com.liang.面试常考算法题.真题;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * @ProjectName: ProgrammingProblem
 * @Package: com.liang.面试常考算法题.真题
 * @ClassName: 字符串的全排列
 * @Description:
 * @Author: Yang Liang
 * @CreateDate: 2022/4/26 11:03
 * @Version: 1.0
 */
public class 字符串的全排列 {
    static ArrayList<String> res = new ArrayList<>() ;
    static boolean[] visited;
    public static void main(String[] args) {
        String a = "ABABC";
        visited = new boolean[a.length()];
        char[] chars = a.toCharArray();
        dfs("", chars, visited, 0);
    }
    static
    void dfs(String srcStr, char[] chars, boolean[] visited, int count){
        if(visited.length==count){
            res.add(srcStr);
            return;
        }
        HashSet<Character> hasDone = new HashSet<>();
        for (int i = 0; i < chars.length; i++) {
            if (visited[i] || hasDone.contains(chars[i])) continue;
            visited[i] = true;
            hasDone.add(chars[i]);
            dfs(srcStr+chars[i], chars, visited, count+1);
            visited[i] = false;
        }
    }
}
