package com.liang.剑指OfferII.哈希表;

import java.util.*;

/**
 * @ProjectName: ProgrammingProblem
 * @Package: com.liang.剑指OfferII.哈希表
 * @ClassName: M033变位词组
 * @Description:
 * @Author: Yang Liang
 * @CreateDate: 2022/2/9 21:26
 * @Version: 1.0
 */
public class M033变位词组 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString((new char[]{'a', 'b'})));
    }
    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String s = String.valueOf(chars);
            if (!map.containsKey(s)){
                map.put(s,new ArrayList<>());
            }
            List<Integer> indices = map.get(s);
            indices.add(i);
        }
        List<List<String>> result = new ArrayList<>();
        for (String key :
                map.keySet()) {
            ArrayList<String> temp = new ArrayList<>();
            for (Integer i: map.get(key)) {
                temp.add(strs[i]);
            }
            result.add(temp);
        }
        return result;
    }
}
