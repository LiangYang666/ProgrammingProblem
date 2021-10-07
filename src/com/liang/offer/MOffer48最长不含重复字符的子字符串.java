package com.liang.offer;

public class MOffer48最长不含重复字符的子字符串 {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring(" "));
    }
    static
    public int lengthOfLongestSubstring(String s) {
        int[] a = new int[256];
        for (int i = 0; i < a.length; i++) {
            a[i] = -1;
        }
        int max_length = 0;
        int l = 0;
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i);
            if(a[c]>=l){
                l=a[c]+1;
            }
            a[c] = i;
            max_length = Math.max(i+1-l, max_length);
        }
        return max_length;

    }
}
