package com.liang.面试常考算法题.codeTop;

import java.util.LinkedList;

public class T13有效的括号 {
    public boolean isValid(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        Character[][] cc = {{'{', '}'}, {'[', ']'}, {'(',')'}};
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < cc.length; j++) {
                if (s.charAt(i)==cc[j][0]){
                    stack.push(cc[j][0]);
                } else if (s.charAt(i)==cc[j][1]){
                    if (stack.isEmpty() || stack.pop()!=cc[j][0]){
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }
}
