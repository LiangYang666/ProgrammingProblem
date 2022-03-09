package com.liang.剑指OfferII.队列;

import java.util.LinkedList;

/**
 * @ProjectName: ProgrammingProblem
 * @Package: com.liang.剑指OfferII.队列
 * @ClassName: S042最近的请求次数
 * @Description:
 * @Author: Yang Liang
 * @CreateDate: 2022/3/9 12:24
 * @Version: 1.0
 */
public class S042最近的请求次数 {
}
class RecentCounter {
    private LinkedList<Integer> queue;
    public RecentCounter() {
        queue = new LinkedList<>();
    }

    public int ping(int t) {
        queue.add(t);
        while (t-queue.getFirst()>3000){
            queue.poll();
        }
        return queue.size();
    }
}
