package com.liang.笔试真题.亚信;

/**
 * @Description: TODO
 * @Author: LiangYang
 * @Date: 2022/10/16 下午7:18
 **/
public class LC1 {
    public static void main(String[] args) {
        System.out.println(new LC1().func("123abccbaddffd"));
    }
    int start;
    int max;
    public String func(String s){
        max = 1;
        start = 0;
        for (int i = 0; i < s.length()-1; i++) {
            test(i, i, s);
            test(i, i+1, s);
        }
        if (max>1){
            return s.substring(start, start+max);
        }
        return "-1";
    }
    public void test(int l, int r, String s){
        while (l>=0 && r<s.length()){
            if (s.charAt(l)==s.charAt(r)){
                l--;
                r++;
            } else {
                break;
            }
        }
        if ((r-l-1)>max){
            max = r-l-1;
            start = l+1;
//            System.out.println(start+" "+max);
        }
    }
}
