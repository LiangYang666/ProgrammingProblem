package com.liang.剑指OfferII.哈希表;

import java.util.HashMap;

/**
 * @ProjectName: ProgrammingProblem
 * @Package: com.liang.剑指OfferII.哈希表
 * @ClassName: S034外星语言是否排序
 * @Description:
 * @Author: Yang Liang
 * @CreateDate: 2022/2/9 22:37
 * @Version: 1.0
 */
public class S034外星语言是否排序 {

    public boolean isAlienSorted(String[] words, String order) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            map.put(order.charAt(i), i);
        }
        for (int i = 0; i < words.length - 1; i++) {
            String a = words[i];
            String b = words[i+1];
            boolean flag = false;
            for (int j = 0; j < Math.min(a.length(), b.length()); j++) {
                int aTempIndex = map.get(a.charAt(j));
                int bTempIndex = map.get(b.charAt(j));
                if (aTempIndex>bTempIndex)  return false;
                else if (aTempIndex<bTempIndex) {
                    flag = true;
                    break;
                };
            }
            if (!flag && a.length()>b.length())  return false;
        }
        return true;
    }
}
