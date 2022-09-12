package com.liang.剑指OfferII.哈希表;

import java.util.HashMap;

/**
 * @ProjectName: ProgrammingProblem
 * @Package: com.liang.剑指OfferII.哈希表
 * @ClassName: S032有效的变位词
 * @Description:
 * @Author: Yang Liang
 * @CreateDate: 2022/2/9 21:09
 * @Version: 1.0
 */
public class S032有效的变位词 {
    public static void main(String[] args) {
        System.out.println(isAnagram("a", "a"));
    }
    static
    public boolean isAnagram(String s, String t) {
//        HashMap<Character, Integer> charNumbers = new HashMap<>();
        int[] charNumbers = new int[26];
        if (s.length()!=t.length()) return false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            charNumbers[c-'a']++;
            c = t.charAt(i);
            charNumbers[c-'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (charNumbers[i]!=0)  return false;
        }
        return !s.equals(t);
    }
}
