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
    private static final ThreadLocal<Object> loc = new ThreadLocal<Object>();   // 永远有强引用，不会被删
    public ThreadLocal<Integer> a = new ThreadLocal<>();    //实例被释放了则强引用消失，只剩下map里的弱引用，会被gc

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
