package com.liang.类别.位运算;

import java.util.Arrays;
import java.util.Comparator;

public class MIndex318最大单词长度乘积 {
    public static void main(String[] args) {
        System.out.println(maxProduct(new String[]{"abcw","baz","foo","bar","xtfn","abcdef"}));
    }
    static
    public int maxProduct(String[] words) {
        int n = words.length;
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.length()-o1.length();
            }
        });
        int[] bits = new int[n];
        for (int i = 0; i < n; i++) {
            boolean[] abc = new boolean[26];
            for (int j = 0; j < words[i].length(); j++) {
                char c = words[i].charAt(j);
                int index = c-'a';
                if(!abc[index]){
                    abc[index] = true;
                    bits[i] |= (1<<index);
                }
            }
        }
//        System.out.println(Arrays.toString(bits));
        int max_mul = 0;
        for (int i = 0; i < n-1; i++) {
            if(max_mul>(words[i].length()*words[i+1].length())) break;
            for (int j = i; j < n; j++) {
                if((bits[i]&bits[j])==0){
                    System.out.println(Integer.toBinaryString(bits[i]));
                    System.out.println(Integer.toBinaryString(bits[i]));
                    max_mul = Math.max(words[i].length()* words[j].length(), max_mul);
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(words));
        return max_mul;
    }

}
