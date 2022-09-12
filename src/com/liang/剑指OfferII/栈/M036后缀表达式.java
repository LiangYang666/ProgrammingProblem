package com.liang.剑指OfferII.栈;

import java.util.LinkedList;

/**
 * @ProjectName: ProgrammingProblem
 * @Package: com.liang.剑指OfferII.栈
 * @ClassName: M036后缀表达式
 * @Description:
 * @Author: Yang Liang
 * @CreateDate: 2022/2/10 21:08
 * @Version: 1.0
 */
public class M036后缀表达式 {
    public int evalRPN(String[] tokens) {
        LinkedList<Integer> stacks = new LinkedList<>();
        for (String token : tokens) {
            if(token.equals("+")){
                int a = stacks.pop();
                int b = stacks.pop();
                stacks.push(a+b);
            } else if (token.equals("-")){
                int a = stacks.pop();
                int b = stacks.pop();
                stacks.push(b-a);

            } else if (token.equals("*")){
                int a = stacks.pop();
                int b = stacks.pop();
                stacks.push(a*b);
            } else if (token.equals("/")){
                int a = stacks.pop();
                int b = stacks.pop();
                stacks.push(b/a);
            } else {
                stacks.push(Integer.parseInt(token));
            }
        }
        return stacks.isEmpty()?0:stacks.pop();
    }
}
