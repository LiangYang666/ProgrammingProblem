package com.liang.面试知识点.多线程;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * @ProjectName: ProgrammingProblem
 * @Package: com.liang.面试知识点.多线程
 * @ClassName: AtomicDemo
 * @Description:
 * @Author: Yang Liang
 * @CreateDate: 2022/2/15 18:37
 * @Version: 1.0
 */
public class AtomicDemo {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(2);
        int i = atomicInteger.incrementAndGet();

    }
}
