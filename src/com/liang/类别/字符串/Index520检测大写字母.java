package com.liang.类别.字符串;

public class Index520检测大写字母 {
    public static void main(String[] args) {
        System.out.println(detectCapitalUse("ffffffffffffffffffffF"));
    }
    static
    public boolean detectCapitalUse(String word) {
        if (word.length()==1)   return true;
        if (Character.isLowerCase(word.charAt(0))){
            for (int i = 1; i < word.length(); i++) {
                char now = word.charAt(i);
                if(Character.isUpperCase(now))  return false;
            }
        } else {
            boolean flag = Character.isLowerCase(word.charAt(1));
            for (int i = 2; i < word.length(); i++) {
                if(Character.isLowerCase(word.charAt(i))!=flag)  return false;
            }
        }
        return true;
    }



    /*  自己的方法 逻辑一样 但未用java库
    public boolean detectCapitalUse(String word) {
        if (word.length()==1)   return true;
        char first = word.charAt(0);
        if(first<='z' && first>='a'){
            for (int i = 1; i < word.length(); i++) {
                char now = word.charAt(i);
                if (now > 'z' || now < 'a') {
                    return false;
                }
            }
        } else {
            char get = word.charAt(1);
            if (get > 'z' || get < 'a') {
                for (int i = 2; i < word.length(); i++) {
                    char now = word.charAt(i);
                    if (now <= 'z' && now >= 'a') {
                        return false;
                    }
                }
            }else  {
                for (int i = 2; i < word.length(); i++) {
                    char now = word.charAt(i);
                    if (now > 'z' || now < 'a') {
                        return false;
                    }
                }
            }

        }

        return true;
    }
    */
}
