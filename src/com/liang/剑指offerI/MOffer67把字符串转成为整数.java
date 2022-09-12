package com.liang.剑指offerI;

public class MOffer67把字符串转成为整数 {
    public int strToInt(String str) {
        int[][] step_map = {
                {0, 1, 2, 3},
                {3, 3, 2, 3},
                {3, 3, 2, 3}};

        int[] nums = new int[str.length()];
        boolean neg = false;
        int step = 0;
        int j =0;
        for (int i = 0; i < str.length(); i++) {
            int get;
            char c = str.charAt(i);
            if(c==' ')  get=0;
            else if(c=='+' || c=='-') get=1;
            else if(c<='9' && c>='0')   get=2;
            else get=3;
            step = step_map[step][get];
            if (step==1) neg=(c=='-');
            else if(step==2) {
                if(j==0 && c=='0') {
                }
                else
                    nums[j++]=c-'0';
            }
            else if(step==3)    break;
        }
        if(j==0)    return 0;
        if(j>10)    return neg?Integer.MIN_VALUE:Integer.MAX_VALUE;
        long tmp = 0;

        for (int i = 0; i < j; i++) {
            tmp += (long)(nums[i])* (long)(Math.pow(10, j-i-1));
        }
        tmp = neg?-tmp:tmp;
        if(tmp<Integer.MIN_VALUE)   return Integer.MIN_VALUE;
        else if(tmp>Integer.MAX_VALUE) return Integer.MAX_VALUE;
        else return (int)tmp;
    }
}
