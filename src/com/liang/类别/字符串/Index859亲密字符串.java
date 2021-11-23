package com.liang.类别.字符串;

public class Index859亲密字符串 {
    public boolean buddyStrings(String s, String goal) {
        if (s.length()!=goal.length())  return false;
        if (s.length()<2)   return false;
        if(s.equals(goal)){
            int[] abNums = new int[26];
            for (int i = 0; i < s.length(); i++) {
                abNums[s.charAt(i)-'a']++;
                if (abNums[s.charAt(i)-'a']>=2){
                    return true;
                }
            }
            return false;
        }

        int[] indexes = new int[2];
        int total=0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)!=goal.charAt(i)){
                if (total==2)   return false;
                indexes[total++]=i;
                if (total==2){
                    if (!(s.charAt(indexes[0])==goal.charAt(indexes[1])
                            && s.charAt(indexes[1])==goal.charAt(indexes[0]))){
                        return false;
                    }
                }
            }
        }
        return total == 2;
    }
}
