package com.liang.面试知识点.多线程;

/**
 * @ProjectName: ProgrammingProblem
 * @Package: com.liang.面试知识点.多线程
 * @ClassName: ThreadLocalDemo
 * @Description:
 * @Author: Yang Liang
 * @CreateDate: 2022/1/30 19:43
 * @Version: 1.0
 */
public class ThreadLocalDemo {
    private static final ThreadLocal<Object> loc = new ThreadLocal<Object>();

    public static void main(String[] args) {
        Object o = loc.get();
    }
}
