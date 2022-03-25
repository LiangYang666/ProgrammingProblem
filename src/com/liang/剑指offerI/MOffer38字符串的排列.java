package com.liang.剑指offerI;

import java.util.*;

public class MOffer38字符串的排列 {   // 递归做
    public static void main(String[] args) {
        MOffer38字符串的排列 per = new MOffer38字符串的排列();
        System.out.println(Arrays.toString(per.permutation("abca")));

    }

    private Set<String> rs;

    public String[] permutation(String s) {
//        rs = new ArrayList<String>();
        rs = new HashSet<>();
        dp(s.toCharArray(), new boolean[s.length()], "");

        return rs.toArray(new String[0]);
    }
    public void dp(char[] s, boolean[] visited, String has){
        if(has.length()==s.length){
            rs.add(has);
            return;
        }
        for (int i = 0; i < s.length; i++) {
            if(!visited[i]){
                visited[i] = true;
                dp(s, visited, has+s[i]);
                visited[i] = false;
            }
        }
    }
}
class MOffer38字符串的排列_下一个排列做 {
    public static void main(String[] args) {
        MOffer38字符串的排列_下一个排列做 per = new MOffer38字符串的排列_下一个排列做();
        System.out.println(Arrays.toString(per.permutation("abca")));
    }

    public String[] permutation(String s) {
        char[] chars = s.toCharArray();
        ArrayList<String> rs = new ArrayList<>();
        Arrays.sort(chars);
        rs.add(String.copyValueOf(chars));
        while(true){
            if(nextPermutation(chars))
                rs.add(String.copyValueOf(chars));
            else
                break;
        }
        return rs.toArray(new String[0]);
    }
    public boolean nextPermutation(char[] chars){
        int end = chars.length-1;
        int i=0, j=0;
        boolean flag=false;
        for (int k = end; k > 0 ; k--) {
            if(chars[k-1]<chars[k]){
                i = k-1;
                j= k;
                flag = true;
                break;
            }
        }
        if(!flag) return false;
        for (int k = end; k >=j ; k--) {
            if(chars[k]>chars[i]){
                char temp = chars[k];
                chars[k] = chars[i];
                chars[i] = temp;
                break;
            }
        }
        for(int k=j;k<=(j+end)/2;k++){
            char temp = chars[k];
            chars[k] = chars[end-(k-j)];
            chars[end-(k-j)] = temp;
        }
        return true;
    }
}
