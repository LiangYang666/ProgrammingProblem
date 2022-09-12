package com.liang.剑指OfferII.栈;

import java.util.LinkedList;

/**
 * @ProjectName: ProgrammingProblem
 * @Package: com.liang.剑指OfferII.栈
 * @ClassName: m037小行星碰撞
 * @Description:
 * @Author: Yang Liang
 * @CreateDate: 2022/2/10 21:31
 * @Version: 1.0
 */
public class M037小行星碰撞 {
    public int[] asteroidCollision(int[] asteroids) {
        LinkedList<Integer> stacks = new LinkedList<>();
        for (int i = 0; i < asteroids.length; i++) {
            int asteroid = asteroids[i];
            if (asteroid>0){
                stacks.push(asteroid);
            } else {
                int last;
                if (stacks.isEmpty() || (last=stacks.getFirst())<0){
                    stacks.push(asteroid);
                } else {
                    if (last+asteroid<=0){
                        stacks.pop();
                        if (last+asteroid<0){
                            i--;
                        }
                    }
                }
            }
        }
        int[] rs = new int[stacks.size()];
        int size = stacks.size();
        for (int i = 0; i < size; i++) {
            rs[i] = stacks.removeLast();
        }
        return rs;
    }
}
