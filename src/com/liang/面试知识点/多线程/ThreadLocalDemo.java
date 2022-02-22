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
    public ThreadLocal<Integer> a = new ThreadLocal<>();

    public static void main(String[] args) {
        ThreadLocalDemo threadLocalDemo = new ThreadLocalDemo();
        threadLocalDemo.a.set(3);
        Integer get = threadLocalDemo.a.get();
        Object o = loc.get();

//        new Thread(()->{
//            System.out.println(123);
//        }).start();
    }
}
