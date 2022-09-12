package com.liang.剑指OfferII.栈;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @ProjectName: ProgrammingProblem
 * @Package: com.liang.剑指OfferII.栈
 * @ClassName: M038每日温度
 * @Description:
 * @Author: Yang Liang
 * @CreateDate: 2022/2/20 0:08
 * @Version: 1.0
 */
public class M038每日温度 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(dailyTemperatures(new int[]{73,74,75,71,69,72,76,73})));
    }
    static
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] rs = new int[n];
        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && temperatures[stack.getFirst()]<temperatures[i]){
                int index = stack.pop();
                rs[index] = i-index;
            }
            stack.push(i);
        }
        return rs;
    }
}
